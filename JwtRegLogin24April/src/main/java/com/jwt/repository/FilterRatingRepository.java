package com.jwt.repository;

import com.jwt.model.Ratings;
import com.jwt.payload.FilterResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilterRatingRepository extends JpaRepository<Ratings,Integer> {
    @Query("select " +
            "new com.jwt.payload.FilterResponse(u.name, r.ambiance, r.cleanliness, r.drinks, r.food,r.service) " +
            "from User u inner join Ratings r on u.id=r.user.id and" +
            " r.ambiance > :ambiance and r.cleanliness > :cleanliness and " +
            "r.drinks > :drinks and r.food > :food and r.service > :service")
    List<FilterResponse> filterRatings(@Param("ambiance") int ambiance,
                                       @Param("food") int food,
                                       @Param("service") int service,
                                       @Param("drinks") int drinks,
                                       @Param("cleanliness") int cleanliness);
}
