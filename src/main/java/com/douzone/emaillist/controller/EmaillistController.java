package com.douzone.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.douzone.emaillist.dao.EmaillistDao;
import com.douzone.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	@Autowired
	private EmaillistDao emaillistDao;
	//AutoWired를 해줘야지 연결이 완료된다. 이렇게 연결시켜주면 에러가 안나야지 잘 연결된것이다.

	// 1번째 방법 : ModelAndView ( 비추천 )

	//	@RequestMapping({"/list", "/main", ""})
	//	public ModelAndView list() {
	//		ModelAndView mav = new ModelAndView();
	//		mav.addObject("list",emaillistDao.getList());
	//		mav.setViewName("WEB-INF/views/list.jsp");
	//		return mav;
	//	}

	// 2번째 방법 : model

	@RequestMapping({"/list", "/main", ""})
	public String list(Model model) {
		model.addAttribute("list", emaillistDao.getList());
		return "WEB-INF/views/list.jsp";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(EmaillistVo emaillistVo) {
		emaillistDao.insert(emaillistVo);
		return "redirect:/";
	}
}
