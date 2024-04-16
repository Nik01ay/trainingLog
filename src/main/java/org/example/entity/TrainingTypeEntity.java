package org.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class TrainingTypeEntity {

    private String name;
    private List<TrainingParameterEntity> trainingParameterEntityList = new ArrayList<>();

    public Integer getCountTrainingParameters(){
        return  trainingParameterEntityList.size();
    }


}
