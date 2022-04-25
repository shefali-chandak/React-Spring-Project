package com.jwt.repository;

import com.jwt.model.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AverageRepository extends JpaRepository<Ratings,Integer> {
    @Query("select avg(ambiance) from Ratings")
    Double avgAmbiance();

    @Query("select avg(cleanliness) from Ratings")
    Double avgCleanliness();

    @Query("select avg(drinks) from Ratings")
    Double avgDrinks();

    @Query("select avg(food) from Ratings")
    Double avgFood();

    @Query("select avg(service) from Ratings")
    Double avgService();
}
