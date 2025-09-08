package vn.iostar.services.impl;

import vn.iostar.dao.UserDao;
import vn.iostar.dao.impl.UserDaoImpl;
import vn.iostar.entity.User;
import vn.iostar.services.UserService;

public class UserServiceImpl implements UserService{
	UserDao userdao = new UserDaoImpl();
	@Override
	public User findById(int userid) {
		return userdao.findById(userid);
	}

	@Override
	public Boolean CheckPass(String username, String password) {
		return userdao.CheckPass(username, password);
	}

	@Override
	public User findByName(String username) {
		return userdao.findByName(username);
	}

}
