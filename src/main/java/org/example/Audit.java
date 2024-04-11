package org.example;

public class Audit {
    public static void listen (){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();


        if (stackTraceElements.length >= 3) {
            String callingClassName = stackTraceElements[2].getClassName();
            String callingMethodName = stackTraceElements[2].getMethodName();

            System.out.println("Пользователем: " + CacheData.getCurrentSessionUserName() + " Был вызван метод " + callingMethodName + " класса " + callingClassName );
        } else {
            System.out.println("Невозможно определить вызывающий метод.");
        }
    }

}
