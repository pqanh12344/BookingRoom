package com.mycompany.bookingroom.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.bookingroom.model.Amenities_Rooms;
import com.mycompany.bookingroom.service.IAmenities_RoomsService;
import com.mycompany.bookingroom.service.implement.Amenities_RoomsService;
import com.mycompany.bookingroom.util.CheckUtil;
import com.mycompany.bookingroom.util.JsonUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AdminAmenitiesRoom", urlPatterns = {"/api-admin-amenities-room"})
public class AmenitiesRoomAPI extends HttpServlet {
    
	/*
	 * @Inject private IAmenities_RoomsService amenitiesRoomsService;
	 */

	IAmenities_RoomsService amenitiesRoomsService = new Amenities_RoomsService();
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String roomId = request.getParameter("roomId");
        try(PrintWriter out = response.getWriter()){
            ObjectMapper mapper = new ObjectMapper();
            if(CheckUtil.isInteger(roomId)){
                List<Amenities_Rooms> amenities_Rooms  = (List<Amenities_Rooms>) amenitiesRoomsService
                                                        .findByRoomId(Integer.parseInt(roomId));
                mapper.writeValue(out, amenities_Rooms);
            }
        
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
        Amenities_Rooms amenities_Rooms = JsonUtil.toJsonUtil(reader).toModel(Amenities_Rooms.class);
        amenitiesRoomsService.save(amenities_Rooms);
        mapper.writeValue(response.getOutputStream(), amenities_Rooms);
        
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        BufferedReader reader = request.getReader();
        ObjectMapper mapper = new ObjectMapper();
        Amenities_Rooms amenities_Rooms = JsonUtil.toJsonUtil(reader).toModel(Amenities_Rooms.class);
        amenitiesRoomsService.update(amenities_Rooms);
        mapper.writeValue(response.getOutputStream(), amenities_Rooms);
        
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        BufferedReader reader =  request.getReader();
        ObjectMapper mapper = new ObjectMapper();
        Amenities_Rooms amenities_Rooms = JsonUtil.toJsonUtil(reader).toModel(Amenities_Rooms.class);
        amenitiesRoomsService.delete(amenities_Rooms);
        mapper.writeValue(response.getOutputStream(), "{}");
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
