package vn.iostart.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iostart.Repository.UserRepository;
import vn.iostart.Service.UserService;
import vn.iostart.models.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(username);
	}

}
