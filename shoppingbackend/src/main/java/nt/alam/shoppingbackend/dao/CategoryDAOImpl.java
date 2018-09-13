package nt.alam.shoppingbackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nt.alam.shoppingbackend.bo.CategoryBO;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	private static List<CategoryBO> categories = new ArrayList<>();
	static {
		CategoryBO category = new CategoryBO();
		/**
		 * adding first category
		 */
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some description for television");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		/**
		 * adding second category
		 */
		CategoryBO category1 = new CategoryBO();
		category1.setId(2);
		category1.setName("Desktop");
		category1.setDescription("This is some description for Desktop");
		category1.setImageURL("CAT_2.png");
		categories.add(category1);
		/**
		 * adding 3rd category
		 */
		CategoryBO category2 = new CategoryBO();
		category2.setId(3);
		category2.setName("Laptop");
		category2.setDescription("This is some description for Laptop");
		category2.setImageURL("CAT_3.png");
		categories.add(category2);
		/**
		 * adding 4rth category
		 */
		CategoryBO category3 = new CategoryBO();
		category3.setId(4);
		category3.setName("Mobile");
		category3.setDescription("This is some description for television");
		category3.setImageURL("CAT_4.png");
		categories.add(category3);
	}

	@Override
	public List<CategoryBO> list() {
		String selectActiveCategory="FROM CategoryBO Where active=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	/**
	 * Getting Single Category based on id.
	 */
	@Override
	public CategoryBO get(Integer id) {

		return sessionFactory.getCurrentSession().get(CategoryBO.class, id);
	}

	@Override
	public boolean add(CategoryBO categoryBO) {
		try {
			/**
			 * add the category to the database.
			 */
			sessionFactory.getCurrentSession().persist(categoryBO);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}
	/**
	 * Updating a Single Category.
	 */
	@Override
	public boolean update(CategoryBO categoryBO) {
		try {
			 //upadate the category to the database.
			sessionFactory.getCurrentSession().update(categoryBO);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	/**
	 * Delete a Single Category.
	 */
	@Override
	public boolean delete(CategoryBO categoryBO) {
		categoryBO.setActive(false);
		try {
			 //delete the category to the database.
			sessionFactory.getCurrentSession().update(categoryBO);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
