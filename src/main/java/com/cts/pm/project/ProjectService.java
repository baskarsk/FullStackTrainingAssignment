package com.cts.pm.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pm.user.User;
import com.cts.pm.user.UserRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProjectService {

    @Autowired
    private ProjectRepository pjtRepository;

//    @Autowired
//    private UserRepository userRepository;

    public List<Project> getProjectList() {
        List<Project> pjts = new ArrayList<>();
        pjtRepository.findAll().forEach(pjts::add);
        return pjts;
    }

    public Project getProject(Integer id) {
        return pjtRepository.findOne(id);
    }

//    public List<ProjectFilter> getProjectByRoleId(String name) {
//
//        User user=userRepository.findByUserName(name);
//        if (user.getAdmin()) {
//            return pjtRepository.findAllForAdmin();
//        }
//        return pjtRepository.findByRoleId(name);
//    }

    public Project createProject(Project project) {
        
        
        return pjtRepository.save(project);
    }

    public Project updateProject(Project pjt, Integer id) {
        
        return pjtRepository.save(pjt);
    }

    public void deleteProject(Integer id) {

   
        pjtRepository.delete(id);

    }

}
