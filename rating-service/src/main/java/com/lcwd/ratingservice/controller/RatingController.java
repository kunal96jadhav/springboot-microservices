package com.lcwd.ratingservice.controller;

import com.lcwd.ratingservice.entity.Rating;
import com.lcwd.ratingservice.service.RatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public Rating createRating(@RequestBody Rating rating) {
        return ratingService.createRating(rating);
    }

    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @GetMapping("/users/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable String userId) {
        return ratingService.getRatingsByUserId(userId);
    }

    @GetMapping("/hotels/{hotelId}")
    public List<Rating> getRatingsByHotelId(@PathVariable String hotelId) {
        return ratingService.getRatingsByHotelId(hotelId);
    }
}