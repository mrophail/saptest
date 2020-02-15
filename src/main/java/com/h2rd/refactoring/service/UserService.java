package com.h2rd.refactoring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2rd.refactoring.usermanagement.User;

@Service
public class UserService {

	private Map<String, User> users;

	@Autowired
	public UserService(Map<String, User> users) {
		this.users = users;
	}

	public List<User> getUsers() {
		if(users == null) {
			users = new HashMap<String, User>();
		}
		return new ArrayList<User>(users.values());
	}

	public Boolean deleteUser(String email) {
		User user = users.remove(email.toLowerCase());
		return user != null;
	}

	public User getUser(String email) {
		return users.get(email.toLowerCase());

	}

	public User saveUser(String name, String email, List<String> roles) {
		String userEmail = email.toLowerCase();
		User user = users.get(userEmail);
		if (user == null) {
			user = new User();
		}
		user.setName(name);
		user.setEmail(userEmail);
		user.setRoles(roles);
		users.put(userEmail, user);
		return user;

	}

}
