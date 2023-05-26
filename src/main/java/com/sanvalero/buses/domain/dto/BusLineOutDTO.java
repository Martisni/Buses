package com.sanvalero.buses.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusLineOutDTO {

    private String name;
    private LocalTime startTime;
    private LocalTime endTime;
    private int rate;
    private List<Long> buses;

}
