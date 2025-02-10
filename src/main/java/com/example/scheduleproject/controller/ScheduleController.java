package com.example.scheduleproject.controller;


import com.example.scheduleproject.dto.ScheduleRequestDto;
import com.example.scheduleproject.dto.ScheduleResponseDto;
import com.example.scheduleproject.entity.Schedule;
import com.example.scheduleproject.service.SchduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final SchduleService schduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto dto){
        return ResponseEntity.ok(schduleService.save(dto));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){
        return ResponseEntity.ok(schduleService.findAll());
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(schduleService.findById(id));
    }

    @PutMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> update(@PathVariable Long id, @RequestBody ScheduleRequestDto dto){
        return ResponseEntity.ok(schduleService.update(id,dto));
    }

    @DeleteMapping("/schedules/{id}")
    public void deleteById(@PathVariable Long id){
        schduleService.deleteById(id);
    }
}
