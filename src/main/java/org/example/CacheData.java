package org.example;


import lombok.Getter;
import lombok.Setter;
import org.example.entity.UserRole;
public class CacheData {
    @Getter
    @Setter
    private static String currentSessionUserName;
    @Getter
    @Setter
    private static UserRole userRole;
    @Getter
    @Setter
    private static String step;



    public static void resetSession() {
        setCurrentSessionUserName("");

    }

}
