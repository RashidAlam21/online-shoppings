package nt.alam.shoppingbackend.test.mockito;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import nt.alam.shoppingbackend.bo.CategoryBO;
import nt.alam.shoppingbackend.dao.CategoryDAO;
import nt.alam.shoppingbackend.test.config.SpringRootConfig;

@ContextConfiguration(classes=SpringRootConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryMockitoTestCase {
	@Autowired
	private CategoryDAO categoryDAO;
	private CategoryBO categoryBO;
	@Before
	public void setUpMock() {
		MockitoAnnotations.initMocks(this);
		categoryBO=Mockito.mock(CategoryBO.class);
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
		assertEquals("Successfully fetch to a single category from the table!", "Lappy", categoryBO.getName());    
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

}
