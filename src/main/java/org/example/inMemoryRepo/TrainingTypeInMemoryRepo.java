package org.example.inMemoryRepo;

import org.example.entity.TrainingParameterEntity;
import org.example.entity.TrainingTypeEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class TrainingTypeInMemoryRepo {
    private final HashMap<String, TrainingTypeEntity> trainingTypeEntityHashMap = new HashMap<>();

    public void add (TrainingTypeEntity trainingType){
        trainingTypeEntityHashMap.put(trainingType.getName(), trainingType);
    }

    public TrainingTypeEntity getByName(String name){
        return Optional.ofNullable(trainingTypeEntityHashMap.get(name)).orElseThrow();
    }
}
