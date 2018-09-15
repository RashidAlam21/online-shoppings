package nt.alam.shoppingbackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nt.alam.shoppingbackend.bo.ProductBO;
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public ProductBO get(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(ProductBO.class, Integer.valueOf(productId)); 
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductBO> list() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM ProductBO ",ProductBO.class).getResultList();
	}

	@Override
	public boolean add(ProductBO productBO) {
		try {
			 sessionFactory.getCurrentSession().persist(productBO);
			 return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(ProductBO productBO) {
		try {
			 sessionFactory.getCurrentSession().update(productBO);
			 return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(ProductBO productBO) {
		productBO.setActive(false);
		try {
			 sessionFactory.getCurrentSession().update(productBO);
			 return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ProductBO> listActiveProducts() {
		String selectActiveProducts="FROM ProductBO WHERE active=:active order by id";
		return sessionFactory
				.getCurrentSession()
				   .createQuery(selectActiveProducts, ProductBO.class)
				     .setParameter("active", true)
				       .getResultList();
	}

	@Override
	public List<ProductBO> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory="FROM ProductBO WHERE active=:active AND categoryId=:categoryId";
		return sessionFactory
				.getCurrentSession()
				   .createQuery(selectActiveProductsByCategory, ProductBO.class)
				     .setParameter("active", true)
				       .setParameter("categoryId",categoryId)
				         .getResultList();
	}

	@Override
	public List<ProductBO> getLatestActiveproducts(int count) {
		return sessionFactory
				.getCurrentSession()
				   .createQuery("FROM ProductBO WHERE active=:active ORDER BY id", ProductBO.class)
				     .setParameter("active", true)
				       .setFirstResult(0)
				       .setMaxResults(count)
				         .getResultList();
	}

}
