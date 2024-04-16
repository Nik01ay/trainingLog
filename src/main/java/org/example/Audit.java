package org.example;

/**
 * Аудит
 */
public class Audit {
    public static void listen (){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();


        if (stackTraceElements.length >= 3) {
            String callingClassName = stackTraceElements[2].getClassName();
            String callingMethodName = stackTraceElements[2].getMethodName();

            System.out.println("User: " //+ CacheData.getCurrentSessionUserName()
                    + " called the " + callingMethodName
                    + " method of the " + callingClassName + " class" );
        } else {
            System.out.println("Cannot determine calling method.");
        }
    }

}
