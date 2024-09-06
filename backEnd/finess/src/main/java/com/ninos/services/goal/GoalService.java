package com.ninos.services.goal;

import com.ninos.dto.GoalDTO;

import java.util.List;

public interface GoalService {

    GoalDTO postGoal(GoalDTO goalDTO);

    List<GoalDTO> getAllGoals();

    GoalDTO updateStatus(Long id);

}
