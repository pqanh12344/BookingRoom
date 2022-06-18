package com.mycompany.bookingroom.service.implement;

import java.util.List;

import com.mycompany.bookingroom.dao.IPhoneDAO;
import com.mycompany.bookingroom.dao.implement.PhoneDAO;
import com.mycompany.bookingroom.model.Phone;
import com.mycompany.bookingroom.service.IPhoneService;
import javax.inject.Inject;

public class PhoneService implements IPhoneService {

	IPhoneDAO phoneDAO = new PhoneDAO();

    @Override
    public List<Phone> findAll() {
        return phoneDAO.findAll();
    }

    @Override
    public Integer save(Phone phone) {
        return phoneDAO.save(phone);
    }

    @Override
    public void update(Phone Phone) {
        phoneDAO.update(Phone);
    }

    @Override
    public void delete(Phone ar) {
        phoneDAO.delete(ar);
    }

}
