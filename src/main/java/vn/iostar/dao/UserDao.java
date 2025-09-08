package vn.iostar.dao;

import vn.iostar.entity.User;

public interface UserDao {
	User findById(int userid);
	Boolean CheckPass(String username,String password);
	User findByName(String username);
}
