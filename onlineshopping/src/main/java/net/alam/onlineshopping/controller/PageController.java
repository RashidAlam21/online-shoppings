package net.alam.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@RequestMapping(value= {"/","/home","/index"},method=RequestMethod.GET)
	public ModelAndView index() {
		System.out.println("ModelAndView");
		ModelAndView mav=new ModelAndView("page");
		mav.addObject("greeting","Welcome to spring mvc");
		return mav;
	}
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting",required=false) String greeting) {
		System.out.println("ModelAndView");
		if(greeting==null)
			greeting="Md Rashid";
		ModelAndView mav=new ModelAndView("page");
		mav.addObject("greeting",greeting);
		return mav;
	}
	@RequestMapping(value="/test1/{greeting}")
	public ModelAndView test1(@PathVariable("greeting") String greeting) {
		System.out.println("ModelAndView");
		ModelAndView mav=new ModelAndView("page");
		mav.addObject("greeting",greeting);
		return mav;
	}
}
