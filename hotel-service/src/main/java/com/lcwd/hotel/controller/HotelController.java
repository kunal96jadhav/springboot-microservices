package com.lcwd.hotel.controller;

import com.lcwd.hotel.entity.Hotel;
import com.lcwd.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.create(hotel);
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAll();
    }

    @GetMapping("/{id}")
    public Hotel getHotel(@PathVariable Long id) {
        return hotelService.get(id);
    }
}