package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Dyuser;
import com.example.demo.repository.DyuserRepository;

@Service
public class UserService {

	@Autowired
	private DyuserRepository repository;

	//新規登録
	public boolean create(String name, String email, String password) {

		Dyuser existingUser = repository.findByEmail(email);

		if (existingUser != null) {
			return false;
		}

		Dyuser user = new Dyuser();

		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		user.setRoleName("USER");

		repository.save(user);

		return true;

	}

	//ログイン判定
	public boolean login(String email, String password) {

		Dyuser user = repository.findByEmail(email);

		if (user != null && user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}

	}

}