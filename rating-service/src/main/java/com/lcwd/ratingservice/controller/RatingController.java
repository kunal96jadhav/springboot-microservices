package com.lcwd.ratingservice.controller;

import com.lcwd.ratingservice.entity.Rating;
import com.lcwd.ratingservice.service.RatingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<Rating> createRating(@Valid @RequestBody Rating rating) {
        Rating createdRating = ratingService.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRatingById(@PathVariable String ratingId) {
        Rating rating = ratingService.getRatingById(ratingId);
        return ResponseEntity.ok(rating);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
        List<Rating> ratings = ratingService.getRatingsByUserId(userId);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
        List<Rating> ratings = ratingService.getRatingsByHotelId(hotelId);
        return ResponseEntity.ok(ratings);
    }

    @PutMapping("/{ratingId}")
    public ResponseEntity<Rating> updateRating(
            @PathVariable String ratingId,
            @Valid @RequestBody Rating rating) {

        Rating updatedRating = ratingService.updateRating(ratingId, rating);
        return ResponseEntity.ok(updatedRating);
    }

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<Map<String, Object>> deleteRating(@PathVariable String ratingId) {

        ratingService.deleteRating(ratingId);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Rating deleted successfully");
        response.put("success", true);
        response.put("status", HttpStatus.OK.value());

        return ResponseEntity.ok(response);
    }
}