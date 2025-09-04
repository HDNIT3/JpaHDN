package vn.iostar.config;

import jakarta.persistence.*;

public class JpaConfig {
	public static EntityManager getEntityManager() {
		 EntityManagerFactory factory = 
				 Persistence.createEntityManagerFactory("dataSource");
		 return factory.createEntityManager();
	}
}
