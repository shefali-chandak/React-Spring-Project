package com.jwt.repository;

import com.jwt.model.Ratings;
import com.jwt.payload.AverageResponse;
import com.jwt.payload.FilterResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AverageRepository extends JpaRepository<Ratings,Integer> {

    @Query("select new com.jwt.payload.AverageResponse(avg(ambiance),avg(cleanliness),avg(drinks),avg(service),avg(food)," +
            "((avg(ambiance)+avg(cleanliness)+avg(drinks)+avg(food)+avg(service))/5)) from Ratings")
    AverageResponse averages();

}
