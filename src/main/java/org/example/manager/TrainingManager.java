package org.example.manager;

import org.example.CacheData;
import org.example.Statistic;
import org.example.entity.TrainingEntity;
import org.example.entity.TrainingParameterEntity;
import org.example.entity.TrainingTypeEntity;
import org.example.entity.UserRole;
import org.example.inMemoryRepo.TrainingLogInMemoryRepo;
import org.example.inMemoryRepo.TrainingParameterInMemoryRepo;
import org.example.inMemoryRepo.TrainingTypeInMemoryRepo;

import java.util.*;

public class TrainingManager {

    private final TrainingLogInMemoryRepo trainingLogInMemoryRepo;
    private final TrainingParameterInMemoryRepo trainingParameterInMemoryRepo;
    private final TrainingTypeInMemoryRepo trainingTypeInMemoryRepo;

    public TrainingManager(TrainingLogInMemoryRepo trainingLogInMemoryRepo,
                           TrainingParameterInMemoryRepo trainingParameterInMemoryRepo,
                           TrainingTypeInMemoryRepo trainingTypeInMemoryRepo
    ) {
        this.trainingLogInMemoryRepo = trainingLogInMemoryRepo;
        this.trainingParameterInMemoryRepo = trainingParameterInMemoryRepo;
        this.trainingTypeInMemoryRepo = trainingTypeInMemoryRepo;
    }

    public List<TrainingEntity> getAllAvailable() {
        if (CacheData.getUserRole().equals(UserRole.ADMIN)) {
            return trainingLogInMemoryRepo.getAllTraining();
        } else
            return trainingLogInMemoryRepo.findByUserName(CacheData.getCurrentSessionUserName());
    }

    public void addParameter(String name, String units){
        trainingParameterInMemoryRepo.add(new TrainingParameterEntity(name, units));
    }

    public void addTrainingType(String name, String...parametersName){
        TrainingTypeEntity trainingType = new TrainingTypeEntity();
        trainingType.setName(name);
        trainingType.setTrainingParameterEntityList(
                trainingParameterInMemoryRepo.getByNames(parametersName)
        );
        trainingTypeInMemoryRepo.add(trainingType);

    }

    public void addTraining(Integer day,String trainingType, Integer... parametersValue){
        if ((CacheData.getUserRole()==UserRole.USER)&&(!CacheData.getCurrentSessionUserName().isEmpty())) {
            TrainingEntity trainingEntity = new TrainingEntity();
            trainingEntity.setTrainingDay(day);
            trainingEntity.setTrainingType(trainingTypeInMemoryRepo.getByName(trainingType));
            trainingEntity.setUserName(CacheData.getCurrentSessionUserName());
            trainingEntity.setArrayTrainingParameterValueList(parametersValue);
            trainingEntity.setPk(day +"'"+ CacheData.getCurrentSessionUserName() + "'" + trainingType);
            trainingLogInMemoryRepo.add(trainingEntity);
        }
    }



    public Set<TrainingEntity> getAllAndSortedByDay(){
        Set<TrainingEntity> trainingEntitySet = new TreeSet<>(Comparator.comparingInt(TrainingEntity::getTrainingDay));
        trainingEntitySet.addAll(getAllAvailable());
        return trainingEntitySet;
    }

    public void delete(String trainingType, Integer day){

        trainingLogInMemoryRepo.delete(generatedPk(day,trainingType));
    }

    public void edit(String trainingType,Integer day, Integer... parametrs){
        trainingLogInMemoryRepo.getByPk(generatedPk(day, trainingType))
                .setArrayTrainingParameterValueList(parametrs);
    }

    public void statistic(){
        Statistic.out(getAllAndSortedByDay());

    }
    private String generatedPk(Integer day, String trainingType){
        return day + "'"+ CacheData.getCurrentSessionUserName() +"'"+ trainingType;
    }

}
