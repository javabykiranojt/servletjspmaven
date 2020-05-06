package com.jbk.servlet;

import java.io.IOException;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		// get data
		System.out.println(uname);
		// request is state less
		// means it can only goes to next page not next of next page
		// next page means second.jsp // not to third.jsp
		HttpSession httpSession = request.getSession();// true // false
		httpSession.setMaxInactiveInterval(100);
		System.out.println(httpSession.getId());
		// System.out.println(httpSession.isNew());
		if (!httpSession.isNew()) {
			httpSession.invalidate();
			httpSession = request.getSession();
		}
		// setting data in request
		request.setAttribute("un", uname);
		// setting data in session
		httpSession.setAttribute("unS", uname);
		// process data
		// navigate
		RequestDispatcher rd = request.getRequestDispatcher("second.jsp");
		rd.forward(request, response);
	}

}
