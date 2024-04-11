package org.example;

import org.example.entity.TrainingEntity;
import org.example.entity.TrainingTypeEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Statistic {
    public static void out(Set<TrainingEntity> trainings) {
        Map<Integer, Map<String, Integer>> dayStatistics = new HashMap<>();

        for (TrainingEntity training : trainings) {
            int day = training.getTrainingDay();
            TrainingTypeEntity trainingType = training.getTrainingType();
            Integer[] parameterValues = training.getArrayTrainingParameterValueList();

            Map<String, Integer> parameterMap = dayStatistics.computeIfAbsent(day, k -> new HashMap<>());

            for (int i = 0; i < trainingType.getCountTrainingParameters(); i++) {
                String parameterName = trainingType.getTrainingParameterEntityList().get(i).getName();
                int value = parameterValues[i];

                parameterMap.put(parameterName, parameterMap.getOrDefault(parameterName, 0) + value);
            }
        }

        // Вывод статистики
        for (Integer day : dayStatistics.keySet()) {
            System.out.println("День " + day + ":");

            Map<String, Integer> parameterMap = dayStatistics.get(day);
            for (String parameter : parameterMap.keySet()) {
                System.out.println(parameter + ": " + parameterMap.get(parameter));
            }
        }
    }
}


