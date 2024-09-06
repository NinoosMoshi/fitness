package com.ninos.controller;

import com.ninos.dto.GoalDTO;
import com.ninos.services.goal.GoalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class GoalController {

    private final GoalService goalService;


    @PostMapping("/goal")
    public ResponseEntity<?> postGoal(@RequestBody GoalDTO goalDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(goalService.postGoal(goalDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is something went wrong");
        }
    }

    @GetMapping("/goals")
    public ResponseEntity<?> getGoals(){
        try {
            return ResponseEntity.ok(goalService.getAllGoals());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is something went wrong");
        }
    }

    @GetMapping("/goal/status/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id){
        try {
            return ResponseEntity.ok(goalService.updateStatus(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }




}
