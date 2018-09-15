package net.alam.onlineshopping.customexception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	@ExceptionHandler(value=NoHandlerFoundException.class)
	public String handlerNoHandlerFoundException(Model m) {
		m.addAttribute("errorTitle","The page is not constructed");
		m.addAttribute("errorDescription","The page you are looking for is not available now!");
		m.addAttribute("title","400 Error Page");
		
		return "error";
	}
	
	@ExceptionHandler(value=ProductNotFoundException.class)
	public String handlerProductNotFoundException(Model m) {
		m.addAttribute("errorTitle","Product is not constructed");
		m.addAttribute("errorDescription","The product you are looking for is not available right now!");
		m.addAttribute("title","500 Product Not Available");
		
		return "error";
	}
	
	@ExceptionHandler(value=Exception.class)
	public String handlerException(Exception ex,Model m) {
		m.addAttribute("errorTitle","contact your Adminstrator!");
		//only or debugging purpose
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		ex.printStackTrace(pw);
		m.addAttribute("errorDescription",sw.toString());
		m.addAttribute("title","500 Error");
		
		return "error";
	}
}
