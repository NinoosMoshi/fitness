package com.ninos.repository;

import com.ninos.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkoutRepository extends JpaRepository<Workout,Long> {

    @Query("SELECT SUM(w.duration) FROM Workout w")
    Integer getTotalDuration();

    @Query("SELECT SUM(w.caloriesBurned) FROM Workout w")
    Integer getTotalCaloriesBurned();
}
