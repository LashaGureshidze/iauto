package ge.iauto.server;

import ge.iauto.server.model.Car;
import ge.iauto.server.model.CarMake;
import ge.iauto.server.model.CarModel;
import ge.iauto.server.model.Category;
import ge.iauto.server.model.Location;
import ge.iauto.server.model.SearchData;
import ge.iauto.server.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	public List<Car> getCars(String queryString){
		EntityManager entitymanager = PersistenceProvider.createEM();
		Query q = entitymanager.createQuery(queryString);
		List<Car> result = q.getResultList();
		return result;
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

	public void updateUser(User user, String oldUsername) {
		EntityManager entitymanager = PersistenceProvider.createEM();
        Query q = entitymanager.createQuery("SELECT COUNT(*) FROM User WHERE username= :name");
        q.setParameter("name", oldUsername);
        if (Long.valueOf(q.getSingleResult().toString()) <= 1) {
        	entitymanager.getTransaction().begin();
        	entitymanager.merge(user);
        	entitymanager.getTransaction().commit();
        	entitymanager.close();
        }
	}
/**
 * უზრუნველყოფს ბაზიდან მანქანების სიის წამოღებას	
 * @param data - SearchData ტიპის ობიექტი, რომელშიც გაწერილის ის პარამეტრები, რის მიხედვითაც ხდება მანქანაბეი მოძებნა
 * @param firsResult - ინდექსი, რომლიდანაც დაიწყება მანქანების მოძიება
 * @param maxResult - მანქანების მაქსიმალური რაოდენობა, რაც ერთ ჯერზე შეიძლება დაბრუნდეს
 * @return  - მოზებნილი მანქანების კოლექცია
 */
	@SuppressWarnings("unchecked")
	public List<Car> loadCars(SearchData data,int firsResult, int maxResult) {
		Map<String,Object> parameters = new HashMap<String, Object>();
		StringBuilder ql = new StringBuilder();
		ql.append("From Car c WHERE 1=1 ");
		
		String s = null;
		s = data.get("carmake_id");
		if (s != null) {
			ql.append("AND c.carmake.id =:carmake_id ");
			parameters.put("carmake_id", Long.parseLong(data.get("carmake_id")));
		}
		s = data.get("year_from");
		if (s != null) {
			ql.append("AND c.year >=:year_from ");
			parameters.put("year_from", Integer.parseInt(data.get("year_from")));
		}
		s = data.get("year_to");
		if (s != null) {
			ql.append("AND c.year <=:year_to ");
			parameters.put("year_to", Integer.parseInt(data.get("year_to")));
		}
		s = data.get("gearbox");
		if (s != null) {
			ql.append("AND c.gearbox =:gearbox ");
			parameters.put("gearbox", data.get("gearbox"));
		}
		s = data.get("carmodel_id");
		if (s != null) {
			ql.append("AND c.carmodel.id =:carmodel_id ");
			parameters.put("carmodel_id", Long.parseLong(data.get("carmodel_id")));
		}
		s = data.get("ganbajebuli");
		if (s != null) {
			ql.append("AND c.ganbajebuli =:ganbajebuli ");
			parameters.put("ganbajebuli", data.get("ganbajebuli").equals("0") ? false : true);
		}
		s = data.get("price_from");
		if (s != null) {
			ql.append("AND c.price >=:price_from ");
			parameters.put("price_from", Integer.parseInt(data.get("price_from")));
		}
		s = data.get("price_to");
		if (s != null) {
			ql.append("AND c.price <=:price_to ");
			parameters.put("price_to", Integer.parseInt(data.get("price_to")));
		}
		s = data.get("rightsteeringwheel");
		if (s != null) {
			ql.append("AND c.rightsteeringwheel =:rightsteeringwheel ");
			parameters.put("rightsteeringwheel", data.get("rightsteeringwheel").equals("0") ? false : true);
		}
		s = data.get("fuel");
		if (s != null) {
			ql.append("AND c.fuel =:fuel ");
			parameters.put("fuel", data.get("fuel"));
		}
		s = data.get("category_id");
		if (s != null) {
			ql.append("AND c.category.id =:category_id ");
			parameters.put("category_id", Long.parseLong(data.get("category_id")));
		}
		s = data.get("location_id");
		if (s != null) {
			ql.append("AND c.location.id =:location_id ");
			parameters.put("location_id", Long.parseLong(data.get("location_id")));
		}
		EntityManager entitymanager = PersistenceProvider.createEM();
		Query qr = entitymanager.createQuery(ql.toString());
		qr.setFirstResult(firsResult);
		qr.setMaxResults(maxResult);
		for (Entry<String, Object> entry : parameters.entrySet()) {
			qr.setParameter(entry.getKey(), entry.getValue());
		}
		
		return qr.getResultList();
	}
}
