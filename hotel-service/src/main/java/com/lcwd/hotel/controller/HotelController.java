package com.lcwd.hotel.controller;

import com.lcwd.hotel.entity.Hotel;
import com.lcwd.hotel.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@Valid @RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.create(hotel);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdHotel);
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotels = hotelService.getAll();
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id) {
        Hotel hotel = hotelService.get(id);
        return ResponseEntity.ok(hotel);
    }
    @PutMapping("/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(
            @PathVariable String hotelId,
            @Valid @RequestBody Hotel hotel) {

        Hotel updatedHotel = hotelService.updateHotel(hotelId, hotel);

        return ResponseEntity.ok(updatedHotel);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Map<String, Object>> deleteHotel(@PathVariable String hotelId) {
        hotelService.deleteHotel(hotelId);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Hotel deleted successfully");
        response.put("success", true);
        response.put("status", 200);

        return ResponseEntity.ok(response);
    }
}