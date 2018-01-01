package com.cts.pm.task;


import com.cts.pm.ProjectManagerApplication;
import com.cts.pm.parenttask.ParentTask;
import com.cts.pm.project.Project;
import com.google.gson.Gson;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProjectManagerApplication.class)
@WebMvcTest(value = TaskController.class, secure = false)
public class TaskControllerTest {


    public static final String CONTENT_TYPE = "Content-type";
    public static final ResultMatcher OK = status().isOk();
    public static final ResultMatcher RESPONSE_FORMAT = content().contentType(MediaType.APPLICATION_JSON_UTF8);

    public static final String PATH = "/Task";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    TaskController controller;

    @MockBean
    TaskService service;


    private Set<ParentTask> contentList = new HashSet() {
        {
            add(new ParentTask());
        }
    };
    private String SOME_NAME = "some_name";
    
    private Project project = new Project(1,"Project1",new Date(0),new Date(0),"1");
    private Task task = new Task(1, SOME_NAME, new ParentTask(1,"Development"),project,new Date(0),new Date(0),"1","Started");
//    private SubStageFilter sampleSubStageFilter = new SubStageFilter(1, SOME_NAME, new Stage());

    @Before
    public void setUp() throws Exception {
  //      sampleSubStage.setId(1);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void thatGetListOfTask() throws Exception {

        List<Task> taskList = new ArrayList();
 //       userList.add(sampleSubStageFilter);
        given(service.getTaskList()).willReturn(taskList);

        ResultMatcher hasRecord = jsonPath("$").isArray();
        MvcResult result = this.mockMvc.perform(get(PATH)
                .accept(MediaType.APPLICATION_JSON).header(CONTENT_TYPE,
                        MediaType.APPLICATION_JSON))
                .andExpect(OK).andExpect(RESPONSE_FORMAT)
                .andExpect(hasRecord).andReturn();

        String jsonString = result.getResponse().getContentAsString();
        DocumentContext context = JsonPath.parse(jsonString);
        int length = context.read("$.length()");
        assertThat(length, is(1));
        	//assertThat(sampleSubStage.getStage(), is(notNullValue()));
    }


    @Test
    public void thatGetTaskWhenPassinTaskId() throws Exception {

        int SOME_TASK_ID = 1;
//        given(service.getSubStage(SOME_ROLE_ID)).willReturn(sampleSubStage);
        MvcResult result = this.mockMvc.perform(get(PATH + "/" + SOME_TASK_ID)
                .accept(MediaType.APPLICATION_JSON)
                .header(CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(OK).andExpect(RESPONSE_FORMAT)
                .andReturn();
        String jsonString = result.getResponse().getContentAsString();
        Task task = new Gson().fromJson(jsonString, Task.class);
        assertThat(task, is(notNullValue()));
    }

    @Test
    public void thatCreateNewTaskWhenPassingNewTaskInformation() throws Exception {
        given(service.createTask(Mockito.any(Task.class))).willReturn(task);
        String content = new Gson().toJson(task);
        this.mockMvc.perform(post(PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(OK)
                .andExpect(jsonPath("$.name").value(SOME_NAME))
                .andReturn();
  
    	}

    @Test
    public void thatUpdateTaskWhenPassingTaskInfo() throws Exception {
        int SOME_ROLE_ID = 1;

        String content = new Gson().toJson(task);
        this.mockMvc.perform(put(PATH + "/" + SOME_ROLE_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(OK)
                .andReturn();
    }


    @Test
    public void thatDeleteTaskWhenRequestDeleteTask() throws Exception {
        int SOME_ROLE_ID = 1;
        this.mockMvc.perform(delete(PATH + "/" + SOME_ROLE_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(OK).andReturn();
    }

}