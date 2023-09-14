package com.nctclub.service;

import javax.servlet.http.HttpServletRequest;

import com.nctclub.model.UserDTO;

public interface UserService {
	
	int userRegister(UserDTO dto);
	
	boolean userLogin(UserDTO dto, HttpServletRequest req);

}
