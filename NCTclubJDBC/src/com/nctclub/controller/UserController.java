package com.nctclub.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.nctclub.model.UserDAO;
import com.nctclub.model.UserDTO;
import com.nctclub.service.UserService;
import com.nctclub.utils.UserRole;


@Controller
@RequestMapping("/user")
public class UserController {
	
//	@Autowired
//	UserDAO userdao;
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/registerform", method = RequestMethod.GET)
	public String registerform() {
		return "registerform";
	}
	
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String userRegister(@ModelAttribute UserDTO userDto) {
    	
    	UserDAO dao = new UserDAO();
    	
    	// 사용자/admin을 구분짓는 로직이 필요함.
    	userDto.setUserRole(UserRole.USER);
    	// 비밀번호 암호화 과정이 필요함.(db에서도) 
    	
    	dao.userInsert(userDto);
     
      System.out.println(userDto.getEmail());
           
       return "main";
    }
    
    // 로그인 폼 /loginform.jsp > 사용자 등록하면 login으로 넘어감.
    @RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public String loginform() {
		return "loginform";
	}
    
    
    //1.
    
	//    // 로그인 /login
	//    @RequestMapping(value = "/login", method = RequestMethod.POST)
	//    public String login(@ModelAttribute UserDTO userDto) {
	//    	UserDAO dao = new UserDAO();
	//    	int result = dao.memberCheck(userDto.getUserId(), userDto.getPassword());
	//    	System.out.println(result);
	//    	// 로그인 결과값에 따라서 리턴값이 달라져야 한다.
	//    	if (result ==1) {
	//    		return "main";
	//    	} else if (result ==0) {
	//    		return "비밀번호가 올바르지 않습니다.";
	//    	} else {
	//    		return "아이디가 올바르지 않습니다. ";
	//    	}
	//    }
    

    
    
    
    //2.세션을 사용하는 방법
    //세션 낭비가되서 삭제 하는 방법이 필요함 
    @RequestMapping(value="memberLogin.do", method=RequestMethod.POST)
    public String userLogin(UserDTO dto, HttpServletRequest req) {
        
        System.out.println("id : " + dto.getId());        
        HttpSession session = req.getSession();
        
        boolean result = userService.userLogin(dto, req);
        
        if(!result) { 
            session.setAttribute("result", 0); 
            return "redirect:memberLogin.do";
        }
        
        return "redirect:memberList.do";
    }
    
    //3.URL 파라미터를 사용하는 방법
    @RequestMapping(value="memberLogin.do", method=RequestMethod.POST)
    public String userLogin2(UserDTO dto, HttpServletRequest req) {
        
        System.out.println("id : " + dto.getId());        
        
        boolean result = userService.userLogin(dto, req);
        
        if(!result) { 
            return "redirect:memberLogin.do?result=0";
        }
        
        return "redirect:memberList.do";
    }


	

}
