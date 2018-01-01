package com.cts.pm.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTaskList() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    public Task getTask(Integer id) {
        return taskRepository.findOne(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Transactional
    public void updateTask(Task task, Integer id) {
        System.out.println("@@@@Updating Task");
       //  taskRepository.updateTask(Task.getName(),Task.getId(),Task.getStage());
        taskRepository.save(task);
    }


    public void deleteTask(Integer id) {
        taskRepository.delete(id);
    }

}
