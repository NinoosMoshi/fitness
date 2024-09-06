package com.ninos.controller;

import com.ninos.dto.WorkoutDTO;
import com.ninos.services.workout.WorkoutService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class WorkoutController {


    private final WorkoutService workoutService;

    @PostMapping("/workout")
    public ResponseEntity<?> postWorkout(@RequestBody WorkoutDTO workoutDTO){
        WorkoutDTO createWorkout = workoutService.postWorkout(workoutDTO);

        if(createWorkout != null){
            return new ResponseEntity<>(createWorkout, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("There is something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/workouts")
    public ResponseEntity<?> getAllWorkouts(){
        try {
            return ResponseEntity.ok(workoutService.getWorkouts());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is something went wrong");
        }
    }


}
