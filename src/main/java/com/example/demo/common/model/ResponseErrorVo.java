package com.example.demo.common.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseErrorVo {

    private String code = "0";

    private LocalDateTime timeStamp;

    private Object message;

    public ResponseErrorVo(LocalDateTime timeStamp, Object message) {
        this.timeStamp = timeStamp;
        this.message = message;
    }
}
