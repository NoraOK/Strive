package com.noraokeeffe.strive.services;

import org.springframework.stereotype.Service;

import com.noraokeeffe.strive.models.GoalExpense;
import com.noraokeeffe.strive.respositories.GoalExpenseRepo;

@Service
public class GoalExpenseService {
	private final GoalExpenseRepo goalExpenseRepo;

	public GoalExpenseService(GoalExpenseRepo goalExpenseRepo) {
		this.goalExpenseRepo = goalExpenseRepo;
	}

	public GoalExpense createGoalExpense(GoalExpense goalExpense) {

		return goalExpenseRepo.save(goalExpense);
	}
//	public Goal findGoalById(Long goal_id) {
//		return goalRepo.findGoalById(goal_id);
//	}

}
