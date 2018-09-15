package nt.alam.shoppingbackend.test.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
import nt.alam.shoppingbackend.bo.ProductBO;
import nt.alam.shoppingbackend.dao.ProductDAO;
import nt.alam.shoppingbackend.test.config.SpringRootConfig;
@ContextConfiguration(classes=SpringRootConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductMockitoTestCase {
	@Autowired
	private ProductDAO productDAO;
	private  ProductBO productBO;
	
	@Before
	public void setUpMock() {
		MockitoAnnotations.initMocks(this);
		productBO=Mockito.mock(ProductBO.class);
	}

	@Test
	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void testAddProduct() {
		productBO=new ProductBO();
		productBO.setCode("PRDABC123DEFZ");
		productBO.setName("Redmi note5");
		productBO.setBrand("RedMI");
		productBO.setDescription("This is one of the best phone available in the market right now !");
		productBO.setUnitPrice(15479.00);
		productBO.setQuantity(2);
		productBO.setActive(true);
		productBO.setCategoryId(2);
		productBO.setSupplierId(1);
		assertEquals("Successfully added to a product inside the table", true, productDAO.add(productBO));
	}
	@Test
	@Ignore
	public void testGetProduct() {
		productBO=productDAO.get(5);
		assertEquals("Successfully fetch to a single product from the table!", "dell", productBO.getBrand());
	}
	@Test
	@Ignore
	public void testUpdateProduct() {
		productBO=productDAO.get(5);
		productBO.setQuantity(6);
		assertEquals("Successfully updated to a product in the table", true, productDAO.update(productBO));
	}
	@Test
	@Ignore
	public void testDeleteProduct() {
		productBO=productDAO.get(5);
		assertEquals("Successfully delete to a product in the table", true, productDAO.delete(productBO));
	}
	@Test
	@Ignore
	public void testListProduct() {
		assertEquals("Successfully fetched the list of a product from the table", 6,  productDAO.list().size());
	}
	@Test
	@Ignore
	public void testlistActiveProducts() {
		assertEquals("Successfully fetched the list of a active product from the table", 5,  productDAO.listActiveProducts().size());
	}
	@Test
	@Ignore
	public void testlistActiveProductsByCategory() {
		assertEquals("Successfully fetched the list of a active product by category from the table", 1,  productDAO.listActiveProductsByCategory(2).size());
	}
	@Test
	public void testgetLatestActiveproducts() {
		assertEquals("Successfully fetched the list of latest active product by category from the table", 3,  productDAO.getLatestActiveproducts(3).size());
	}
}
