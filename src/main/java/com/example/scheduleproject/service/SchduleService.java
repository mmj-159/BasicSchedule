package com.example.scheduleproject.service;

import com.example.scheduleproject.dto.ScheduleRequestDto;
import com.example.scheduleproject.dto.ScheduleResponseDto;
import com.example.scheduleproject.entity.Schedule;
import com.example.scheduleproject.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto save(ScheduleRequestDto dto){
        Schedule schedule = new Schedule(dto.getContent());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule.getId(),savedSchedule.getContent());
    }

    @Transactional
    public List<ScheduleResponseDto> findAll(){
        List<Schedule> schedules = scheduleRepository.findAll();

        List<ScheduleResponseDto> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            dtos.add(new ScheduleResponseDto(schedule.getId(), schedule.getContent()));
        }
        return dtos;
    }

    @Transactional
    public ScheduleResponseDto findById(Long id){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id에 해당하는 일정 없음!")
        );
        return new ScheduleResponseDto(schedule.getId(), schedule.getContent());
    }

    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleRequestDto dto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id에 해당하는 일정 없음!(수정)")
        );

        schedule.update(dto.getContent());
        return new ScheduleResponseDto(schedule.getId(), schedule.getContent());
    }

    @Transactional
    public void deleteById(Long id) { //리턴 값 없어도 되니까 void임
        if (!scheduleRepository.existsById(id)) {
            throw new IllegalArgumentException("유감, id에 해당하는 일정없음");
        }
        scheduleRepository.deleteById(id);
    }
}



