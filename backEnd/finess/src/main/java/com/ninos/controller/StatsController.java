package com.ninos.controller;

import com.ninos.dto.GraphDTO;
import com.ninos.services.stats.StatsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StatsController {

    private final StatsService statsService;

    @GetMapping("/stats")
    public ResponseEntity<?> getStats(){
        return ResponseEntity.ok(statsService.getStats());
    }


    @GetMapping("/graphs")
    public ResponseEntity<?> getGraphStats() {
        GraphDTO graphDTO = statsService.getGraphStatus();

        if(graphDTO != null) {
            return ResponseEntity.ok(graphDTO);
        }else {
            return ResponseEntity.status(404).body(null);
        }
    }


}
