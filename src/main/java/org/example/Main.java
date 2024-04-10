package org.example;

import org.example.inMemoryRepo.UserInMemoryRepo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        UserManager userManager = new UserManager(new UserInMemoryRepo());

        CommandController commandController = new CommandController(userManager);
        CommandHandler commandHandler = new CommandHandler(commandController);
        CommandLineListener commandLineListener = new CommandLineListener(commandHandler);



        commandLineListener.run();


    }
}