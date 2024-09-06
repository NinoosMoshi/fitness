package com.ninos.services.stats;

import com.ninos.dto.StatsDTO;
import com.ninos.repository.GoalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StatsServiceImpl implements StatsService{

    private final GoalRepository goalRepository;


    @Override
    public StatsDTO getStats() {
        // Fetch goals count
        Long achievedGoals = goalRepository.countAchievedGoals();
        Long notAchievedGoals = goalRepository.countNotAchievedGoals();

        StatsDTO dto = new StatsDTO();
        dto.setAchievedGoals(achievedGoals != null ? achievedGoals : 0);
        dto.setNotAchievedGoals(notAchievedGoals != null ? notAchievedGoals : 0);
        return dto;
    }
}
