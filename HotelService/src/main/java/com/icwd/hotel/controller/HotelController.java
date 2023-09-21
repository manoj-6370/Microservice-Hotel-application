package com.icwd.hotel.controller;

import com.icwd.hotel.entities.Hotel;
import com.icwd.hotel.services.HotelServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotel")
public class HotelController {
    @Autowired
    private HotelServicce hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        return ResponseEntity.ok(hotelService.getall());
    }

    public ResponseEntity<Hotel> deleteHotel(@PathVariable String hotelid){
        ResponseEntity<Hotel> entity=getSingleHotel(hotelid) ;
       hotelService.deleteById(hotelid);
       return entity;
    }

}
