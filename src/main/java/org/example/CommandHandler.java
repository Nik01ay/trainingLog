package org.example;

import org.example.in.CommandController;

import java.lang.reflect.Method;

public class CommandHandler {

private final CommandController commandController;

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
               try {
                method = commandController.getClass().getMethod(methodName, parameterTypes);
                method.invoke(commandController, (Object[]) args);
                } catch (Exception e){
                   method = commandController.getClass().getMethod(methodName, String[].class);
                   method.invoke(commandController, (Object) args);
               }
            }
        } catch (Exception e) {
            System.out.println("Error while executing method: " + e.getMessage());
        }
    }
}
