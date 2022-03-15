package com.SpringSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSecurity.Model.Role;



public interface RoleRepository extends JpaRepository<Role, Integer> {

}