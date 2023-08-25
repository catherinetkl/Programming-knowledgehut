package com.fdmgroup.tdd.groupcontroller;

import java.util.Map;

public interface GroupControllerDAO {
    Map<String, Trainee> readTrainee();
    
    void deleteTrainee(String anyString);
    
    void addTrainee(Trainee trainee);
}
