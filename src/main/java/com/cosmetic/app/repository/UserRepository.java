package com.cosmetic.app.repository;

import java.util.List;
import com.cosmetic.app.model.User;


public interface UserRepository {
	public User saveUser(User user);
	public User findUserById(Integer id);
	public List<User> findAllUsers();
	public User deleteUser(Integer idUser);
	public User updateUser(User user);
	public boolean validUserAndPassword(String user, String password);
	public User findUserByName(String username);
}
