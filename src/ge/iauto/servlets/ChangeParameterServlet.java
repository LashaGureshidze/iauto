package ge.iauto.servlets;

import ge.iauto.data.User;
import ge.iauto.server.PersistenceService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeParameterServlet
 */
@WebServlet("/ChangeParameterServlet")
public class ChangeParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeParameterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errorList  = new ArrayList<String>();
		errorList.add(null); errorList.add(null);
		boolean added = false;
		
		PersistenceService service = new PersistenceService();
		if (!request.getParameter("newUsername").isEmpty() &&
				service.existsUserName(request.getParameter("newUsername"))) {
			added = true;
			errorList.set(0,"ასეთი მომხმარებელი უკვე არსებობს!");
		}
		if (!request.getParameter("newEmail").isEmpty() &&
				service.existsEmail(request.getParameter("newEmail"))){
			added = true;
			errorList.set(1,"ეს ელ-ფოსტა უკვე დაკავებულია!");
		}
		request.setAttribute("errorList", errorList);
		if (added) request.getRequestDispatcher("profile-parameters.jsp").forward(request, response);
		else {
			User curr = (User)request.getSession().getAttribute("user");
			String oldUsername = (String)request.getParameter("oldUsername");
			if (!request.getParameter("newEmail").isEmpty()) {
				service.changeEmail(oldUsername, request.getParameter("newEmail"));
				curr.setEmail(request.getParameter("newEmail"));
			}
			if (!request.getParameter("password").isEmpty()) {
				service.changePassword(oldUsername, request.getParameter("password"));
				curr.setPassword(request.getParameter("password"));
			}
			if (!request.getParameter("newUsername").isEmpty()) {
				service.changeUsername(oldUsername, request.getParameter("newUsername"));
				curr.setUsername(request.getParameter("newUsername"));
			}
			request.getRequestDispatcher("change-successful.jsp").forward(request, response);
		}
	}

}
