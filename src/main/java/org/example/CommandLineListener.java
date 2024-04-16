package org.example;

import org.example.assistant.ConsoleAssistantHandler;

import java.util.Scanner;

public class CommandLineListener {

    private final   CommandHandler commandHandler ;

    private final ConsoleAssistantHandler consoleAssistantHandler;

    public CommandLineListener(CommandHandler commandHandler, ConsoleAssistantHandler consoleAssistantHandler) {
        this.commandHandler = commandHandler;
        this.consoleAssistantHandler = consoleAssistantHandler;
    }

    void run() {
        String input = "START";
        while (!input.equals("EXIT")) {
            Scanner scanner = new Scanner(System.in);

            consoleAssistantHandler.callAssistant();

            input = scanner.nextLine();
            String[] parts = input.split(" ");
            if ((input != null) && (!input.equals("EXIT"))) {

                try {
                    String command = parts[0];
                    String[] args = new String[parts.length - 1];
                    System.arraycopy(parts, 1, args, 0, args.length);
                    commandHandler.executeMethod(command, args);
                } catch (Exception e) {
                    System.out.println("Error " + e.getMessage());
                }
            }

        }
        System.out.println("THE END");
    }
}
