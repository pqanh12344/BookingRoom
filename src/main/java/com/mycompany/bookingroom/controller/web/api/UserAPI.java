package com.mycompany.bookingroom.controller.web.api;

import com.mycompany.bookingroom.controller.admin.api.*;
import com.mycompany.bookingroom.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Request;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.bookingroom.service.IUserService;
import com.mycompany.bookingroom.service.implement.UserService;

import javax.inject.Inject;

@WebServlet(name = "UserAPI", urlPatterns = {"/api-user"})
public class UserAPI extends HttpServlet {

	/*
	 * @Inject private IUserService userService;
	 */
	
	IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("user", userService.login(username, password));
        try (OutputStream out = response.getOutputStream()) {
            User user = (User) request.getAttribute("user");
            if(user != null) {
            	Cookie cookie3 = new Cookie("user_id", user.getId()+"");							
    			cookie3.setMaxAge(24 * 60 * 60 *30 *12);  
    			response.addCookie(cookie3);
            }else {
    			request.setAttribute("item", "Tên đăng nhập hoặc mật khẩu chưa chính xác!");
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(out, user);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
