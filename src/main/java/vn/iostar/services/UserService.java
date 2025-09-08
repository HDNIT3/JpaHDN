package vn.iostar.services;

import vn.iostar.entity.User;

public interface UserService {
	User findById(int userid);
	Boolean CheckPass(String username,String password);
	User findByName(String username);
}
