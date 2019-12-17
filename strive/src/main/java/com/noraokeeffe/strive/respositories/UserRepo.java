package com.noraokeeffe.strive.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.noraokeeffe.strive.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

}
