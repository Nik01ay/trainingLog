package org.example.assistant;

public class ConsoleAssistant {
    public void addNewUser() {
        System.out.println("add a new account write the command (ADMIN or USER):\n" +
                "addNewUser Name Password ADMIN");

    }

    public void login() {
        System.out.println("\n" +
                "To log in, enter the command \"login\" username and password:\n" +
                " login Name Password");
    }

    public void logout() {
        System.out.println("To log out, enter:\n" +
                " logout");
    }

    public void showAllTraining() {
        System.out.println("to show all workouts enter:\n" +
                " showAllTraining");
    }

    public void addParameter() {
        System.out.println(
                "To create a training parameter, enter the command \"addParametr\" " +
                        "parameter name and units of measurement: \n" +
                        "addParameter name units");
    }

    public void addTrainingType() {
        System.out.println("to create a training type, enter the command \"addTrainingType\"\n" +
                "name of the training type and list of parameters:\n" +
                " addTrainingType name parametersName1 parametersName2...");
        System.out.println("recorded parameters: ");
    }

    public void addTraining() {
        System.out.println(
                "to add a workout, enter the command \"addTraining\" day, type of workout, list the parameter values: " +
                "addTraining 1 typeName 2 4");
        System.out.println("recorded training type: ");
    }

    public void getAllAndSortedByDay() {
        System.out.println("\n" +
                "to view all workouts sorted by day, enter: \"getAllAndSortedByDay\"");
    }

    public void dellTraining() {
        System.out.println("To delete a training, enter the command \"dellTraining\" and the training type and day. \n" +
                "For example: \n" +
                "dellTraining trainingType1 2");
        System.out.println("recorded workouts in log: ");
    }

    public void edit() {
        System.out.println("To edit  training, enter the command \"edit\" and the training type and day and parameters. \n" +
                "For example: \n" +
                "edit trainingType1 2 3 5");
        System.out.println("recorded workouts in log: ");
    }

    public void statistic() {
        System.out.println("to display statistics, enter: \n" +
                "statistic");
    }
}
