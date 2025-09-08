package vn.iostar.services.impl;

import java.util.List;

import vn.iostar.dao.CategoryDao;
import vn.iostar.dao.impl.CategoryDaoImpl;
import vn.iostar.entity.Category;
import vn.iostar.services.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
    CategoryDao cateDao = new CategoryDaoImpl();
	
    @Override
    public List<Category> findAll() {
        return cateDao.findAll();
    }

    @Override
    public void create(Category category) {
        cateDao.create(category);
    }

    @Override
    public void update(Category category) {
        cateDao.update(category);
    }

    @Override
    public void delete(int id) {
        cateDao.delete(id);
    }

    @Override
    public Category findById(int id) {
        return cateDao.findById(id);
    }

	@Override
	public List<Category> findByIdUser(long userid) {
		return cateDao.findByIdUser(userid);
	}
}
