package ge.iauto.servlets;

import ge.iauto.data.Car;
import ge.iauto.data.User;
import ge.iauto.server.PersistenceService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddingCars
 */
@WebServlet("/AddCar")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null){
			request.getRequestDispatcher("log-in.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("add-car.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user") == null){
			request.getRequestDispatcher("log-in.jsp").forward(request, response);
		}else{
			
			System.out.println("მანქანის მარკა    " + request.getParameter("man_id"));
			
			PersistenceService service = new PersistenceService();
			Car car = new Car();
			car.setUser((User)request.getSession().getAttribute("user"));
			car.setCategory(service.findCategory(Long.valueOf(request.getParameter("category_id"))));
		//	car.setCarmake(service.findCarMake(Long.valueOf(request.getParameter("man_id"))));
		//	car.setCarmodel(service.findCarModel(Long.valueOf(request.getParameter("model"))));
			car.setLocation(service.findLocation(Long.valueOf(request.getParameter("location_id"))));
			car.setYear(Integer.valueOf(request.getParameter("prod_year")));
			car.setMonth(Integer.valueOf(request.getParameter("prod_month")));
			car.setKilometer(request.getParameter("car_run") + " " + request.getParameter("car_run_dim"));
			car.setDoors(request.getParameter("door_type_id"));
			car.setAirbag(request.getParameter("airbags"));
			car.setColor(request.getParameter("color_id"));
			car.setGearbox(request.getParameter("gear_type_id"));
			car.setUsername(request.getParameter("client_nm"));
			car.setAbs(request.getParameter("abs") != null);
			car.setWindow(request.getParameter("el_windows") != null);
			car.setClimat(request.getParameter("climat_control") != null);
			car.setWheel(request.getParameter("disks") != null);
			car.setTopwindow(request.getParameter("hatch") != null);
			car.setComputer(request.getParameter("board_comp") != null);
			car.setSequrity(request.getParameter("alarm") != null);
			car.setPrice(Integer.valueOf(request.getParameter("price")));
			car.setCurrency(request.getParameter("currency_id"));
			car.setGanbajebuli(request.getParameter("customs_passed") != null);
			car.setChangable(request.getParameter("changable") != null);
			car.setSaleonauction(request.getParameter("is_auction") != null);
			car.setEngine(Double.valueOf(request.getParameter("engine_volume")));
			car.setCylinder(request.getParameter("cylinders"));
			car.setActionwheel(request.getParameter("drive_type_id"));
			car.setFuel(request.getParameter("fuel_type_id"));
			car.setRightsteeringwheel(request.getParameter("right_wheel") != null);
			car.setTurbo(request.getParameter("has_turbo") != null);
			car.setTelephone(request.getParameter("client_phone_1"));
			car.setParkcontrol(request.getParameter("obstacle_indicator") != null);
			car.setConditioner(request.getParameter("condintioner") != null);
			car.setLeather(request.getParameter("leather") != null);
			car.setNavigation(request.getParameter("nav_system") != null);
			car.setCentrallock(request.getParameter("central_lock") != null);
			car.setSavardzlisgatboba(request.getParameter("chair_warming") != null);
			car.setHydraulics(request.getParameter("hydraulics") != null);
			car.setDescribtion(request.getParameter("discription"));
			
			service.saveCar(car);
		}	
	}

}
