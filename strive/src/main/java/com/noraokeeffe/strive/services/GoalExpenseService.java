package com.noraokeeffe.strive.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.noraokeeffe.strive.models.GoalExpense;
import com.noraokeeffe.strive.models.UserExpense;
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
	
	public GoalExpense findGoalExpenseById(Long goalExpenseId) {
		Optional<GoalExpense> g_e = goalExpenseRepo.findById(goalExpenseId);
		if(g_e.isPresent()) {
			return g_e.get();
		}else {
			return null;
		}
	}
	public void deleteGoalExpense(GoalExpense goalExpense) {
		goalExpenseRepo.delete(goalExpense);
	}
}



