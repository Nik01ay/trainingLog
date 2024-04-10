package org.example;


import lombok.Getter;
import lombok.Setter;

public class CacheData {
    @Getter
    @Setter
        private static String currentSessionUserName;

    public static void resetSession(){
        setCurrentSessionUserName("");
    }
}
