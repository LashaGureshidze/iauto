package ge.iauto.server;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ge.iauto.model.User;

public class PersistenceService {

	public void addUser(User user){
		EntityManager entitymanager = PersistenceProvider.createEM();
		entitymanager.getTransaction().begin();		
		entitymanager.persist(user);
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}
	
	public boolean existsUserName(String username){
		EntityManager entitymanager = PersistenceProvider.createEM();
		Query q = entitymanager.createQuery("SELECT COUNT(*) FROM User WHERE username = :name");
		q.setParameter("name", username);
		if(Long.valueOf(q.getSingleResult().toString()) ==0){
			return false;
		}
		return true;
	}
}
