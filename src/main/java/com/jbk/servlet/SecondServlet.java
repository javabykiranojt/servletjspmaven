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
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String surname = request.getParameter("surname");
		// get data
		System.out.println(surname);

		HttpSession httpSession = request.getSession(false);
		if (httpSession == null) {
			RequestDispatcher rd = request.getRequestDispatcher("first.jsp");
			rd.forward(request, response);
		} else {
			System.out.println(httpSession.getId());
			RequestDispatcher rd = request.getRequestDispatcher("three.jsp");
			rd.forward(request, response);
		}
	}

}
