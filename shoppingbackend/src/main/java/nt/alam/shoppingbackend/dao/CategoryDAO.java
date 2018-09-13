package nt.alam.shoppingbackend.dao;

import java.util.List;

import nt.alam.shoppingbackend.bo.CategoryBO;


public interface CategoryDAO {
	CategoryBO get(Integer id);
	List<CategoryBO> list();
	boolean add(CategoryBO categoryBO);
	boolean update(CategoryBO categoryBO);
	boolean delete(CategoryBO categoryBO);
	
}
