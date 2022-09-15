package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CRUDController {
	@Autowired
	StudentDAO dao;
	Logger log=Logger.getAnonymousLogger();

	@RequestMapping("/")
	public ModelAndView load(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}

	@RequestMapping("/insert")
	public ModelAndView insert(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		log.info("inside the insert");
		Student s=new Student();
		s.setName(request.getParameter("name"));
		s.setPhoneno(request.getParameter("phono"));
		s.setEmail(request.getParameter("email"));
		log.info(s.getPhoneno()+"   "+s.getName()+" "+s.getEmail());
		Student ss=dao.insert(s);
		if(ss!=null) {
			mv.setViewName("status.jsp");
		}

		return mv;

	}


	@RequestMapping("/get")
	public ModelAndView getall(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();	
		List<Student> list=dao.getAll();
		mv.setViewName("display.jsp");
		mv.addObject("list",list);
		return mv;

	}

	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response) {
		log.info("inside the update");
		ModelAndView mv=new ModelAndView();
		Student s=new Student();
		s.setSid(Integer.parseInt(request.getParameter("id")));
		s.setName(request.getParameter("name"));
		log.info(s.getSid()+"   "+s.getName());
		Student ss=dao.updateName(s);
		if(ss!=null) {
			mv.setViewName("update.jsp");
		}

		return mv;

	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Student s=new Student();
		s.setSid(Integer.parseInt(request.getParameter("id")));
		dao.deleteById(s.getSid());
		mv.setViewName("delete-display.jsp");

		return mv;

	}

}
