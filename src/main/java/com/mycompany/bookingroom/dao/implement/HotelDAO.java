package com.mycompany.bookingroom.dao.implement;

import com.mycompany.bookingroom.dao.IHotelDAO;
import com.mycompany.bookingroom.mapper.HotelMapper;
import com.mycompany.bookingroom.model.Hotel;
import java.util.List;

public class HotelDAO extends AbstractDAO<Hotel> implements IHotelDAO{
        
    @Override
    public List<Hotel> findAll() {        
        String sql = "SELECT * FROM Hotels";
        return query(sql, new HotelMapper());
    }

    @Override
    public List<Hotel> findAllByLocation(String location) {
        location = "%" + location + "%";
        String sql = "SELECT * FROM Hotels WHERE address like ?";
        return query(sql, new HotelMapper(), location);
    }
    @Override
    public Hotel findById(Integer id) {         
        String sql = "SELECT * FROM Hotels WHERE id = ?";        
        List<Hotel> hotels = query(sql, new HotelMapper(), id);
        return hotels.size() > 0 ? hotels.get(0) : null;
    }    

    @Override
    public Integer save(Hotel hotel) {        
        String sql = "INSERT Hotels(NAME,ADDRESS,DESCRIPTION,STAR)VALUES(?, ?, ?, ?)";            
        return insert(sql, hotel.getName(), hotel.getAddress(),hotel.getDescription(), hotel.getStar());
    }

    @Override
    public void update(Hotel hotel) {
        String sql = "UPDATE Hotels SET Name = ? , Address = ?, Description = ?, Star = ? "
                + " WHERE id = ?";        
        update(sql, hotel.getName(), hotel.getAddress(), hotel.getDescription(), hotel.getStar(), hotel.getId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Hotels WHERE id = ?";
        update(sql, id);
    }

    
    
}
