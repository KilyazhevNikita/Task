package com.example.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusDto {

    private Long userId;

    private boolean statusBefore;

    private boolean statusAfter;
}
