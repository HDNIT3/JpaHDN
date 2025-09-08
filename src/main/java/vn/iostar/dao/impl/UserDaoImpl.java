package vn.iostar.dao.impl;

import jakarta.persistence.EntityManager;
import vn.iostar.config.JpaConfig;
import vn.iostar.dao.UserDao;
import vn.iostar.entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User findById(int userid) {
		EntityManager enma = JpaConfig.getEntityManager();
		try {
			return enma.find(User.class, userid);
		} finally {
			enma.close();
		}
	}

	@Override
	public Boolean CheckPass(String username, String password) {
		EntityManager enma = JpaConfig.getEntityManager();
		try {
			String jpql = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";
			User user = enma.createQuery(jpql, User.class).setParameter("username", username)
					.setParameter("password", password).getSingleResult();
			return user != null;
		} catch (Exception e) {
			return false;
		} finally {
			enma.close();
		}
	}

	@Override
	public User findByName(String username) {
		EntityManager enma = JpaConfig.getEntityManager();
		try {
			User user = enma.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
					.setParameter("username", username).getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		} finally {
			enma.close();
		}
	}

}
