package com.nctclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nctclub.mapper.UserMapper;
import com.nctclub.model.UserDTO;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<UserDTO> selectAllUsers() {
		return mapper.selectAllusers();
	}

}
