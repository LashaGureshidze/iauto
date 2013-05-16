package ge.iauto.servlets;

import ge.iauto.server.PersistenceService;
import ge.iauto.services.MessageSendService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Verification
 */
@WebServlet("/Verification")
public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(final HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errorList  = new ArrayList<String>();
		
		PersistenceService service = new PersistenceService();
		if(service.existsUserName(request.getParameter("username"))){
			errorList.add("ასეთი მომხმარებელი უკვე არსებობს");
		}
		if(!request.getParameter("password").equals(request.getParameter("rpassword"))){
			errorList.add("შეიყვანეთ სწორი პაროლი");
		}
		if(request.getParameter("email").isEmpty()){
			errorList.add("შეიყვანეთ სწორი ელ-ფოსტა");
		}
		if(!errorList.isEmpty()){
			request.setAttribute("errorList", errorList);
			request.getRequestDispatcher("user-register.jsp").forward(request, response);
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("username", request.getParameter("username"));
			session.setAttribute("password", request.getParameter("password"));
			session.setAttribute("name", request.getParameter("name"));
			session.setAttribute("lastname", request.getParameter("lastname"));
			session.setAttribute("email", request.getParameter("email"));
			session.setAttribute("birthday", request.getParameter("birthday"));
			session.setAttribute("sex", request.getParameter("sex"));
			
			final String code = "" + new Random().nextInt(10000);
			Thread sendMessage = new Thread(new Runnable() {
				@Override
				public void run() {
					MessageSendService.sendMessage(request.getParameter("email"), code);
				}
			});
			sendMessage.setPriority(Thread.MIN_PRIORITY);
			sendMessage.start();
			
			request.getSession().setAttribute("code", code);
			request.getRequestDispatcher("verification.jsp").forward(request, response);
		}
	}

}
