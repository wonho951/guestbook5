package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	//필드
	@Autowired
	private GuestbookDao guestDao;
	//생성자
	//메소드 g/s
	//메소드 - 일반
	
	//리스트
	@RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("리스트");
		
		//dao사용
		//GuestbookDao guestDao = new GuestbookDao();
		
		//dao의 메소드로 데이터 가져오기
		List<GuestbookVo> guestList = guestDao.getguestList();
		
		System.out.println(guestList);
		//model담기
		model.addAttribute("guestList", guestList);
		
		//ModelAndView 에서 View 공간
		return "/WEB-INF/views/list.jsp";
		
	}
	
	
	//등록
	@RequestMapping(value = "add", method= {RequestMethod.GET,RequestMethod.POST})
	public String add(@ModelAttribute GuestbookVo guestVo) {
		System.out.println("등록");
		System.out.println(guestVo);
		
		guestDao.guestInsert(guestVo);
		
		return "redirect:/list";
	}
	
	
	//삭제폼
	@RequestMapping(value = "/deleteForm", method= {RequestMethod.GET,RequestMethod.POST})
	public String deleteForm() {
		System.out.println("삭제폼");
		
		//포워드
		return "/WEB-INF/views/deleteForm.jsp";
	}
	
	
	//삭제
	@RequestMapping(value = "/delete", method= {RequestMethod.GET,RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVo guestVo) {	//비밀번호랑 일치해야하니까 vo로함
		System.out.println("삭제");
		
		guestDao.guestDelete(guestVo);
		System.out.println(guestVo);
		
		return "redirect:/list";
	}
	
	
	
}
