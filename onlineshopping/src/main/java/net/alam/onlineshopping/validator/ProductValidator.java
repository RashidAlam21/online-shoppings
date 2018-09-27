package net.alam.onlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import nt.alam.shoppingbackend.bo.ProductBO;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ProductBO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductBO productBO=(ProductBO)target;
		
		//check wheather file has been selected or not
		
		if(productBO.getFile()==null||productBO.getFile().equals("")) {
			errors.rejectValue("file", null,"Please select an image file to upload!");
			return;
		}
		if(!(
			 productBO.getFile().getContentType().equals("image/jpeg")||
			 productBO.getFile().getContentType().equals("image/png")||
			 productBO.getFile().getContentType().equals("image/gif")
		  )) {
			  errors.rejectValue("file",null,"please used only image file for uploaded!");
			  return;
		}

	}

}
