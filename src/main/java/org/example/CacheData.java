package org.example;


import lombok.Getter;
import lombok.Setter;
import org.example.entity.UserRole;
import org.example.inMemoryRepo.UserInMemoryRepo;

public class CacheData {
    @Getter
    @Setter
    private static String currentSessionUserName;
    @Getter
    @Setter
    private static UserRole userRole;



    public static void resetSession() {
        setCurrentSessionUserName("");

    }

}
