package com.sanvalero.buses.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusDTO {

    private String code;
    private int capacity;
    private boolean hasWifi;
    private long lineId;

}
