package ge.iauto.server;

import java.util.List;

import ge.iauto.data.CarMake;
import ge.iauto.data.CarModel;
import ge.iauto.data.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class PersistenceService {

	public void addUser(User user){
		EntityManager entitymanager = PersistenceProvider.createEM();
		entitymanager.getTransaction().begin();		
		entitymanager.persist(user);
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}
	
	public void addCarMark(CarMake carMake){
		EntityManager entitymanager = PersistenceProvider.createEM();
		entitymanager.getTransaction().begin();		
		entitymanager.persist(carMake);
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}
	
	public void addCarModel(CarModel carModel){
		EntityManager entitymanager = PersistenceProvider.createEM();
		entitymanager.getTransaction().begin();		
		entitymanager.persist(carModel);
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
	
	public User getUser(String username,String password){
		EntityManager entitymanager = PersistenceProvider.createEM();
		Query q = entitymanager.createQuery("FROM User WHERE username = :name and password = :pass");
		q.setParameter("name", username);
		q.setParameter("pass", password);
		User user = null;
		try{
			user = (User)q.getSingleResult();
		}catch(NoResultException e){
			
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<CarMake> getCarMakes(){
		EntityManager entitymanager = PersistenceProvider.createEM();
		Query q = entitymanager.createQuery("FROM CarMake");
		List<CarMake> result = q.getResultList();
		return result;
	}
}
