package com.cts.pm.parenttask;
//package com.cts.pm.parenttask;
//
//import com.cts.pm.ProjectManagerApplication;
//import com.cts.pm.parenttask.Stage;
//import com.cts.pm.parenttask.StageController;
//import com.cts.pm.parenttask.StageService;
////import com.cts.pm.role.Role;
//import com.google.gson.Gson;
//import com.jayway.jsonpath.DocumentContext;
//import com.jayway.jsonpath.JsonPath;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.notNullValue;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = ProjectManagerApplication.class)
//@WebMvcTest(value = StageController.class, secure = false)
//public class StageControllerTest {
//
//    public static final String CONTENT_TYPE = "Content-type";
//    public static final ResultMatcher OK = status().isOk();
//    public static final ResultMatcher RESPONSE_FORMAT = content().contentType(MediaType.APPLICATION_JSON_UTF8);
//
//    public static final String PATH = "/stages";
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    StageController controller;
//
//    @MockBean
//    StageService service;
//
//
//    private List<Stage> stageList = new ArrayList() {
//        {
//            add(new Stage());
//        }
//    };
//    private String SOME_NAME = "some_name";
//    private Stage stage = new Stage(1, SOME_NAME, null);
//
//
//    @Before
//    public void setUp() throws Exception {
//        stage.setId(1);
//        stage.setSubStages(null);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
//        MockitoAnnotations.initMocks(this);
//    }
//
//
//    @Test
//    public void thatGetListOfStagesWhenFetchAllStages() throws Exception {
//
//        given(service.getStageList()).willReturn(stageList);
//
//        ResultMatcher hasRecord = jsonPath("$").isArray();
//        MvcResult result = this.mockMvc.perform(get(PATH)
//                .accept(MediaType.APPLICATION_JSON).header(CONTENT_TYPE,
//                        MediaType.APPLICATION_JSON))
//                .andExpect(OK).andExpect(RESPONSE_FORMAT)
//                .andExpect(hasRecord).andReturn();
//
//        String jsonString = result.getResponse().getContentAsString();
//        DocumentContext context = JsonPath.parse(jsonString);
//        int length = context.read("$.length()");
//        assertThat(length, org.hamcrest.CoreMatchers.is(1));
//    }
//
//    @Test
//    public void thatGetListOfStagesWhenFetchAllStagesByNameAndRoleId() throws Exception {
//
//        given(service.getStageListByNameAndRole(SOME_NAME, 1)).willReturn(stageList);
//
//        ResultMatcher hasRecord = jsonPath("$").isArray();
//        MvcResult result = this.mockMvc.perform(get(PATH + "?name=" + SOME_NAME + "&id=1")
//                .accept(MediaType.APPLICATION_JSON).header(CONTENT_TYPE,
//                        MediaType.APPLICATION_JSON))
//                .andExpect(OK).andExpect(RESPONSE_FORMAT)
//                .andExpect(hasRecord).andReturn();
//
//        String jsonString = result.getResponse().getContentAsString();
//        DocumentContext context = JsonPath.parse(jsonString);
//        int length = context.read("$.length()");
//        assertThat(length, org.hamcrest.CoreMatchers.is(1));
//    }
//
//
//    @Test
//    public void thatGetStageModelWhenPassingStageId() throws Exception {
//
//        int SOME_STAGE_ID = 1;
//        given(service.getStage(SOME_STAGE_ID)).willReturn(stage);
//        MvcResult result = this.mockMvc.perform(get(PATH + "/" + SOME_STAGE_ID)
//                .accept(MediaType.APPLICATION_JSON)
//                .header(CONTENT_TYPE, MediaType.APPLICATION_JSON))
//                .andExpect(OK).andExpect(RESPONSE_FORMAT)
//                .andReturn();
//        String jsonString = result.getResponse().getContentAsString();
// //       Role role = new Gson().fromJson(jsonString, Role.class);
// //       assertThat(role, org.hamcrest.CoreMatchers.is(notNullValue()));
//    }
//
//    @Test
//    public void thatCreateNewStageWhenPassingNewStageInformation() throws Exception {
//        given(service.createStage(Mockito.any(Stage.class))).willReturn(stage);
//        String content = new Gson().toJson(stage);
//        this.mockMvc.perform(post(PATH)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content))
//                .andExpect(OK)
//                .andExpect(jsonPath("$.name").value(SOME_NAME))
//                .andReturn();
//    }
//
//    @Test
//    public void thatUpdateStageWhenPassingStageInfo() throws Exception {
//        int SOME_ID = 1;
//        given(service.updateStage(Mockito.any(Stage.class), Mockito.anyInt()))
//                .willReturn(stage);
//        String content = new Gson().toJson(stage);
//        this.mockMvc.perform(put(PATH + "/" + SOME_ID)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content))
//                .andExpect(OK)
//                .andExpect(jsonPath("$.name").value(SOME_NAME))
//                .andReturn();
//    }
//
//
//    @Test
//    public void thatDeleteStageWhenRequestDeleteStage() throws Exception {
//        int SOME_ID = 1;
//        this.mockMvc.perform(delete(PATH + "/" + SOME_ID)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(OK).andReturn();
//    }
//}