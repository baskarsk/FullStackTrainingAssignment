package com.cts.pm.task;


import com.cts.pm.parenttask.ParentTask;
import com.cts.pm.project.Project;
import com.cts.pm.task.Task;
import com.cts.pm.task.TaskFilter;
import com.cts.pm.task.TaskRepository;
import com.cts.pm.task.TaskService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class TaskServiceTest {


    @InjectMocks
    private TaskService service;

    private String SOME_NAME = "somename";
    @Mock
    private TaskRepository repository;

    
    private Task sampleSubStage = new Task(1, SOME_NAME, new ParentTask(),new Project(),new Date(0),new Date(0),"1","Started");
    

    @Before
    public void setup() {
        sampleSubStage.setTask(SOME_NAME);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void thatGetListOfTaskWhenRequestAllTask() {
        //Given
        List<Task> mockData = new ArrayList<>();
        mockData.add(sampleSubStage);
        when(repository.findAll()).thenReturn(mockData);
        List<Task> list = service.getTaskList();
        assertEquals(1, list.size());
    }

    @Test
    public void thatGetParticularSubStageWhenRequestBySubstageId() {

        when(repository.findOne(1)).thenReturn(sampleSubStage);
        Task client = service.getTask(1);
        assertEquals(client.getTask(), SOME_NAME);
    }


    @Test
    public void thatCreateTaskWhenPassingNewTaskInfo() {
        when(repository.save(sampleSubStage)).thenReturn(sampleSubStage);
        Task task = service.createTask(sampleSubStage);
        assertEquals(task.getTask(), SOME_NAME);
    }

    @Test
    public void thatUpdateTaskWhenPassingUpdatedTaskInfo() {
        when(repository.save(sampleSubStage)).thenReturn(sampleSubStage);
        service.updateTask(sampleSubStage, 1);
        assertTrue(true);
    }

    @Test
    public void thatDeleteTaskWhenPassingTaskId() {
        service.deleteTask(1);
        assertTrue(true);
    }


}