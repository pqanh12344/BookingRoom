package com.mycompany.bookingroom.model;

public class Phone {
	private Integer hotel_id;
	private String phone;
	
	public Phone() {

	}

	public Phone(Integer hotel_id, String phone) {
		this.hotel_id = hotel_id;
		this.phone = phone;
	}

	public Integer getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(Integer hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
