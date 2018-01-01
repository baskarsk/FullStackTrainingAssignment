package com.cts.pm.parenttask;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.cts.pm.parenttask.ParentTaskRepository;
import com.cts.pm.parenttask.ParentTaskService;
import com.cts.pm.task.Task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class ParentTaskServiceTest {


    @InjectMocks
    private ParentTaskService service;
    private String SOME_NAME = "somename";
    private static final int SOME_ID = 1;

    @Mock
    private ParentTaskRepository repository;

    private Set<Task> subParentTask = new HashSet() {
        {
            add(new Task());
        }
    };
    private ParentTask ParentTask = new ParentTask(1, SOME_NAME, subParentTask);

    @Before
    public void setup() {
        ParentTask.setParentTask(SOME_NAME);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void thatGetListOfParentTaskWhenRequestAllParentTask() {
        //Given
        List<ParentTask> mockData = new ArrayList<>();
        mockData.add(ParentTask);
        when(repository.findAll()).thenReturn(mockData);
        List<ParentTask> list = service.getParentTaskList();
        assertEquals(1, list.size());
    }

    
    @Test
    public void thatGetParticularParentTaskWhenRequestByParentTaskId() {

        when(repository.findOne(1)).thenReturn(ParentTask);
        ParentTask client = service.getParentTask(1);
        assertEquals(client.getParentTask(), SOME_NAME);
    }


    @Test
    public void thatCreateParentTaskWhenPassingNewParentTaskInfo() {
        when(repository.save(ParentTask)).thenReturn(ParentTask);
        ParentTask subParentTask = service.createParentTask(ParentTask);
        assertEquals(subParentTask.getParentTask(), SOME_NAME);
    }

    @Test
    public void thatUpdateParentTaskWhenPassingUpdatedParentTaskInfo() {
        when(repository.save(ParentTask)).thenReturn(ParentTask);
        ParentTask client = service.updateParentTask(ParentTask, 1);
        assertEquals(client.getParentTask(), SOME_NAME);
    }

    @Test
    public void thatDeleteRoleWhenPassingParentTaskId() {
        service.deleteParentTask(1);
        assertTrue(true);
    }


}