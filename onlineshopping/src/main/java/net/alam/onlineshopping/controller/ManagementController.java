package net.alam.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.alam.onlineshopping.utility.FileUploadUtility;
import net.alam.onlineshopping.validator.ProductValidator;
import nt.alam.shoppingbackend.bo.CategoryBO;
import nt.alam.shoppingbackend.bo.ProductBO;
import nt.alam.shoppingbackend.dao.CategoryDAO;
import nt.alam.shoppingbackend.dao.ProductDAO;

@Controller
@RequestMapping(value="/manage")
public class ManagementController {
	@Autowired
	private CategoryDAO CategoryDAO;
	@Autowired
	private ProductDAO ProductDAO;
	private static final Logger logger=LoggerFactory.getLogger(ManagementController.class);
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public String manageProduct(Model m,@RequestParam(name="operation",required=false)String operation) {
		m.addAttribute("userClickManageProduct", true);
		m.addAttribute("title", "Manage Products");
		ProductBO products=new ProductBO();
		products.setSupplierId(1);
		products.setActive(true);
		m.addAttribute("product", products);
		if(operation!=null) {
			if(operation.equals("product")) {
				m.addAttribute("message","Product Submitted Sucessfully!");
			}
			else if(operation.equals("category")) {
				m.addAttribute("message","Category Submitted Sucessfully!");
			}
		}
		return "page";
	}
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product")ProductBO mProduct,BindingResult result,Model m,HttpServletRequest request) {
		if(mProduct.getId()==0) {
			new ProductValidator().validate(mProduct, result);
		}
		else {
			if(!mProduct.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mProduct, result);
			}
		}
		
		//check if there are any errors.
		if(result.hasErrors()) {
			m.addAttribute("userClickManageProduct", true);
			m.addAttribute("title", "Manage Products");
			m.addAttribute("message", "Validation failed for product submission!");
			return "page";
		}
		//create a new product record.
		logger.info(mProduct.toString());
		if(mProduct.getId()==0) {
			//create a product if product id is 0.
			ProductDAO.add(mProduct);
		}
		else {
			//update the product if product id is not 0.
			ProductDAO.update(mProduct);
		}
		
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
		}
		return "redirect:/manage/products?operation=product";
	}
	/**
	 * return categories for all the request mapping
	 * @return
	 */
	@ModelAttribute(value="categories")
	public List<CategoryBO> getCategories(){
		return CategoryDAO.list();
	}
	
	@RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		//is going to fetch product from the database. 
		ProductBO productBO=ProductDAO.get(id);
		System.out.println("productBo object -->  "+productBO);
		boolean isActive=productBO.isActive();
		System.out.println(isActive +" <--- boolean value ");
		//activate and deactivate based on the value of active field.
		productBO.setActive(!productBO.isActive());
		//updating the field.
		ProductDAO.update(productBO);
		return (isActive)?
				"You have successfully deactivated the product with id :- "+productBO.getId() 
				:"You have successfully activated the product with id :- "+productBO.getId();
	}
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public String showEditProduct(Model m,@PathVariable int id) {
		m.addAttribute("userClickManageProduct", true);
		m.addAttribute("title", "Manage Products");
		//fetch the product from the database
		ProductBO productBO=ProductDAO.get(id);
		//set the product fetch form database.
		
		m.addAttribute("product",productBO);
		return "page";
	}
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute CategoryBO category) {
		CategoryDAO.add(category);
		//redirect:/manage/products?operation=product";
		return "redirect:/manage/products?operation=category";
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@ModelAttribute(value="category")
	public CategoryBO getCategory() {
		return new CategoryBO();
	}
}
