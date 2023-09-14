package com.nctclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nctclub.model.UserDAO;
import com.nctclub.model.UserDTO;
import com.nctclub.model.UserRole;

@Controller
@RequestMapping("/user")
public class UserController {
	
	 @RequestMapping(value = "/registerform", method = RequestMethod.GET)
	 public String registerForm(){
		return "registerform";
	 }
	
	 // 회원등록
	 @RequestMapping(value = "/register", method = RequestMethod.GET)
	 public String register() {
		 
		 UserDTO dto = new UserDTO();
		 
	     dto.setUserId("dumr1wd23");
	     dto.setPassword("password123");
	     dto.setFullName("John Doe");
	     dto.setNickname("Johnny");
	     dto.setBirthdate(new java.sql.Date(System.currentTimeMillis()));  // Setting today's date
	     dto.setPhone("123-456-7890");
	     dto.setEmail("john.doe@example.com");
	     dto.setAddress("123, Dummy Street, Test City, 12345");
	     dto.setUserRole(UserRole.USER);  // Assuming the UserRole enum has been correctly defined
	   
	     UserDAO dao = new UserDAO();
	     dao.userInsert(dto);
	     
		 return "register";
	 }
		 

}
