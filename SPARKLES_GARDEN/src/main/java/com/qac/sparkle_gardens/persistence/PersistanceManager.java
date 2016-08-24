package com.qac.sparkle_gardens.persistence;

import javax.ejb.Singleton;
import javax.persistence.*;

@Singleton
public class PersistanceManager {

	private EntityManagerFactory emf;

	public EntityManager CreateEntityManager() {
		try {
			emf = Persistence.createEntityManagerFactory("BookLibraryPU");
			EntityManager em = emf.createEntityManager();
			return em;
		} catch (PersistenceException pe) {
			return null;
		}
	}

	public void CloseEntityManager(EntityManager em) {
		em.close();
		emf.close();
	}
}