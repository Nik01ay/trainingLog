package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.UserRole;
import org.example.inMemoryRepo.UserInMemoryRepo;

import java.util.ArrayList;
import java.util.List;

public class Security {

    private final UserInMemoryRepo userRepo;

    @Getter
    private final List<String> acseccMethodsNames;

    /**
     * Конструктор
     * @param userRepo
     */
    public Security(UserInMemoryRepo userRepo) {
        this.userRepo = userRepo;
        acseccMethodsNames = new ArrayList<>();
        acseccMethodsNames.add("addNewUser");
    }

    /**
     * Аутентификация
     * @param user
     * @param password
     * @return true если успешно прошли аутентификацию
     */
    public boolean authentification(String user, String password) {

        if (userRepo.getUserByName(user)
                .getPassword()
                .equals(password)) {
            CacheData.setCurrentSessionUserName(user);
            CacheData.setUserRole(userRepo.getUserByName(user).getRole());
            refreshAcsessMethod();
            return true;
        }
            return false;

    }

    /**
     *  Метод выхода
     * @return  false всегда
     */
    public boolean logout() {
        CacheData.resetSession();
        acseccMethodsNames.clear();
        acseccMethodsNames.add("addNewUser");
        acseccMethodsNames.add("login");
        return false;
    }

    public void refreshAcsessMethod() {
    acseccMethodsNames.clear();
        if (CacheData.getCurrentSessionUserName()!=null) {
            UserRole role = CacheData.getUserRole();
            acseccMethodsNames.add("logout");
            if (role.equals(UserRole.ADMIN)) {
                if (CacheData.getCountTraining() > 0) {
                    acseccMethodsNames.add("statistic");
                    acseccMethodsNames.add("showAllTraining");
                    acseccMethodsNames.add("getAllAndSortedByDay");
                }
            } else {
                acseccMethodsNames.add("addParameter");
                if (CacheData.getCountTrainingParameter() > 0) {
                    acseccMethodsNames.add("addTrainingType");
                }
                if (CacheData.getCountTrainingType() > 0) {
                    acseccMethodsNames.add("addTraining");
                }
                if (CacheData.getCountTraining() > 0) {
                    acseccMethodsNames.add("edit");
                    acseccMethodsNames.add("dellTraining");
                    acseccMethodsNames.add("statistic");
                    acseccMethodsNames.add("getAllAndSortedByDay");
                }
            }
        } else {
            acseccMethodsNames.add("login");
            acseccMethodsNames.add("addNewUser");

        }
    }
}
