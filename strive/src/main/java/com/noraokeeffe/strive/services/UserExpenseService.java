package com.noraokeeffe.strive.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.noraokeeffe.strive.models.UserExpense;
import com.noraokeeffe.strive.respositories.UserExpenseRepo;
import com.noraokeeffe.strive.respositories.UserRepo;

@Service
public class UserExpenseService {
	private final UserRepo userRepo;
	private final UserExpenseRepo userExpenseRepo;
	
	public UserExpenseService(UserRepo userRepo, UserExpenseRepo userExpenseRepo) {
		this.userRepo = userRepo;
		this.userExpenseRepo = userExpenseRepo;
	}
	
	public UserExpense createUserExpense(UserExpense userExpense) {
		return userExpenseRepo.save(userExpense);
	}
	
	public UserExpense findUserExpenseById(Long userExpenseId) {
		Optional<UserExpense> u_e = userExpenseRepo.findById(userExpenseId);
			if(u_e.isPresent()) {
				return u_e.get();
			}else {
				return null;
			}
	}
	
	public void deleteUserExpense(UserExpense userExpense) {
		userExpenseRepo.delete(userExpense);
	}
	
}
