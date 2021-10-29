package com.example.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private String uri;

    private String name;

    private String mail;

    private boolean online;

    private Long timestamp;
}
