package com.noraokeeffe.strive.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noraokeeffe.strive.models.Goal;
import com.noraokeeffe.strive.models.User;
import com.noraokeeffe.strive.services.GoalService;
import com.noraokeeffe.strive.services.UserService;

@Controller
public class UserController {
	private final UserService userService;
	private final GoalService goalService;
	
	public UserController(UserService userService, GoalService goalService) {
		this.userService = userService;
		this.goalService = goalService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "strive/index.jsp";
	}
	
	@RequestMapping("/register")
	public String registrationPage() {
		return "strive/register.jsp";
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		return "strive/login.jsp";
	}
	
	@RequestMapping("/newGoal")
	public String newGoal(@ModelAttribute("goal") Goal goal) {
		return "strive/newGoal.jsp";
	}
	
	@RequestMapping("/ie")
	public String financesForm(@ModelAttribute("user") User user) {
		return "strive/ie.jsp";
	}
	
	
	
}
