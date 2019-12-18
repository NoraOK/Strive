package com.noraokeeffe.strive.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/newGoal")
	public String newGoal() {
		return "strive/newGoal.jsp";
	}
	
	
	
}
