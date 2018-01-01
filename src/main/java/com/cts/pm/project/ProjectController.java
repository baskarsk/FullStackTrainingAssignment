package com.cts.pm.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {
    @Autowired
    private ProjectService pjtService;

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<List<ProjectFilter>> getAllProjects(@RequestParam("project") String project) {
//        List<ProjectFilter> projects = pjtService.getProjectByRoleId(project);
//        return new ResponseEntity<List<ProjectFilter>>(projects, HttpStatus.OK);
//    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Project>> getAllProjects(){
    	
    	List<Project> projects = pjtService.getProjectList();
    	return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Project>  getProject(@PathVariable Integer id) {
        Project content = pjtService.getProject(id);
        return new ResponseEntity<Project>(content, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Project> createContent(@RequestBody Project project) {
        Project contentData = pjtService.createProject(project);
        return new ResponseEntity<Project>(contentData, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Project> updateProject(@RequestBody Project project, @PathVariable Integer id) {
        Project contentData = pjtService.updateProject(project, id);
        return new ResponseEntity<Project>(contentData, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<String> deleteContent(@PathVariable Integer id) {
        pjtService.deleteProject(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
