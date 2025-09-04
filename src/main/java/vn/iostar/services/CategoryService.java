package vn.iostar.services;

import java.util.List;

import vn.iostar.entity.Category;

public interface CategoryService {
	List<Category> findAll();
	void create(Category category);
	void update(Category category);
	void delete(int id);
	Category findById(int id);
}
