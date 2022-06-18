package com.mycompany.bookingroom.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.bookingroom.model.Phone;
import com.mycompany.bookingroom.model.Type;
import com.mycompany.bookingroom.service.IPhoneService;
import com.mycompany.bookingroom.service.IPhoneService;
import com.mycompany.bookingroom.service.implement.PhoneService;
import com.mycompany.bookingroom.service.implement.PhoneService;
import com.mycompany.bookingroom.util.CheckUtil;
import com.mycompany.bookingroom.util.JsonUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AdminPhone", urlPatterns = {"/api-admin-phone"})
public class PhoneAPI extends HttpServlet {
    
	IPhoneService phoneService = new PhoneService();
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        try(OutputStream out = response.getOutputStream()){         
            List<Phone> phones  = (List<Phone>) request.getAttribute("phones");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(out, phones);
      }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        BufferedReader reader = request.getReader();
        ObjectMapper mapper = new ObjectMapper();
        Phone Phone = JsonUtil.toJsonUtil(reader).toModel(Phone.class);
        phoneService.save(Phone);
        mapper.writeValue(response.getOutputStream(), Phone);
        
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        BufferedReader reader = request.getReader();
        ObjectMapper mapper = new ObjectMapper();
        Phone Phone = JsonUtil.toJsonUtil(reader).toModel(Phone.class);
        phoneService.update(Phone);
        mapper.writeValue(response.getOutputStream(), Phone);
        
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        BufferedReader reader =  request.getReader();
        ObjectMapper mapper = new ObjectMapper();
        Phone Phone = JsonUtil.toJsonUtil(reader).toModel(Phone.class);
        phoneService.delete(Phone);
        mapper.writeValue(response.getOutputStream(), "{}");
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
