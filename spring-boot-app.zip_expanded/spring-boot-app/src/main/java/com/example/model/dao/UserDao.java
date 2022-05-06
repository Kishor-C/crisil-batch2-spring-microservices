package com.example.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.beans.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
/*
 * This interface is automatically implemented to perform 
 * operation on User entity mapped table
 */
