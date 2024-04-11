package org.example.in;

import org.example.Audit;
import org.example.manager.TrainingManager;
import org.example.manager.UserManager;

public class CommandController {

    private final UserManager userManager;
    private final TrainingManager trainingManager;

    public CommandController(UserManager userManager, TrainingManager trainingManager) {
        this.userManager = userManager;
        this.trainingManager = trainingManager;
    }

    public void addNewUser(String name, String password, String role) {
        Audit.listen();
        userManager.addNewUser(name, password, role);

    }

    public void login(String name, String password) {
        Audit.listen();
      String userName =  userManager.identificationUser(name, password);
    }
    public void logout() {
        Audit.listen();
        userManager.logout();
    }

    public void showAllTraining(){
        Audit.listen();
        System.out.println(trainingManager.getAllAvailable());
    }

    public void addParameter(String name, String units){
        Audit.listen();
        trainingManager.addParameter(name, units);
    }
    public void addTrainingType(String name, String... parametersName){
        Audit.listen();
        trainingManager.addTrainingType(name, parametersName );
    }

    public void addTraining(Integer day, String trainingType, Integer... parametersValue){
        Audit.listen();
        trainingManager.addTraining(day, trainingType, parametersValue);
    }
    public void  getAllAndSortedByDay(){
        Audit.listen();
        System.out.println(trainingManager.getAllAndSortedByDay());
    }

    public void dellTraining(String trainingType, Integer day){
        Audit.listen();
        trainingManager.dellete(trainingType, day);
    }

    public void edit(String trainingType, Integer day, Integer... parameters){
        Audit.listen();
        trainingManager.edit(trainingType, day, parameters);
    }
    public void statistic(){
        Audit.listen();
        trainingManager.statistic();
    }

}
