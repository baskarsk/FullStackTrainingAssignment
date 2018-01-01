package com.cts.pm.parenttask;

import com.cts.pm.task.Task;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ParentTask")
public class ParentTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PARENT_ID")
    private int id;

    @Column(name = "PARENT_TASK")
    private String parentTask;

  
    @OneToMany(
            mappedBy ="mParentTask",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    @JsonManagedReference
    @JsonIgnore
 //   @JsonProperty(value="User")
    private Set<Task> task;

    
    public ParentTask(){
    	
    }

	public ParentTask(int id, String parentTask, Set<Task> task) {
		super();
		this.id = id;
		this.parentTask = parentTask;
		this.task = task;
	}


	public ParentTask(int id, String parentTask) {
		super();
		this.id = id;
		this.parentTask = parentTask;
	}


	public int getId() {
        return id;
    }


	public void setId(int id) {
        this.id = id;
    }


	public String getParentTask() {
		return parentTask;
	}




	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

 
	public Set<Task> getTask() {
		return task;
	}


   

	public void setTask(Set<Task> task) {
		this.task = task;
	}
	
    
}
