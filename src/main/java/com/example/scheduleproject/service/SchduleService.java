package com.example.scheduleproject.service;

import com.example.scheduleproject.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchduleService {

    private final ScheduleRepository scheduleRepository;
}
