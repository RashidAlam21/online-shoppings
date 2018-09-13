package nt.alam.shoppingbackend.dao;

import java.util.List;

import nt.alam.shoppingbackend.bo.ProductBO;

public interface ProductDAO {
	ProductBO get(int productId);
	List<ProductBO> list();
	boolean add(ProductBO productBO);
	boolean update(ProductBO productBO);
	boolean delete(ProductBO productBO);
	
	//business method
	List<ProductBO> listActiveProducts();
	List<ProductBO> listActiveProductsByCategory(int categoryId);
	List<ProductBO> getLatestActiveproducts(int count);
	
}
