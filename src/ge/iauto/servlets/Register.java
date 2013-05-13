package ge.iauto.servlets;

import ge.iauto.model.User;
import ge.iauto.server.PersistenceService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User newUser = new User();
		newUser.setUsername(request.getParameter("username"));
		newUser.setPassword(request.getParameter("password"));
		newUser.setName(request.getParameter("name"));
		newUser.setLastName(request.getParameter("lastName"));
		newUser.setEmail(request.getParameter("email"));
		newUser.setSex(request.getParameter("sex").equals("mrs"));
		newUser.setBirthday(request.getParameter("birthday"));
		
		PersistenceService service = new PersistenceService();
		service.addUser(newUser);
		
	}

}
