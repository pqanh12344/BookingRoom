package com.mycompany.bookingroom.service;

import java.util.List;

import com.mycompany.bookingroom.model.Phone;

public interface IPhoneService {
    List<Phone> findAll();
    Integer save(Phone phone);
    void update(Phone Phone);
    void delete(Phone ar);
}
