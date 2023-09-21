package com.icwd.hotel.impl;

import com.icwd.hotel.entities.Hotel;
import com.icwd.hotel.exception.ResourceNotFoundException;
import com.icwd.hotel.repositories.HotelRepository;
import com.icwd.hotel.services.HotelServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class Hotelserviceimpl implements HotelServicce {
@Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
       String hotelId= UUID.randomUUID().toString();
       hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getall() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel withb given Id not found !! :"+id));
    }

    @Override
    public void deleteById(String id) {
        hotelRepository.deleteById(id);

    }

}
