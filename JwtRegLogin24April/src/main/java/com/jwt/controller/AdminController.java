package com.jwt.controller;

import com.jwt.payload.ApiResponse;
import com.jwt.payload.AverageResponse;
import com.jwt.payload.FilterResponse;
import com.jwt.payload.ErrorResponse;
import com.jwt.repository.AverageRepository;
import com.jwt.repository.FilterRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    FilterRatingRepository filterRatingRepository;

    @GetMapping("/filterRatings")
    public ResponseEntity<?> filterRatings(@RequestParam(name = "ambiance", defaultValue = "0") String ambiance,
                                           @RequestParam(name = "food", defaultValue = "0") String food,
                                           @RequestParam(name = "service", defaultValue = "0") String service,
                                           @RequestParam(name = "drinks", defaultValue = "0") String drinks,
                                           @RequestParam(name = "cleanliness", defaultValue = "0") String cleanliness) {

        List<FilterResponse> filter = filterRatingRepository.filterRatings(Integer.parseInt(ambiance),
                Integer.parseInt(food),
                Integer.parseInt(service),
                Integer.parseInt(drinks),
                Integer.parseInt(cleanliness));

        return ResponseEntity.ok(new ApiResponse(filter,new ErrorResponse("null")));
    }

    @Autowired
    AverageRepository averageRepository;

    @GetMapping("/averageRatings")
    public ResponseEntity<?> avgOfRatings() {

        AverageResponse totalAverage  = averageRepository.averages();

        return ResponseEntity.ok(new ApiResponse(totalAverage,null));
    }


}
