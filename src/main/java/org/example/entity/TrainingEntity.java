package org.example.entity;

import lombok.Data;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Data
public class TrainingEntity {

    private Integer trainingDay;
    private String userName;
    private TrainingTypeEntity trainingType;

    private Integer[] arrayTrainingParameterValueList;

    private String pk;


    public void setPk(){
        this.pk = trainingDay +"'"+ userName + "'" + trainingType;
    } // todo костыль


}
