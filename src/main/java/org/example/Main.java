package org.example;

import org.example.in.CommandController;
import org.example.inMemoryRepo.TrainingLogInMemoryRepo;
import org.example.inMemoryRepo.TrainingParameterInMemoryRepo;
import org.example.inMemoryRepo.TrainingTypeInMemoryRepo;
import org.example.inMemoryRepo.UserInMemoryRepo;
import org.example.manager.TrainingManager;
import org.example.manager.UserManager;

public class Main {
    public static void main(String[] args) {

        UserManager userManager = new UserManager(new UserInMemoryRepo());
        TrainingLogInMemoryRepo trainingLogInMemoryRepo = new TrainingLogInMemoryRepo();
        TrainingParameterInMemoryRepo trainingParameterInMemoryRepo = new TrainingParameterInMemoryRepo();
        TrainingTypeInMemoryRepo trainingTypeInMemoryRepo = new TrainingTypeInMemoryRepo();
        TrainingManager trainingManager = new TrainingManager(trainingLogInMemoryRepo,
                trainingParameterInMemoryRepo, trainingTypeInMemoryRepo);

        CommandController commandController = new CommandController(userManager, trainingManager);
        CommandHandler commandHandler = new CommandHandler(commandController);
        CommandLineListener commandLineListener = new CommandLineListener(commandHandler);


        commandLineListener.run();


    }
}