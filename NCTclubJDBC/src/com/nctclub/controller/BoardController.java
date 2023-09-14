package com.nctclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nctclub.model.BoardDAO;
import com.nctclub.model.BoardDTO;


@Controller
public class BoardController {

	@RequestMapping("/test")
	public String writeform(){
		
	BoardDTO dto = new BoardDTO();
	dto.setEmail("test2");
	dto.setName("test3");
	BoardDAO dao = new BoardDAO();
	int cnt  =  dao.boardInsert(dto);
		
	return "writeform";
	}
}
