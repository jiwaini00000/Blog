package com.okchem.repositoies;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okchem.models.Users;

public interface UserRopo extends JpaRepository<Users, Long> {
	Users findByUserName(String user_name);
}
