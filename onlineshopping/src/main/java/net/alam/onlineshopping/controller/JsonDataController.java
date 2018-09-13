package net.alam.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import nt.alam.shoppingbackend.bo.ProductBO;
import nt.alam.shoppingbackend.dao.ProductDAO;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	@Autowired
	private ProductDAO productDAO;
	@RequestMapping("/all/product")
	@ResponseBody
	public List<ProductBO> getAllProducts(){
		return productDAO.listActiveProducts();
	}
	@RequestMapping( "/category/{id}/product")
	@ResponseBody
	public List<ProductBO> getPropductsByCategory(@PathVariable int id){
		return productDAO.listActiveProductsByCategory(id);
	}
}
