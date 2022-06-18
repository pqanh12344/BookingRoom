package com.mycompany.bookingroom.mapper;

import com.mycompany.bookingroom.model.Phone;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PhoneMapper implements RowMapper<Phone>{

    @Override
    public Phone mapRow(ResultSet resultSet) {
        try {
            Phone phone = new Phone();
            phone.setHotel_id(resultSet.getInt("HOTEL_ID"));
            phone.setPhone(resultSet.getString("PHONE"));
            return phone;
        } catch (SQLException ex) {
            Logger.getLogger(PhoneMapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
