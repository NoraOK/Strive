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
		return goalRepo.save(goal);
	}
}
