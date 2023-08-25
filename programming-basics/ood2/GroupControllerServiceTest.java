package com.fdmgroup.tdd.groupcontroller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GroupControllerServiceTest {
    private GroupControllerService groupControllerService;
    private DatabaseReader databaseReaderMock;
    private DatabaseWriter databaseWriterMock;
    private Trainee traineeMock;
    @SuppressWarnings("unused")
	private Trainee nullTrainee; // Define nullTrainee as a field
	@SuppressWarnings("unused")
	private Trainee newTrainee;
	@SuppressWarnings("unused")
	private Trainee anotherTrainee;

    @BeforeEach
    public void setUp() {
        // Arrange: Set up mock objects
        this.databaseReaderMock = mock(DatabaseReader.class);
        this.databaseWriterMock = mock(DatabaseWriter.class);
        this.traineeMock = mock(Trainee.class);
        this.nullTrainee = null; // Initialise nullTrainee as null
        
        // Create mock instances of GroupControllerDAO, DatabaseReader, and DatabaseWriter
        GroupControllerDAO groupControllerDAOMock = mock(GroupControllerDAO.class);
        
        // Create an instance of GroupControllerService and associate the mock objects
        groupControllerService = new GroupController(groupControllerDAOMock, databaseReaderMock, databaseWriterMock);
    }
    
    @Test
    public void getAllTrainees_ReturnMap_CallsReadGroupFromDataBaseReader() {
        // Arrange: Define the expected result of the mocked method
        Map<String, Trainee> result = new HashMap<>();
        result.put("1234", traineeMock);
        
        // Stub the method using doReturn().when() API
        doReturn(result).when(databaseReaderMock).readGroup(anyMap());

        // Act: Call the method being tested
        Map<String, Trainee> returnedMap = groupControllerService.getAllTrainees();

        // Assert: Check if the expected result matches the actual result
        assertEquals(result, returnedMap);

        // Verify: Check if the method of the mock object was called as expected
        verify(databaseReaderMock, times(1)).readGroup(anyMap());
    }

    @Test
    public void removeTraineeByUsername_PassTraineeToDeleteTraineeByUsername() {
        // Act: Call the method being tested
        groupControllerService.removeTraineeByUsername("any string");

        // Verify: Check if the method of the mock object was called as expected
        verify(databaseWriterMock, times(1)).removeTraineeByUsername("any string");
    }

    @Test
    public void addTrainee_PassTraineeToDataBaseWriterAddTrainee() {
        // Act: Call the method being tested
        groupControllerService.addTrainee(traineeMock);

        // Verify: Check if the method of the mock object was called as expected
        verify(databaseWriterMock, times(1)).addTrainee(traineeMock);
    }
    
    @Test
    public void getAllTrainees_ReturnMap_CallsReadGroupFromDataBaseReader_EmptyMap() {
        // Arrange: Define the expected result of the mocked method as an empty map
        Map<String, Trainee> emptyResult = new HashMap<>();
        
        // Stub the method using doReturn().when() API
        doReturn(emptyResult).when(databaseReaderMock).readGroup(anyMap());

        // Act: Call the method being tested
        Map<String, Trainee> returnedMap = groupControllerService.getAllTrainees();

        // Assert: Check if the expected result matches the actual result
        assertEquals(emptyResult, returnedMap);

        // Verify: Check if the method of the mock object was called as expected
        verify(databaseReaderMock, times(1)).readGroup(anyMap());
    }
    
    @Test
    public void removeTraineeByUsername_RemoveTraineeFromMap() {
        // Arrange: Create a map with some mock trainees
        Map<String, Trainee> traineeMap = new HashMap<>();
        traineeMap.put("1234", traineeMock);
        traineeMap.put("5678", mock(Trainee.class));
        traineeMap.put("9012", mock(Trainee.class));

        // Act: Call the method being tested to remove a trainee
        groupControllerService.removeTraineeByUsername("5678");

        // Verify: Check if the method of the mock object was called as expected
        verify(databaseWriterMock, times(1)).removeTraineeByUsername("5678");
    }

    @Test
    public void removeTraineeByUsername_RemoveLastTraineeFromMap() {
        // Arrange: Create a map with only one mock trainee
        Map<String, Trainee> traineeMap = new HashMap<>();
        traineeMap.put("1234", traineeMock);

        // Act: Call the method being tested to remove the last trainee
        groupControllerService.removeTraineeByUsername("1234");

        // Verify: Check if the method of the mock object was called as expected
        verify(databaseWriterMock, times(1)).removeTraineeByUsername("1234");
    }
    
    @Test
    public void addTrainee_NullTrainee_ThrowsCustomIllegalArgumentException() {
        // Arrange: Set up the behaviour to throw CustomIllegalArgumentException
        doThrow(CustomIllegalArgumentException.class).when(databaseWriterMock).addTrainee(null);
        
        // Act and Assert: Verify that CustomIllegalArgumentException is thrown
        assertThrows(CustomIllegalArgumentException.class, () -> groupControllerService.addTrainee(null));
        
        // Verify: No interaction with the mock should occur
        verify(databaseWriterMock, never()).addTrainee(any(Trainee.class));
    }
    
    @Test
    public void addAndRemoveTrainees_SequentialOperations() {
        // Arrange: Create initial empty map
        Map<String, Trainee> initialMap = new HashMap<>();

        // Arrange: Configure the behavior of mock objects
        Trainee newTrainee = mock(Trainee.class);
        when(databaseReaderMock.readGroup(anyMap())).thenReturn(initialMap); // Return empty map initially

        // Act 1: Add a trainee to the group
        groupControllerService.addTrainee(newTrainee);


        // Assert 1: Verify that addTrainee method was called
        verify(databaseWriterMock, times(1)).addTrainee(newTrainee);


        // Act 2: Remove the added trainee from the group
        groupControllerService.removeTraineeByUsername("1234"); // Replace "1234" with actual username

        // Assert 2: Verify that removeTraineeByUsername method was called
        verify(databaseWriterMock, times(1)).removeTraineeByUsername("1234"); // Replace "1234" with actual username
   

        // Act 3: Add another trainee to the group
        Trainee anotherTrainee = mock(Trainee.class);
        groupControllerService.addTrainee(anotherTrainee);

        // Assert 3: Verify that addTrainee method was called again
        verify(databaseWriterMock, times(1)).addTrainee(anotherTrainee);

        // Arrange: Configure the behavior of mock objects for the next steps
        Map<String, Trainee> mapWithAnotherTrainee = new HashMap<>();
        mapWithAnotherTrainee.put("5678", anotherTrainee);
        when(databaseReaderMock.readGroup(anyMap())).thenReturn(mapWithAnotherTrainee); // Return map with anotherTrainee

        // Act 4: Get all trainees from the group
        Map<String, Trainee> returnedMap = groupControllerService.getAllTrainees();

        // Assert 4: Verify that readGroup method was called again
        verify(databaseReaderMock, times(1)).readGroup(anyMap());
        
        // Assert: Check if the returned map contains the last added trainee
        assertTrue(returnedMap.containsValue(anotherTrainee));
        assertFalse(returnedMap.containsValue(newTrainee));
    }

}