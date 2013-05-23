package ge.iauto.server;

import java.util.List;

import ge.iauto.data.Car;
import ge.iauto.data.CarMake;
import ge.iauto.data.CarModel;
import ge.iauto.data.Category;
import ge.iauto.data.Location;
import ge.iauto.data.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class PersistenceService {

	public void saveUser(User user){
		EntityManager entitymanager = PersistenceProvider.createEM();
		entitymanager.getTransaction().begin();		
		entitymanager.persist(user);
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}
	
	public void saveCarMake(CarMake carMake){
		EntityManager entitymanager = PersistenceProvider.createEM();
		entitymanager.getTransaction().begin();		
		entitymanager.persist(carMake);
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}
	
	public void saveCarModel(CarModel carModel){
		EntityManager entitymanager = PersistenceProvider.createEM();
		entitymanager.getTransaction().begin();		
		entitymanager.persist(carModel);
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}
	
	public void saveLocation(Location location){
		EntityManager entitymanager = PersistenceProvider.createEM();
		entitymanager.getTransaction().begin();		
		entitymanager.persist(location);
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}
	
	public void saveCategory(Category category){
		EntityManager entitymanager = PersistenceProvider.createEM();
		entitymanager.getTransaction().begin();		
		entitymanager.persist(category);
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}
	
	public void saveCar(Car car){
		EntityManager entitymanager = PersistenceProvider.createEM();
		entitymanager.getTransaction().begin();		
		entitymanager.persist(car);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		System.out.println("saved! !");
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
	
	public boolean existsEmail(String email) {
		EntityManager entitymanager = PersistenceProvider.createEM();
		Query q = entitymanager.createQuery("SELECT COUNT(*) FROM User WHERE email = :email");
		q.setParameter("email", email);
		if (Long.valueOf(q.getSingleResult().toString()) == 0) {
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
	
	@SuppressWarnings("unchecked")
	public List<Location> getLocations(){
		EntityManager entitymanager = PersistenceProvider.createEM();
		Query q = entitymanager.createQuery("FROM Location");
		List<Location> result = q.getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> getCategories(){
		EntityManager entitymanager = PersistenceProvider.createEM();
		Query q = entitymanager.createQuery("FROM Category");
		List<Category> result = q.getResultList();
		return result;
	}

	public void changeEmail(String username, String newEmail) {
		EntityManager entitymanager = PersistenceProvider.createEM();
		entitymanager.getTransaction().begin();		
		Query q = entitymanager.createQuery("UPDATE User SET email = :newEmail WHERE username = :name");
		q.setParameter("newEmail", newEmail);
		q.setParameter("name", username);
		q.executeUpdate();
        entitymanager.getTransaction().commit();
		entitymanager.close();
	}

	public void changePassword(String username, String newPassword) {
		EntityManager entitymanager = PersistenceProvider.createEM();
		entitymanager.getTransaction().begin();		
		Query q = entitymanager.createQuery("UPDATE User SET password = :newPassword WHERE username = :name");
		q.setParameter("newPassword", newPassword);
		q.setParameter("name", username);
		q.executeUpdate();
        entitymanager.getTransaction().commit();
		entitymanager.close();
	}

	public void changeUsername(String username, String newUsername) {
		EntityManager entitymanager = PersistenceProvider.createEM();
		entitymanager.getTransaction().begin();		
		Query q = entitymanager.createQuery("UPDATE User SET username = :newUsername WHERE username = :name");
		q.setParameter("newUsername", newUsername);
		q.setParameter("name", username);
		q.executeUpdate();
        entitymanager.getTransaction().commit();
		entitymanager.close();
	}
	
	public Category findCategory(long id){
		EntityManager entitymanager = PersistenceProvider.createEM();
		Category cat = entitymanager.find(Category.class, id);
		return cat;
	}
	
	public CarMake findCarMake(long id){
		EntityManager entitymanager = PersistenceProvider.createEM();
		CarMake car = entitymanager.find(CarMake.class, id);
		return car;
	}
	
	public CarModel findCarModel(long id){
		EntityManager entitymanager = PersistenceProvider.createEM();
		CarModel car = entitymanager.find(CarModel.class, id);
		return car;
	}
	
	public Location findLocation(long id){
		EntityManager entitymanager = PersistenceProvider.createEM();
		Location loc = entitymanager.find(Location.class, id);
		return loc;
	}
}
