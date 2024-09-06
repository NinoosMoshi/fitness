package com.ninos.services.activity;

import com.ninos.dto.ActivityDTO;

import java.util.List;

public interface ActivityService {

   ActivityDTO postActivity(ActivityDTO activityDTO);
   List<ActivityDTO> getActivities();



}
