package com.SpringSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSecurity.Model.User;



public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

	User findById(int id);

}