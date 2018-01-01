package com.cts.pm.parenttask;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/ParentTasks")
@CrossOrigin
public class ParentTaskController {

    @Autowired
    private ParentTaskService ParentTaskService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ParentTask>> getAllParentTasks(@RequestParam(value = "name") Optional<String> name,
                                                    @RequestParam(value = "id") Optional<String> id) {
        List<ParentTask> ParentTaskData;
            ParentTaskData = ParentTaskService.getParentTaskList();
 
        return new ResponseEntity<List<ParentTask>>(ParentTaskData, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<ParentTask> getParentTask(@PathVariable Integer id) {

        ParentTask ParentTaskData = ParentTaskService.getParentTask(id);
        return new ResponseEntity<ParentTask>(ParentTaskData, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ParentTask> createParentTask(@RequestBody ParentTask ParentTask) {

        ParentTask ParentTaskData = ParentTaskService.createParentTask(ParentTask);
        return new ResponseEntity<ParentTask>(ParentTaskData, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<ParentTask> updateParentTask(@RequestBody ParentTask ParentTask,
                                             @PathVariable Integer id) {

        ParentTask ParentTaskData = ParentTaskService.updateParentTask(ParentTask, id);
        return new ResponseEntity<ParentTask>(ParentTaskData, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<String> deleteParentTask(@PathVariable Integer id) {

        ParentTaskService.deleteParentTask(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }


}
