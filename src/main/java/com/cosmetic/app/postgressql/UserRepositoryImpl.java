package com.cosmetic.app.postgressql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetic.app.model.User;
import com.cosmetic.app.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	@Autowired
	private PostgreSQLConnection dataSource;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(Integer idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validUserAndPassword(String user, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
