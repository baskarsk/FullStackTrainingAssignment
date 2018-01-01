package com.cts.pm.project;



import com.cts.pm.task.Task;
import com.cts.pm.user.User;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

import org.springframework.web.bind.annotation.Mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Project")
public class Project{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID")
    private int id;

    @Column(name = "PROJECT")
    private String project;

    @Column(name = "START_DATE")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date startDate;
    
    @Column(name = "END_DATE")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date endDate;
    
    @Column(name = "PRIORITY")
    private String priority;
  
   
    /*
    //One Project for many user.
   	@OneToMany(mappedBy="project" ,fetch = FetchType.EAGER)
   	//@JoinColumn(name = "USER_ID", nullable = false)
   	private Set<User> user;
   	
    
   	//Many task one project.
   	@OneToMany(fetch = FetchType.EAGER)
   	@JoinColumn(name = "TASK_ID", nullable = false)
   	private Set<Task> task;
    
   	*/
 
    public Project() {

    }
    	
   public Project(int id, String project, Date startDate, 
                Date endDate, String priority) {	
        this.id = id;
        this.project = project;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
   
    }

		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getProject() {
			return project;
		}
		
		public void setProject(String project) {
			this.project = project;
		}
		
		public Date getStartDate() {
			return startDate;
		}
		
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		
		public Date getEndDate() {
			return endDate;
		}
		
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		
		public String getPriority() {
			return priority;
		}
		
		public void setPriority(String priority) {
			this.priority = priority;
		}

//		public Set<User> getUser() {
//			return user;
//		}
//
//		public void setUser(Set<User> user) {
//			this.user = user;
//		}
//
//		public Set<Task> getTask() {
//			return task;
//		}
//
//		public void setTask(Set<Task> task) {
//			this.task = task;
//		}
		
		

}
