package net.alam.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.alam.onlineshopping.customexception.ProductNotFoundException;
import nt.alam.shoppingbackend.bo.CategoryBO;
import nt.alam.shoppingbackend.bo.ProductBO;
import nt.alam.shoppingbackend.dao.CategoryDAO;
import nt.alam.shoppingbackend.dao.ProductDAO;

@Controller

public class ProductController {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	/**
	 * method to load all product and based on category
	 */
	@RequestMapping(value="/show/all/products",method=RequestMethod.GET)
	public String showAllProducts(Model m) {
		m.addAttribute("title","All Products");
		/**
		 * passing the list of categories..
		 */
		m.addAttribute("categories", categoryDAO.list());
		m.addAttribute("userClickedAllProducts", true);
		
		return "page";
		
	}
	@RequestMapping(value="/show/category/{id}/products",method=RequestMethod.GET)
	public String showCategoryProducts(Model m,@PathVariable("id") Integer id) {
		/**
		 * CategoryDAO to fetch a single category..
		 */
		System.out.println(id);
		CategoryBO category=null;
		category=categoryDAO.get(id);
		System.out.println(category);
		m.addAttribute("title",category.getName());
		/**
		 * passing the list of categories..
		 */
		m.addAttribute("categories", categoryDAO.list());
		/**
		 * passing the single category object
		 */
		m.addAttribute("category", category);
		
		m.addAttribute("userClickedCategoryProducts", true);
		
		return "page";
		
	}
	/**
	 * * viewing a single product
	 * @param m
	 * @param id
	 * @return
	 */
	@RequestMapping(value= {"/show/{id}/product"})
	public String showSingleProduct(Model m,@PathVariable int id)throws  ProductNotFoundException {
		ProductBO productBO=null;
		productBO=productDAO.get(id);
		if(productBO==null)
		   throw new ProductNotFoundException(); 
		//update the view count;
		productBO.setViews(productBO.getViews()+1);
		productDAO.update(productBO);
		//--------------------------------------
		m.addAttribute("title", productBO.getName());
		m.addAttribute("products",productBO);
		//check userClickedShowProduct in list of product
		m.addAttribute("userClickedShowProduct",true);
		return "page";
	}
}
