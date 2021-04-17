package com.juaracoding.ujian5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juaracoding.ujian5.entity.User;
import com.juaracoding.ujian5.respository.UserRespository;

@Service
public class ModelUser implements ModelUserInterface {

	@Autowired
	UserRespository userRespo;
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return (List<User>) this.userRespo.findAll();
	}

	@Override
	public User getUserByUsername(String name) {
		// TODO Auto-generated method stub
		return ((User) this.userRespo.findByUsername(name));
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return this.userRespo.save(user);
	}

	@Override
	public User getUserByIdUser(String id) {
		// TODO Auto-generated method stub
		return ((User) this.userRespo.findByIdUser(Long.parseLong(id)));
	}

	@Override
	public void deleteUserById(String id) {
		// TODO Auto-generated method stub
		this.userRespo.deleteById(Long.parseLong(id));
	}
		
	
}
