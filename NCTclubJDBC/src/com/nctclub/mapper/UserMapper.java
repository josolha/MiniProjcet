package com.nctclub.mapper;

import com.nctclub.model.UserDTO;

public interface UserMapper {
	
	// 회원 등록
	public int insert(UserDTO dto);
	
	// 회원 로그인
	UserDTO userLogin(UserDTO dto); 

}
