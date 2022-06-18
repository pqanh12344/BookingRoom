package com.mycompany.bookingroom.dao.implement;

import com.mycompany.bookingroom.dao.IPhoneDAO;
import com.mycompany.bookingroom.mapper.PhoneMapper;
import com.mycompany.bookingroom.model.Phone;
import java.util.List;


public class PhoneDAO extends AbstractDAO<Phone> implements IPhoneDAO{

    @Override
    public List<Phone> findAll() {
        String sql = "SELECT * FROM Phones";
        return query(sql, new PhoneMapper());
    }

    @Override
    public Integer save(Phone ar) {
        String sql = "INSERT Phones(HOTEL_ID, PHONE)VALUES(?, ?)";
        return insert(sql,ar.getHotel_id(), ar.getPhone());
    }

    @Override
    public void update(Phone ar) {
        String sql = "UPDATE Phones SET HOTEL_ID =?, PHONE=?";
        update(sql, ar.getHotel_id(), ar.getPhone());
    }
    
    
    @Override
    public void delete(Phone ar) {
        String sql = "DELETE FROM Phones WHERE HOTEL_ID = ? AND PHONE = ?";
        update(sql, ar.getHotel_id(), ar.getPhone());
    }

}
