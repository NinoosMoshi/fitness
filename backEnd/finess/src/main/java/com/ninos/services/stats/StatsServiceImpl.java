package com.ninos.services.stats;

import com.ninos.dto.ActivityDTO;
import com.ninos.dto.GraphDTO;
import com.ninos.dto.StatsDTO;
import com.ninos.dto.WorkoutDTO;
import com.ninos.entity.Activity;
import com.ninos.entity.Workout;
import com.ninos.mapper.ActivityMapper;
import com.ninos.mapper.WorkoutMapper;
import com.ninos.repository.ActivityRepository;
import com.ninos.repository.GoalRepository;
import com.ninos.repository.WorkoutRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StatsServiceImpl implements StatsService{

    private final GoalRepository goalRepository;
    private final ActivityRepository activityRepository;
    private final WorkoutRepository workoutRepository;
    private final WorkoutMapper workoutMapper;
    private final ActivityMapper activityMapper;


    @Override
    public StatsDTO getStats() {
        // Fetch goals count
        Long achievedGoals = goalRepository.countAchievedGoals();
        Long notAchievedGoals = goalRepository.countNotAchievedGoals();

        Integer totalSteps = activityRepository.getTotalSteps();
        Double totalDistance = activityRepository.getTotalDistance();
        Integer totalActivityCaloriesBurned = activityRepository.getTotalActivityCalories();

        Integer totalWorkoutDuration = workoutRepository.getTotalDuration();
        Integer totalWorkoutCaloriesBurned = workoutRepository.getTotalCaloriesBurned();

        int totalCaloriesBurned = (totalActivityCaloriesBurned != null ? totalActivityCaloriesBurned : 0) +
                (totalWorkoutCaloriesBurned != null ? totalWorkoutCaloriesBurned : 0);

        StatsDTO dto = new StatsDTO();
        dto.setAchievedGoals(achievedGoals != null ? achievedGoals : 0);
        dto.setNotAchievedGoals(notAchievedGoals != null ? notAchievedGoals : 0);

        dto.setSteps(totalSteps != null ? totalSteps : 0);
        dto.setDistance(totalDistance != null ? totalDistance : 0.0);
        dto.setTotalCaloriesBurned(totalCaloriesBurned);
        dto.setDuration(totalWorkoutDuration != null ? totalWorkoutDuration : 0);

        return dto;
    }

    @Override
    public GraphDTO getGraphStatus() {
        Pageable pageable = PageRequest.of(0,7);

        List<Workout> workouts = workoutRepository.findLast7Workouts(pageable);
        List<Activity> activities = activityRepository.findLast7Activities(pageable);

        GraphDTO graphDTO = new GraphDTO();
        List<WorkoutDTO> workoutDTOS = workouts.stream().map(workoutMapper::workoutEntityToDto).collect(Collectors.toList());
        List<ActivityDTO> activityDTOS = activities.stream().map(activityMapper::activityEntityToDto).collect(Collectors.toList());
        graphDTO.setWorkouts(workoutDTOS);
        graphDTO.setActivities(activityDTOS);

        return graphDTO;
    }


}
