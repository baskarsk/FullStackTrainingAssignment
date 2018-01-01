package com.cts.pm.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Task")
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskService taskService;

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<List<TaskFilter>> getAllTask() {
//        List<TaskFilter> tasks = taskService.gettaskList();
//        return new ResponseEntity<List<TaskFilter>>(tasks, HttpStatus.OK);
//    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getAllTask() {
        List<Task> tasks = taskService.getTaskList();
        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Integer id) {
        Task task = taskService.getTask(id);
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task taskData = taskService.createTask(task);
        return new ResponseEntity<Task>(taskData, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable Integer id) {
        System.out.println("Inside update");
        taskService.updateTask(task, id);
        return new ResponseEntity<Task>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
