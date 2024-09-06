package com.ninos.services.workout;

import com.ninos.dto.WorkoutDTO;

import java.util.List;

public interface WorkoutService {

    WorkoutDTO postWorkout(WorkoutDTO workoutDTO);
    List<WorkoutDTO> getWorkouts();

}
