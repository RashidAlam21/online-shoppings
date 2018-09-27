package nt.alam.shoppingbackend.test.junit;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import nt.alam.shoppingbackend.bo.CategoryBO;
import nt.alam.shoppingbackend.dao.CategoryDAO;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	// @Autowired
	private static CategoryDAO categoryDAO;
	private static CategoryBO categoryBO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("nt.alam.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	@Ignore
	public void testAddCategory() {
		categoryBO = new CategoryBO();
		categoryBO.setName("Mobile");
		categoryBO.setDescription("This is some description for television");
		categoryBO.setImageURL("CAT_4.png");
		assertEquals("Successfully added to a category inside the table", true, categoryDAO.add(categoryBO));
	}

	@Ignore
	@Test
	public void testGetCategory() {
		categoryBO = categoryDAO.get(3);
		assertEquals("Successfully fetch to a single category from the table!", "Laptop", categoryBO.getName());

	}

	@Test
	@Ignore
	public void testUpdateCategory() {
		categoryBO = categoryDAO.get(3);
		categoryBO.setName("Lappy");
		assertEquals("Successfully updated to a category in the table", true, categoryDAO.update(categoryBO));
	}

	@Test
	@Ignore
	public void testDeleteCategory() {
		categoryBO = categoryDAO.get(3);
		assertEquals("Successfully delete to a category in the table", true, categoryDAO.delete(categoryBO));
	}

	@Test
	
	public void testListCategory() {
		categoryBO = categoryDAO.get(3);
		assertEquals("Successfully fetched the list of a category from the table", 6, categoryDAO.list().size());
	}

	@Test
	@Ignore
	public void testCrudCategory() {
		//Add the Category in the table.
//		categoryBO = new CategoryBO();
//		categoryBO.setName("Refrigrator");
//		categoryBO.setDescription("This is some description for Refrigrator");
//		categoryBO.setImageURL("CAT_5.png");
//		assertEquals("Successfully added to a category inside the table", true, categoryDAO.add(categoryBO));
//		
//		categoryBO = new CategoryBO();
//		categoryBO.setName("Washine Machine");
//		categoryBO.setDescription("This is some description for Washing Machine");
//		categoryBO.setImageURL("CAT_5.png");
//		assertEquals("Successfully added to a category inside the table", true, categoryDAO.add(categoryBO));
		
		//fetching and renaming(updating) the category.
		categoryBO = categoryDAO.get(3);
		categoryBO.setName("Lappy");
		assertEquals("Successfully updated to a category in the table", true, categoryDAO.update(categoryBO));
		
		//delete the category.
		categoryBO = categoryDAO.get(3);
		assertEquals("Successfully delete to a category in the table", true, categoryDAO.delete(categoryBO));
		
		//fetching the list
		//categoryBO = categoryDAO.get(3);
		assertEquals("Successfully fetched the list of a category from the table", 5, categoryDAO.list().size());
	}

}
