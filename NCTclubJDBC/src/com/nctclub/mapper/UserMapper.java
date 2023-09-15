package com.nctclub.mapper;

import java.util.List;

import com.nctclub.model.UserDTO;

public interface UserMapper {
	
	// 회원 등록
	public int insert(UserDTO dto);
	
	// 회원 로그인
	UserDTO userLogin(UserDTO dto); 
	
	// 전체 회원 선택
	public List<UserDTO> selectAllusers(); 

}
