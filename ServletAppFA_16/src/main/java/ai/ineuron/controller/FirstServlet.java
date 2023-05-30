package ai.ineuron.controller;

// Problem/Solution::16

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String userName = request.getParameter("user");
		
		//create a session object
		HttpSession session = request.getSession();
		//store the user's name in session object
		session.setAttribute("user",userName);//void javax.servlet.http.HttpSession.setAttribute(String name, Object value)
		//Redirect the user name to Second Servlet
		response.sendRedirect("SecondServlet");
		
	}

}
