package org.example.inMemoryRepo;

import org.example.CacheData;
import org.example.entity.TrainingEntity;

import java.util.*;

public class TrainingLogInMemoryRepo {
    private final HashMap<String, TrainingEntity> trainingEntityHashMap = new HashMap<>();

    public void add(TrainingEntity trainingEntity){
        trainingEntityHashMap.put(
                trainingEntity.getPk(),
                trainingEntity
        );
    }
    public TrainingEntity getByPk(String pk){
        return Optional.ofNullable(trainingEntityHashMap.get(pk)).orElseThrow();
    }

    public List<TrainingEntity> findByUserName(String userName){
        List<TrainingEntity> result = new ArrayList<>();

        for (Map.Entry<String, TrainingEntity> entry : trainingEntityHashMap.entrySet()) {
            if (entry.getKey().split("'")[1].equals(userName)) {
                result.add(entry.getValue());
            }
        }
        return result;
    }
   public List<TrainingEntity> getAllTraining(){
        return (List<TrainingEntity>) trainingEntityHashMap.values();
   }

   public void delete(String trainingType,Integer day){
        trainingEntityHashMap.remove(day +"'"+ CacheData.getCurrentSessionUserName() +"'"+ trainingType); //todo костыль
   }



}
