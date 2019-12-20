package com.noraokeeffe.strive.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.noraokeeffe.strive.models.Goal;
import com.noraokeeffe.strive.models.GoalExpense;
import com.noraokeeffe.strive.models.User;
import com.noraokeeffe.strive.models.UserExpense;
import com.noraokeeffe.strive.services.GoalExpenseService;
import com.noraokeeffe.strive.services.GoalService;
import com.noraokeeffe.strive.services.UserService;

@Controller
public class GoalController {

	private final UserService userService;
	private final GoalService goalService;
	private final GoalExpenseService goalExpenseService;

	public GoalController(UserService userService, GoalService goalService, GoalExpenseService goalExpenseService) {
		this.userService = userService;
		this.goalService = goalService;
		this.goalExpenseService = goalExpenseService;
	}

	@RequestMapping("/newGoal")
	public String newGoal(@ModelAttribute("goal") Goal goal, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		User user = userService.findUserById(userId);
		model.addAttribute("user", user);
		return "strive/newGoal.jsp";
	}

	@PostMapping(value = "/strive/newGoal")
	public String postCreateGoal(@Valid @ModelAttribute("goal") Goal goal, Model model, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			Long userId = (Long) session.getAttribute("user_id");
			User user = userService.findUserById(userId);
			model.addAttribute("User", user);
			return newGoal(goal,model, session);
		} else {
			goalService.createGoal(goal);
			return "redirect:/oneGoal/" + goal.getId();
		}
	}

	@RequestMapping("/oneGoal/{goal_id}")
	public String readOneGoal(HttpSession session, Model model, @PathVariable("goal_id") Long goal_id,
		@ModelAttribute("goalExpense") GoalExpense goalExpense) {
		Goal goal = goalService.findGoalById(goal_id);
		model.addAttribute("goal", goal);
		Long userId = (Long) session.getAttribute("user_id");
		User user = userService.findUserById(userId);
		model.addAttribute("user", user);
		return "/strive/oneGoal.jsp";
	}

	@PostMapping("/addGoalExpense")
	public String addGoalExpense(@Valid @ModelAttribute("goalExpense") GoalExpense goalExpense, Model model,
			BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			Long userId = (Long) session.getAttribute("user_id");
			User user = userService.findUserById(userId);
			model.addAttribute("User", user);
			return readOneGoal(session, model, goalExpense.getGoal().getId(), goalExpense);
		} else {
			goalExpenseService.createGoalExpense(goalExpense);
			return "redirect:/oneGoal/" + goalExpense.getGoal().getId();
		}
	}
	
	@RequestMapping(value="/deleteGoalExpense/{id}", method=RequestMethod.DELETE)
	public String removeGoalExpense(@PathVariable("id") Long id) {
		GoalExpense g_e = goalExpenseService.findGoalExpenseById(id);
		goalExpenseService.deleteGoalExpense(g_e);
		return "redirect:/oneGoal/" + g_e.getGoal().getId();
	}
	
	@RequestMapping("/allGoals")
	public String allGoals(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		User user = userService.findUserById(userId);
		model.addAttribute("user", user);
		
		return "strive/allGoals.jsp";
	}
	
	@RequestMapping(value="/deleteGoal/{id}", method=RequestMethod.DELETE)
	public String removeGoal(@PathVariable("id") Long id) {
		Goal goal = goalService.findGoalById(id);
		goalService.deleteGoal(goal);
		return "redirect:/allGoals";
	}

}	

