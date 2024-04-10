package org.example;

import java.lang.reflect.Method;

public class CommandHandler {

private CommandController commandController;

    public CommandHandler(CommandController commandController) {
        this.commandController = commandController;
    }

    public void executeMethod(String methodName, String... args) {
        try {
            Method method;
            Class<?>[] parameterTypes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                parameterTypes[i] = String.class;
            }

            if (args.length == 0) {
                method = commandController.getClass().getMethod(methodName);
                method.invoke(commandController);
            } else {
                method = commandController.getClass().getMethod(methodName, parameterTypes);
                method.invoke(commandController, (Object[]) args);
            }
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении метода: " + e.getMessage());
        }
    }
}
