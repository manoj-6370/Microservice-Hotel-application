package com.icwd.hotel.services;

import com.icwd.hotel.entities.Hotel;

import java.util.List;

public interface HotelServicce {

    Hotel create(Hotel hotel);

    List<Hotel> getall();

    Hotel get(String Id);

    void deleteById(String Id);

}
