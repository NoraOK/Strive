package com.noraokeeffe.strive.services;

import org.springframework.stereotype.Service;

import com.noraokeeffe.strive.models.Goal;
import com.noraokeeffe.strive.respositories.GoalRepo;

@Service
public class GoalService {
	private final GoalRepo goalRepo;

	public GoalService(GoalRepo goalRepo) {
		this.goalRepo = goalRepo;
	}
	
	public Goal createGoal(Goal goal) {
		goal.setGoalResult("0");
		return goalRepo.save(goal);
	}
	public Goal findGoalById(Long goal_id) {
		return goalRepo.findGoalById(goal_id);
	}
}