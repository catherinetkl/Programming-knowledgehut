package com.fdmgroup.tdd.groupcontroller;

import java.util.Map;

// GroupControllerService interface defines methods to manage trainees
public interface GroupControllerService {
	// Method to get all trainees
	public Map<String, Trainee> getAllTrainees();

	// Method to add a trainee
	public void addTrainee(Trainee trainee);

	// Method to remove a trainee by username
	public void removeTraineeByUsername(String traineeUsername);
}
