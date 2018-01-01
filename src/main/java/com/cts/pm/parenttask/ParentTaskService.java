package com.cts.pm.parenttask;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParentTaskService {


    @Autowired
    private ParentTaskRepository ParentTaskRepository;

    public List<ParentTask> getParentTaskList() {

        List<ParentTask> ParentTasks = new ArrayList<>();
        ParentTaskRepository.findAll().forEach(ParentTasks::add);
        return ParentTasks;
    }

//    public List<ParentTask> getParentTaskListByNameAndRole(String name, Integer id) {
//        List<ParentTask> ParentTasks = new ArrayList<>();
//        ParentTaskRepository.findByParentTaskAndRole(name, id).forEach(ParentTasks::add);
//        return ParentTasks;
//    }

    public ParentTask getParentTask(Integer id) {
        return ParentTaskRepository.findOne(id);
    }

    public ParentTask createParentTask(ParentTask ParentTask) {
        return ParentTaskRepository.save(ParentTask);
    }

    public ParentTask updateParentTask(ParentTask ParentTask, Integer id) {
        return ParentTaskRepository.save(ParentTask);
    }


    public void deleteParentTask(Integer id) {
        ParentTaskRepository.delete(id);

    }
}
