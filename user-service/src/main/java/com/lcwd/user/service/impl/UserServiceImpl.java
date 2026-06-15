package com.lcwd.user.service.impl;

import com.lcwd.user.entity.Hotel;
import com.lcwd.user.entity.Rating;
import com.lcwd.user.entity.User;
import com.lcwd.user.external.services.HotelService;
import com.lcwd.user.external.services.RatingService;
import com.lcwd.user.repository.UserRepository;
import com.lcwd.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private HotelService hotelService;

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @CircuitBreaker(
            name = "ratingHotelBreaker",
            fallbackMethod = "ratingHotelFallback"
    )
    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        List<Rating> ratings = ratingService.getRatingsByUserId(userId);

        ratings.forEach(rating -> {
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
        });

        user.setRatings(ratings);

        return user;
    }
    public User ratingHotelFallback(String userId, Exception ex) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        user.setRatings(new ArrayList<>());

        return user;
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}