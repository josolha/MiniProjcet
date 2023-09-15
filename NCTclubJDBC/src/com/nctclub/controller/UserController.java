package com.nctclub.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nctclub.model.UserDTO;
import com.nctclub.service.UserService;



@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/registerform", method = RequestMethod.GET)
	public String registerform() {
		return "registerform";
	}
	
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String userRegister(@ModelAttribute UserDTO userDto) {
    	int result = userService.userRegister(userDto);
    	System.out.println(result);
        return "main";
    }
    
    // 로그인 폼 /loginform.jsp > 사용자 등록하면 login으로 넘어감.
    @RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public String loginform() {
		return "loginform";
	}
    @RequestMapping(value="/main", method = RequestMethod.GET)
    public String main() {
		return "main";
	}


    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String loginProcess(UserDTO dto, HttpServletRequest req, Model model) {
    	
       UserDTO result = userService.userLogin(dto);
       
       if(result !=null) {
    	   HttpSession session = req.getSession();
           session.setAttribute("loginDto", result);  
           System.out.println(result);
           return "redirect:main";
       }
        model.addAttribute("errorMessage", "아이디 또는 비밀번호가 틀렸습니다.");
        return "redirect:loginform";
    }
}
