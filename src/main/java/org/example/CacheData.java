package org.example;


import lombok.Getter;
import lombok.Setter;
import org.example.entity.UserRole;

import java.util.List;

public class CacheData {
    @Getter
    @Setter
    private static String currentSessionUserName;
    @Getter
    @Setter
    private static UserRole userRole;
    @Getter
    @Setter
    private static int countTrainingParameter;
    @Getter
    @Setter
    private static int countTrainingType;
    @Getter
    @Setter
    private static int countTraining;
    @Getter
    @Setter
    private static int countUser;


    /**
     * Удаление данных о пользователе из сессии
     */
    public static void resetSession() {
        setCurrentSessionUserName("");
        setUserRole(UserRole.USER);
    }

}
