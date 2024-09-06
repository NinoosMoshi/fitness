package com.ninos.mapper;

import com.ninos.dto.WorkoutDTO;
import com.ninos.entity.Workout;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class WorkoutMapper {

    public WorkoutDTO workoutEntityToDto(Workout workout){
        WorkoutDTO workoutDTO = new WorkoutDTO();
        BeanUtils.copyProperties(workout, workoutDTO);
        return workoutDTO;
    }

    public Workout workoutDtoToEntity(WorkoutDTO workoutDTO){
        Workout workout = new Workout();
        BeanUtils.copyProperties(workoutDTO, workout);
        return workout;
    }

}
