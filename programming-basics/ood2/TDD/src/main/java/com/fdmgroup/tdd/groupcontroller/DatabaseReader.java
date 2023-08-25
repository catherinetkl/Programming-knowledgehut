package com.fdmgroup.tdd.groupcontroller;

import java.util.Map;

//DatabaseReader reads trainees from the database
public class DatabaseReader {
	GroupControllerDAO gControllerDAO;

	// Constructor to set up the DAO
	public DatabaseReader(GroupControllerDAO gControllerDAO) {
		this.gControllerDAO = gControllerDAO;
	}

	// Method to read trainees and populate a map
	public Map<String, Trainee> readGroup(Map<String, Trainee> map) {
		// Use the DAO to read trainees and populate the map
		return gControllerDAO.readTrainee();
	}
}
