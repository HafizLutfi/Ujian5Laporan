package com.juaracoding.ujian5.service;

import java.util.List;

import com.juaracoding.ujian5.entity.User;

public interface ModelUserInterface {

	public List<User> getAllUser();
	public User getUserByUsername(String name);
	public User addUser(User user);
	public User getUserByIdUser(String id);
	public void deleteUserById(String id);
}
