package vn.iostar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import vn.iostar.config.JpaConfig;
import vn.iostar.dao.CategoryDao;
import vn.iostar.entity.Category;

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public List<Category> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll",Category.class);
		return query.getResultList();
	}

	@Override
	public void create(Category category) {
		
	}

	@Override
	public void update(Category category) {
		
	}

	@Override
	public void delete(int id) {
		
	}

	@Override
	public Category findById(int id) {

		return null;
	}

}
