package com.hcl.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.web.dao.UserDao;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao loginDao;

	@Override
	public void init() {
		loginDao = new UserDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			authenticate(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (loginDao.validate(username, password)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
			dispatcher.forward(request, response);
		} else {
			throw new Exception("Login invalid");
		}
	}

}
