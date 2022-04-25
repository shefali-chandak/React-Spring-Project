package com.jwt.controller;

import com.jwt.model.Ratings;
import com.jwt.model.User;
import com.jwt.payload.ApiResponse;
import com.jwt.payload.LoginRequest;
import com.jwt.payload.RatingRequest;
import com.jwt.repository.RatingRepository;
import com.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserRepository userRepository;

    //insert=>PostMapping
    @PostMapping("/ratings")
    public ResponseEntity<Ratings> create(@Valid @RequestBody RatingRequest ratingRequest){
        Ratings ratings = new Ratings();
        ratings.setAmbiance(Integer.parseInt(ratingRequest.getAmbiance()));
        ratings.setFood(Integer.parseInt(ratingRequest.getFood()));
        ratings.setService(Integer.parseInt(ratingRequest.getService()));
        ratings.setDrinks(Integer.parseInt(ratingRequest.getDrinks()));
        ratings.setCleanliness(Integer.parseInt(ratingRequest.getCleanliness()));

        //get the email of current user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User not found with email : " + email));
        ratings.setUser(user);

        ratingRepository.save(ratings);
        return new ResponseEntity(new ApiResponse("Rating added successfully",null ), HttpStatus.CREATED);


    }
}
