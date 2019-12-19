package com.noraokeeffe.strive.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1, message="Please enter a first name")
	private String firstName;
	 
	@Size(min=1, message="Please enter a last name")
	private String lastName;
	 
	@Size(min=1, message="Please enter an email")
	@Email(message="Email Not Valid")
	private String email;
	
	@Size(min = 4, message = "Password must be atleast 4 characters")
	private String password;
	 
	@Transient
	private String passwordConfirmation;
	
	private Double currentIncome;
	
	
	private Double currentBalance;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
   
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Goal> goals;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<UserExpense> user_expenses;

	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Double getCurrentIncome() {
		return currentIncome;
	}

	public void setCurrentIncome(Double currentIncome) {
		this.currentIncome = currentIncome;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public List<Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}
	
	 public List<UserExpense> getUser_expenses() {
		return user_expenses;
	}

	public void setUser_expenses(List<UserExpense> user_expenses) {
		this.user_expenses = user_expenses;
	}
	
	public double getTotalUserExpense() {
		double count = 0;
		for(int i=0; i<user_expenses.size(); i++) {
			count += user_expenses.get(i).getAmount();
		}
		return count;
	}
	
	public double getIncomeLessExpense() {
		double netIncome = currentIncome - getTotalUserExpense();
		return netIncome;
	}

	@PrePersist
	 protected void onCreate(){
	     this.createdAt = new Date();
	 }
	 
	 @PreUpdate
	 protected void onUpdate(){
	     this.updatedAt = new Date();
	 }
	
	
	
}
