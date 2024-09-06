package com.ninos.services.goal;

import com.ninos.dto.GoalDTO;
import com.ninos.entity.Goal;
import com.ninos.mapper.GoalMapper;
import com.ninos.repository.GoalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoalServiceImpl implements GoalService{

    private final GoalRepository goalRepository;
    private final GoalMapper goalMapper;


    @Override
    public GoalDTO postGoal(GoalDTO goalDTO) {
        Goal goal = goalMapper.goalDtoToEntity(goalDTO);
        Goal savedGoal = goalRepository.save(goal);
        return goalMapper.goalEntityToDto(savedGoal);
    }

    @Override
    public List<GoalDTO> getAllGoals() {
        List<Goal> goals = goalRepository.findAll();
        return goals.stream().map(goalMapper::goalEntityToDto).collect(Collectors.toList());
    }

    @Override
    public GoalDTO updateStatus(Long id) {
        Optional<Goal> optionalGoal = goalRepository.findById(id);

        if(optionalGoal.isPresent()){
            Goal exitingGoal = optionalGoal.get();
            exitingGoal.setAchieved(true);
            Goal savedGoal = goalRepository.save(exitingGoal);
            return goalMapper.goalEntityToDto(savedGoal);
        }
        throw  new EntityNotFoundException("Get not found.");
    }





}
