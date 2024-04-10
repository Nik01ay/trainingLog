package org.example;

import java.lang.reflect.Method;

public class CommandHandler {

private CommandController commandController = new CommandController(); //  todo заменить на иньекции

    public void executeMethod(String methodName, String... args) {
        try {
            Method method;
            if (args.length == 0) {
                method = commandController.getClass().getMethod(methodName);
                method.invoke(commandController);
            } else {
                method = commandController.getClass().getMethod(methodName, String.class, String.class);
                method.invoke(commandController, args);
            }
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении метода: " + e.getMessage());
        }
    }
}
