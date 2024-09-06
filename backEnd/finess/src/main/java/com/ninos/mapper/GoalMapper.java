package com.ninos.mapper;

import com.ninos.dto.GoalDTO;
import com.ninos.entity.Goal;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class GoalMapper {

    public GoalDTO goalEntityToDto(Goal goal){
        GoalDTO goalDTO = new GoalDTO();
        BeanUtils.copyProperties(goal, goalDTO);
        return goalDTO;
    }

    public Goal goalDtoToEntity(GoalDTO goalDTO){
        Goal goal = new Goal();
        BeanUtils.copyProperties(goalDTO, goal);
        return goal;
    }

}
