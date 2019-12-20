package com.noraokeeffe.strive.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="goals")
public class Goal {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;

	 @Size(min=1, message="Please enter a first name")
	 private String goalName;
	 
	 @NotNull(message="Please enter a date for an event")
	 @FutureOrPresent
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date deadline;
	 	 
	 private String goalResult;
	 
	 @Transient
	 private int duration;
	 
	 @Column(updatable=false)
     @DateTimeFormat(pattern="yyyy-MM-dd")
     private Date createdAt;
    
	 @DateTimeFormat(pattern="yyyy-MM-dd")
     private Date updatedAt;
	 
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="user_id")
	 private User user;
	 
	 @OneToMany(mappedBy="goal", fetch=FetchType.EAGER)
	 private List<GoalExpense> goal_expenses;
	 
	  
	 public Goal() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGoalName() {
		return goalName;
	}

	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	} 

	public List<GoalExpense> getGoal_expenses() {
		return goal_expenses;
	}

	public void setGoal_expenses(List<GoalExpense> goal_expenses) {
		this.goal_expenses = goal_expenses;
	}

	public String getGoalResult() {
		return goalResult;
	}

	public void setGoalResult(String goalResult) {
		this.goalResult = goalResult;
	}

	public double getTotalGoalExpense() {
		double count = 0;
		for(int i=0; i<goal_expenses.size(); i++) {
			count += goal_expenses.get(i).getAmount();
		}
		return count;
	}
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	 
	 
	 
	 
}
