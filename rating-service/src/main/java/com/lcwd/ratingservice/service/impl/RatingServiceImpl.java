package com.lcwd.ratingservice.service.impl;

import com.lcwd.ratingservice.entity.Rating;
import com.lcwd.ratingservice.repository.RatingRepository;
import com.lcwd.ratingservice.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating createRating(Rating rating) {
        System.out.println("Before save: " + rating);

        Rating savedRating = ratingRepository.save(rating);

        System.out.println("After save: " + savedRating);
        return savedRating;
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public Rating getRatingById(String ratingId) {
        return ratingRepository.findById(ratingId).orElse(null);
    }
}