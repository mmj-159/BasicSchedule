package com.example.scheduleproject.controller;


import com.example.scheduleproject.service.SchduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final SchduleService schduleService;
}
