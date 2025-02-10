package com.example.scheduleproject.dto;

import lombok.Getter;

@Getter //Dto에 무지성 Getter
public class ScheduleResponseDto {
    private final Long id; // 왜 final임? => 어차피 response 즉 값을 전달 해줄놈인데 이게 바뀌면 되겠음?ㅋㅋ
    private final String content;

    public ScheduleResponseDto(Long id, String content){
        this.id = id;
        this.content = content;
    }
}
