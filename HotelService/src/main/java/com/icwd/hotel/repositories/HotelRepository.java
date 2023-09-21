package com.icwd.hotel.repositories;

import com.icwd.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HotelRepository extends JpaRepository<Hotel,String> {

}
