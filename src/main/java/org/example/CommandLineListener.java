package org.example;

import java.util.Scanner;

public class CommandLineListener {

    private   CommandHandler commandHandler ;

    public CommandLineListener(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    void run() {
        String input = "START";
        while (!input.equals("EXIT")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\n" +
                    "enter the command and arguments separated by a space: ");
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
