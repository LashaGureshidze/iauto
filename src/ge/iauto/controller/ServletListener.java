package ge.iauto.controller;

import java.util.HashMap;
import java.util.List;

import ge.iauto.data.CarMake;
import ge.iauto.data.Category;
import ge.iauto.data.Location;
import ge.iauto.server.PersistenceProvider;
import ge.iauto.server.PersistenceService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletListener
 *
 */
@WebListener
public class ServletListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    /*
     * when context is create it puts into it
     * two HashMap . one is id with names and 
     * second is cars with keys their id 
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	PersistenceService service = new PersistenceService();
    	List<CarMake> result = service.getCarMakes();
    	HashMap<String, Long> Ids = new HashMap<String, Long>();
    	HashMap<Long, CarMake> cars = new HashMap<Long, CarMake>();
    	for(CarMake car : result){
    		Ids.put(car.getName(), car.getId());
    		cars.put(car.getId(), car);
    	}
        arg0.getServletContext().setAttribute("idByName", Ids);
        arg0.getServletContext().setAttribute("carById", cars);
    
        //=======================load Locations==========
        List<Location> list = service.getLocations();
        arg0.getServletContext().setAttribute("locations", list);
        
        //======================load Categroies
        List<Category> lis = service.getCategories();
        arg0.getServletContext().setAttribute("categories", lis);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        PersistenceProvider.closeEM();
    }
	
}
