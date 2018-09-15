package net.alam.onlineshopping.customexception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public ProductNotFoundException() {
		//super();
		this("Product is not available");
	}

	public ProductNotFoundException(String message) {
		super(message);
		this.message=System.currentTimeMillis()+" :";
	}

	public String getMessage() {
		return message;
	}
	
	
}
