package net.alam.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import nt.alam.shoppingbackend.dao.CategoryDAO;

@Controller
public class PageController {
	@Autowired
	private CategoryDAO categoryDAO;
	@RequestMapping(value= {"/","/home","/index"},method=RequestMethod.GET)
	public ModelAndView index() {
		System.out.println("ModelAndView");
		ModelAndView mav=new ModelAndView("page");
		mav.addObject("title","Home");
		mav.addObject("categories", categoryDAO.list());
		//System.out.println(categoryDAO.list());
		mav.addObject("userClickedHome", true);
		return mav;
	}
	@RequestMapping(value="/about")
	public String about(Model m) {
		m.addAttribute("title", "About Us");
		m.addAttribute("userClickedAbout", true);
		return "page";
	}
	@RequestMapping(value="/contact")
	public String contact(Model m) {
		m.addAttribute("title", "Contact Us");
		m.addAttribute("userClickedContact", true);
		return "page";
	}

}
