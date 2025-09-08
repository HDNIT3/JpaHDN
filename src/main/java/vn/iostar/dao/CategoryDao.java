package vn.iostar.dao;

import java.util.List;

import vn.iostar.entity.Category;

public interface CategoryDao {
	List<Category> findAll();
	void create(Category category);
	void update(Category category);
	void delete(int id);
	Category findById(int id);
	List<Category> findByIdUser(long userid);
}
