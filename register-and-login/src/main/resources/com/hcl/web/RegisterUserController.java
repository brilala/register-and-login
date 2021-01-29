package com.hcl.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.web.dao.UserDao;
import com.hcl.web.model.User;

public class RegisterUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
       
	@Override
	public void init() {
		userDao = new UserDao();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		register(request, response);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("register.jsp");
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setUsername(username);
		user.setPassword(password);

		userDao.saveUser(user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
		dispatcher.forward(request, response);
	}
}
