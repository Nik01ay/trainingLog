package org.example;

import org.example.assistant.ConsoleAssistant;
import org.example.assistant.ConsoleAssistantHandler;
import org.example.in.CommandController;
import org.example.inMemoryRepo.TrainingLogInMemoryRepo;
import org.example.inMemoryRepo.TrainingParameterInMemoryRepo;
import org.example.inMemoryRepo.TrainingTypeInMemoryRepo;
import org.example.inMemoryRepo.UserInMemoryRepo;
import org.example.manager.TrainingManager;
import org.example.manager.UserManager;

public class Main {
    public static void main(String[] args) {

        UserInMemoryRepo userInMemoryRepo = new UserInMemoryRepo();
        Security security = new Security(userInMemoryRepo);
        UserManager userManager = new UserManager(userInMemoryRepo, security);

        TrainingLogInMemoryRepo trainingLogInMemoryRepo = new TrainingLogInMemoryRepo();
        TrainingParameterInMemoryRepo trainingParameterInMemoryRepo = new TrainingParameterInMemoryRepo();
        TrainingTypeInMemoryRepo trainingTypeInMemoryRepo = new TrainingTypeInMemoryRepo();
        TrainingManager trainingManager = new TrainingManager(trainingLogInMemoryRepo,
                trainingParameterInMemoryRepo, trainingTypeInMemoryRepo, security);

        ConsoleAssistantHandler consoleAssistantHandler = new ConsoleAssistantHandler(security);

        CommandController commandController = new CommandController(userManager, trainingManager);
        CommandHandler commandHandler = new CommandHandler(commandController);

        CommandLineListener commandLineListener = new CommandLineListener(commandHandler, consoleAssistantHandler);


        commandLineListener.run();


    }
}