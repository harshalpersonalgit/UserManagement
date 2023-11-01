package com.myco.user.service;

import java.util.List;

import com.myco.user.model.User;

public interface UserESService {

	List<User> getAllDocuments();

	String saveUser(User user);

	String deleteUser(String id);

	User updateUser(String id);

}
