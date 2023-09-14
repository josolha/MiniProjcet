package com.nctclub.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nctclub.mapper.UserMapper;
import com.nctclub.model.UserDTO;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	@Override
	public int userRegister(UserDTO dto) {
		
		String inputPw = dto.getPassword();
		System.out.println("암호화전 : " + inputPw);
		
		String cipherPw = pwEncoder.encode(inputPw);
		System.out.println("암호화후 : " + cipherPw);
		
		dto.setPassword(cipherPw);
		return mapper.insert(dto);
	}

	@Override
	public boolean userLogin(UserDTO dto, HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		// 아이디와 일치하는 회원정보를 DTO에 담아서 가져옴 
		UserDTO loginDto = mapper.userLogin(dto);
		
		if(loginDto !=null) {  // 일치하는 아이디가 있는 경우 
			String inputPw = dto.getPassword(); // 사용자가 입력한 비번
			String dbPw = loginDto.getPassword(); // DB에 있는 암호화된 비번			
			
			// 암호화 전 조건
			//if(inputPw.equals(dbPw)) { // 비밀번호와 일치
			
			// 암호화 후 조건문
			if(pwEncoder.matches(inputPw, dbPw)) { // 입력비밀번호와 암호비밀번호와 일치되면
				
				session.setAttribute("loginDto", loginDto);
				return true;
			}else { // 비밀번호와 일치하지 않는 경우
				return false;
			}
			
		}else { // 일치하는 아이디가 없는 경우
			return false;
		}
	}

}
