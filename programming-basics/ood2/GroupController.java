package com.fdmgroup.tdd.groupcontroller;

import java.util.HashMap;
import java.util.Map;

public class GroupController implements GroupControllerService {
    GroupControllerDAO gControllerDAO;
    DatabaseReader dBReader;
    DatabaseWriter dBWriter;
    
    public GroupController(GroupControllerDAO gControllerDAO, DatabaseReader dBReader, DatabaseWriter dBWriter) {
        this.gControllerDAO = gControllerDAO;
        this.dBReader = dBReader;
        this.dBWriter = dBWriter;
    }

    @Override
    public Map<String, Trainee> getAllTrainees() {
        Map<String, Trainee> test = new HashMap<String, Trainee>();
        return dBReader.readGroup(test);
    }

    @Override
    public void addTrainee(Trainee trainee) {
        dBWriter.addTrainee(trainee);
    }

    @Override
    public void removeTraineeByUsername(String traineeUsername) {
        dBWriter.removeTraineeByUsername(traineeUsername);
    }
}
