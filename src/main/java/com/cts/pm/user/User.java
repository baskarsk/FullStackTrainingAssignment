package com.cts.pm.user;

import com.cts.pm.project.Project;
import com.cts.pm.task.Task;
//import com.cts.cde.io.onboarding.contentstatus.ContentStatus;
//import com.cts.cde.io.onboarding.role.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import org.hibernate.mapping.List;

import java.util.Set;

@Entity
@Table(name = "User")
public class User {



    private interface Table {
        String USERID = "USER_ID";
        String EMPLOYEE_ID = "EMPLOYEE_ID";
        String FIRST_NAME = "FIRST_NAME";
        String LAST_NAME = "LAST_NAME";
        String PROJECT_ID = "PROJECT_ID";
        String TASK_ID = "TASK_ID";
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Table.USERID)
    private Integer id;


    @Column(name = Table.EMPLOYEE_ID, unique = true)
    private String employeeId;

    @Column(name = Table.FIRST_NAME)
    private String firstName;

    @Column(name = Table.LAST_NAME)
    private String lastName;

    /*
    //Many projects for one user.
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = Table.PROJECT_ID, nullable = true)
	private Project project;

	//Many task one User.
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = Table.TASK_ID, nullable = true)
	private Set<Task> task;
	*/

    public User() {
    	
    }

    public User(Integer id, String employeeId, String firstName, String lastName, Project project, Set<Task> task) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
//		this.project = project;
//		this.task = task;
	}
      
    
	public User(Integer id, String employeeId, String firstName, String lastName) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

//	public Project getProject() {
//		return project;
//	}
//
//	public void setProject(Project project) {
//		this.project = project;
//	}
//
//	public Set<Task> getTask() {
//		return task;
//	}
//
//	public void setTask(Set<Task> task) {
//		this.task = task;
//	}
    



}
