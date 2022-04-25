package com.jwt.repository;

import com.jwt.model.Ratings;
import com.jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Ratings,Integer> {
}
