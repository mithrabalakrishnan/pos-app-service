package com.pos.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pos.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);

	public User findByEmail(String email);

//	public String findByPhone(String phone);

	public User findByUserid(Integer userId);
	
	public List<User> findByRole(String role);

}