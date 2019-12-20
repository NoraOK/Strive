package com.noraokeeffe.strive.services;

import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;

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
		Goal goal = goalRepo.findGoalById(goal_id);
		Long daysBetween =  ChronoUnit.DAYS.between(goal.getCreatedAt().toInstant(), goal.getDeadline().toInstant());
		goal.setDuration(daysBetween.intValue()/7);
		double dollar_amt = (goal.getTotalGoalExpense() / goal.getDuration());
		goal.setGoalResult("Set aside " +dollar_amt+ " each week for " + goal.getDuration()+ " week(s)");
		
		return goal;
	}
}