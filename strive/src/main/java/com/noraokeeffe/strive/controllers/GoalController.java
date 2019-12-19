package com.noraokeeffe.strive.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noraokeeffe.strive.models.Goal;
import com.noraokeeffe.strive.services.GoalService;
import com.noraokeeffe.strive.services.UserService;

@Controller
public class GoalController {

	private final UserService userService;
	private final GoalService goalService;
	
	public GoalController(UserService userService, GoalService goalService) {
		this.userService = userService;
		this.goalService = goalService;
	}
	
	@RequestMapping("/newGoal")
	public String newGoal(@ModelAttribute("goal") Goal goal) {
		return "strive/newGoal.jsp";
	}
}
