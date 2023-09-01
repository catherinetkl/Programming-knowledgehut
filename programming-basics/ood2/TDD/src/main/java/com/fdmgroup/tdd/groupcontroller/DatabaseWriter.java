package com.fdmgroup.tdd.groupcontroller;

//DatabaseWriter writes trainees to the database
public class DatabaseWriter {
	GroupControllerDAO gControllerDAO;

	// Constructor to set up the DAO
	public DatabaseWriter(GroupControllerDAO gControllerDAO) {
		this.gControllerDAO = gControllerDAO;
	}

	// Method to add a trainee using the DAO
	public void addTrainee(Trainee any) {
		gControllerDAO.addTrainee(any);
	}

	// Method to remove a trainee by username using the DAO
	public void removeTraineeByUsername(String traineeUsername) {
		gControllerDAO.deleteTrainee(traineeUsername);
	}
}
