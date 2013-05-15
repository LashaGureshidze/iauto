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

/**
 * Servlet implementation class Verification
 */
@WebServlet("/Verification")
public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verification() {
        super();
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
	protected void doPost(final HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errorList  = new ArrayList<String>();
		
		PersistenceService service = new PersistenceService();
		if(service.existsUserName(request.getParameter("username"))){
			errorList.add("ასეთი მომხმარებელი უკვე არსებობს");
		}
		if(!request.getParameter("password").equals(request.getParameter("rpassword"))){
			errorList.add("შეიყვანეთ სწორი პაროლი");
		}
		
		if(!errorList.isEmpty()){
			request.setAttribute("errorList", errorList);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}else{
			final String code = "" + new Random().nextInt();
		//	Thread sendMessage = new Thread(new Runnable() {
		//		@Override
			//	public void run() {
					MessageSendService.sendMessage(request.getParameter("email"), code);
		//		}
		//	});
		//	sendMessage.setPriority(Thread.MIN_PRIORITY);
		//	sendMessage.start();
			
			request.setAttribute("code", code);
			request.getRequestDispatcher("verification.jsp").forward(request, response);
			
		}
	}

}
