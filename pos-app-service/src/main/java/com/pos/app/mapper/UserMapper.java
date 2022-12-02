package com.pos.app.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.pos.app.model.User;

@Mapper
public interface UserMapper {

	@Insert({"INSERT INTO user (username,first_name,last_name,phone_no,email,place,password,role"
			+ "values(#username,#firstName,#lastName,#phone,#email,#place,#place,#role))"})
	public int createUser(User user);
	
}
