package com.ninos.services.workout;

import com.ninos.dto.WorkoutDTO;
import com.ninos.entity.Workout;
import com.ninos.mapper.WorkoutMapper;
import com.ninos.repository.WorkoutRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkoutServiceImpl implements WorkoutService{


    private final WorkoutRepository workoutRepository;
    private final WorkoutMapper workoutMapper;


    @Override
    public WorkoutDTO postWorkout(WorkoutDTO workoutDTO) {
        Workout workout = workoutMapper.workoutDtoToEntity(workoutDTO);
        Workout savedWorkout = workoutRepository.save(workout);

        return workoutMapper.workoutEntityToDto(savedWorkout);
    }


    @Override
    public List<WorkoutDTO> getWorkouts() {
        List<Workout> workouts = workoutRepository.findAll();
        return workouts.stream().map(workout -> workoutMapper.workoutEntityToDto(workout))
                .collect(Collectors.toList());

    }


}
