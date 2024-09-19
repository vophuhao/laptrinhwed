package vn.iostart.controller;

import java.io.IOException;
import java.rmi.ServerException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostart.service.IUserservice;
import vn.iostart.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/home", "/login", "/register", "/forgotpass", "/waiting", "/VerifyCode" })
public class homeController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IUserservice userService=new UserServiceImpl();
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServerException,IOException{
		
	}
}
