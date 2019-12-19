package com.noraokeeffe.strive.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.noraokeeffe.strive.models.UserExpense;

@Repository
public interface UserExpenseRepo extends CrudRepository<UserExpense, Long> {

}
