package com.ninos.services.activity;

import com.ninos.dto.ActivityDTO;
import com.ninos.entity.Activity;
import com.ninos.mapper.ActivityMapper;
import com.ninos.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ActivityServiceImpl implements ActivityService{

    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;


    @Override
    public ActivityDTO postActivity(ActivityDTO activityDTO) {
        Activity activity = activityMapper.activityDtoToEntity(activityDTO);
        Activity savedActivity = activityRepository.save(activity);

        return activityMapper.activityEntityToDto(savedActivity);
    }

    @Override
    public List<ActivityDTO> getActivities() {
        List<Activity> activities = activityRepository.findAll();
        return activities.stream().map(activity -> activityMapper.activityEntityToDto(activity))
                .collect(Collectors.toList());
    }


}
