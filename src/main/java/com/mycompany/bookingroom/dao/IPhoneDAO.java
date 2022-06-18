
package com.mycompany.bookingroom.dao;

import com.mycompany.bookingroom.model.Phone;
import java.util.List;


public interface IPhoneDAO {
    List<Phone> findAll();
    Integer save(Phone ar);
    void update(Phone ar);
    void delete(Phone ar);
}
