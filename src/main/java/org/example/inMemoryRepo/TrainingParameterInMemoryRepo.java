package org.example.inMemoryRepo;

import org.example.entity.TrainingParameterEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class TrainingParameterInMemoryRepo {
    private final HashMap<String, TrainingParameterEntity> trainingParameterEntityHashMap = new HashMap<>();

    public void add(TrainingParameterEntity trainingParameterEntity) {
        trainingParameterEntityHashMap.put(trainingParameterEntity.getName(), trainingParameterEntity);
    }

    public TrainingParameterEntity getByName(String name) {
        return Optional.ofNullable(trainingParameterEntityHashMap.get(name)).orElseThrow();
    }

    public List<TrainingParameterEntity> getByNames(String... names) {
        List<TrainingParameterEntity> result = new ArrayList<>();

        for (String name : names) {
            TrainingParameterEntity entity = trainingParameterEntityHashMap.get(name);
            if (entity != null) {
                result.add(entity);
            }
        }

        return result;

    }
    public Integer size(){
        return trainingParameterEntityHashMap.size();
    }
}
