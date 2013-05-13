package ge.iauto.server;

import javax.persistence.EntityManager;

import ge.iauto.model.User;

public class PersistenceService {

	public void addUser(User user){
		EntityManager entitymanager = PersistenceProvider.createEM();
		entitymanager.getTransaction().begin();		
		entitymanager.persist(user);
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}
}
