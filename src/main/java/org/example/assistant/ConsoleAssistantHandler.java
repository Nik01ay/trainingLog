package org.example.assistant;

import lombok.SneakyThrows;
import org.example.Security;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ConsoleAssistantHandler {
    private final ConsoleAssistant consoleAssistant = new ConsoleAssistant();
    private final Security security;

    public ConsoleAssistantHandler(Security security) {
        this.security = security;
    }

    @SneakyThrows
    public void callAssistant() {

        Method method;
       for(String methodName : security.getAcseccMethodsNames())

        {
                method = consoleAssistant.getClass().getMethod(methodName);
                method.invoke(consoleAssistant);


        };
    }
}
