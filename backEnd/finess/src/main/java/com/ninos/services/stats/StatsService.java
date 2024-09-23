package com.ninos.services.stats;

import com.ninos.dto.GraphDTO;
import com.ninos.dto.StatsDTO;

public interface StatsService {

    StatsDTO getStats();
    GraphDTO getGraphStatus();

}
