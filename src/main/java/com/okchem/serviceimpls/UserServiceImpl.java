package com.okchem.serviceimpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.okchem.models.Users;
import com.okchem.repositoies.UserRopo;
import com.okchem.services.UserService;

@Component("UserServivce")
public class UserServiceImpl implements UserService {

	@Autowired 
	private UserRopo userRopo;
	
	@Override
	public Users getUser(long user_id) {
		
		return this.userRopo.findByUserName("admin");
	}

}
