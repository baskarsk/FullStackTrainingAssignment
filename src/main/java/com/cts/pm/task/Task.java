package com.cts.pm.task;


import com.cts.pm.parenttask.ParentTask;
import com.cts.pm.project.Project;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Task")
public class Task {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASK_ID")
    private int id;

    @Column(name = "TASK")
    private String task;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PARENT_ID", nullable = true)
    @JsonBackReference
 //   private Set<ParentTask> parentTask;
    private ParentTask mParentTask;

    /*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_ID", nullable = false)
    @JsonBackReference
    private Project project;
*/
      
    @Column(name = "START_DATE")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date startDate;
    
    @Column(name = "END_DATE")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date endDate;
    
    @Column(name = "PRIORITY")
    private String priority;
    
    @Column(name = "STATUS")
    private String status;

    public Task(){
    	
    }
    
	public Task(int id, String task, ParentTask parentTask, Project project, Date startDate, Date endDate,
			String priority, String status) {
		super();
		this.id = id;
		this.task = task;
		this.mParentTask = parentTask;
//		this.project = project;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
	}


	
	

	public Task(int id, String task, Date startDate, Date endDate, String priority, String status) {
		super();
		this.id = id;
		this.task = task;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
	}





	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTask() {
		return task;
	}



	public void setTask(String task) {
		this.task = task;
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

	public ParentTask getmParentTask() {
		return mParentTask;
	}

	public void setmParentTask(ParentTask mParentTask) {
		this.mParentTask = mParentTask;
	}
	
	
    
    



}
