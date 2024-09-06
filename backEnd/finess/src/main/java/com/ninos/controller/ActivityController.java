package com.ninos.controller;

import com.ninos.dto.ActivityDTO;
import com.ninos.services.activity.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ActivityController {

    private final ActivityService activityService;



    @PostMapping("/activity")
    public ResponseEntity<?> postActivity(@RequestBody ActivityDTO activityDTO){
        ActivityDTO createActivity = activityService.postActivity(activityDTO);

        if(createActivity != null){
            return new ResponseEntity<>(createActivity, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("There is something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/activities")
    public ResponseEntity<?> getAllActivities(){
        List<ActivityDTO> activities = activityService.getActivities();
        try {
            return new ResponseEntity<>(activities, HttpStatus.OK);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is something went wrong");
        }
    }



}
