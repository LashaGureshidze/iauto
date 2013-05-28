package ge.iauto.servlets;

import ge.iauto.data.Car;
import ge.iauto.server.PersistenceService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public SearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public String getYear(HttpServletRequest request) {
		int from = Integer.parseInt(request.getParameter("year_from"));
		int to = Integer.parseInt(request.getParameter("year"));
		String res = "";
		if (from != 0) res += " year >= '" + from + "' and";
		if (to != 1) res += " year <= '" + to + "' and";
		return res;
	}
	
	public String getPrice(HttpServletRequest request) {
		String from = (String)request.getParameter("price_from");
		String to = (String)request.getParameter("price_to");
		String res = "";
		if (!from.equals("დან") && from.length() > 0 && from.charAt(0) != '0')
			res += " price >= '" + from + "' and";
		if (!to.equals("მდე") && to.length() > 0 && to.charAt(0) != '0')
			res += " price <= '" + to + "' and";
		return res;
	}
	
	public String getRequestParameter(HttpServletRequest request, String parameter) {
		int selected = Integer.parseInt(request.getParameter(parameter));
		if (selected <= 0) return "";
		return " " + parameter + "='" + selected + "' and";
	}
	
	public String getUploadDate(HttpServletRequest request) {
		return "";
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String queryString = "FROM Car WHERE";
		queryString += getRequestParameter(request, "carmake_id");
		queryString += getRequestParameter(request, "carmodel_id");
		queryString += getRequestParameter(request, "category_id");
		queryString += getYear(request);
		queryString += getPrice(request);
		queryString += getRequestParameter(request, "location_id");
		queryString += getRequestParameter(request, "gearbox");
		queryString += getRequestParameter(request, "fuel");
		queryString += getUploadDate(request);
		queryString += getRequestParameter(request, "ganbajebuli");
		queryString += getRequestParameter(request, "rightsteeringwheel");
		
		int n = queryString.length();
		if (queryString.substring(n - 5).equals("WHERE")) queryString = queryString.substring(0, n - 6);
		else if (queryString.substring(n - 3).equals("and")) queryString = queryString.substring(0, n - 4);
		
		PersistenceService service = new PersistenceService();
		List<Car> carList = service.getCars(queryString);
		request.setAttribute("carList", carList);
		System.out.println(queryString);
		request.getRequestDispatcher("show-search.jsp").forward(request, response);
	}

}
