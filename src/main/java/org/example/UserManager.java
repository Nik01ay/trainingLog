package org.example;

import org.example.entity.UserEntity;
import org.example.entity.UserRole;
import org.example.inMemoryRepo.UserInMemoryRepo;

public class UserManager {
    private UserInMemoryRepo userRepo;

    public UserManager(UserInMemoryRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void addNewUser(String userName, String password, String userStringRole) {
        UserEntity newUser = new UserEntity();
        newUser.setName(userName);
        newUser.setPassword(password);
        if(userStringRole.equals(UserRole.ADMIN.toString())) {
            newUser.setRole(UserRole.ADMIN);
        } else newUser.setRole(UserRole.USER);

        userRepo.addUser(newUser);
    }

    public String identificationUser(String userName, String password) {
        UserEntity user = userRepo.getUserByName(userName);
        if (userRepo.authentication(user, password)){
            CacheData.setCurrentSessionUserName(user.getName());
            System.out.println("Авторизация успешна"); //todo Логгер
            return  CacheData.getCurrentSessionUserName();
        }       return "Неверное имя или пароль";
    }

   public void logout(){
        CacheData.resetSession();
   }
}
