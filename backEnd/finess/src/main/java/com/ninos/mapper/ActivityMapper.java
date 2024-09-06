package com.ninos.mapper;

import com.ninos.dto.ActivityDTO;
import com.ninos.entity.Activity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ActivityMapper {

    public ActivityDTO activityEntityToDto(Activity activity){
        ActivityDTO activityDTO = new ActivityDTO();
        BeanUtils.copyProperties(activity, activityDTO);
        return activityDTO;
    }

    public Activity activityDtoToEntity(ActivityDTO activityDTO){
        Activity activity = new Activity();
        BeanUtils.copyProperties(activityDTO, activity);
        return activity;
    }




}
