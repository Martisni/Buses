package com.sanvalero.buses.controller;

import com.sanvalero.buses.domain.BusLine;
import com.sanvalero.buses.service.BusLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusLineController {

    @Autowired
    private BusLineService busLineService;

    @GetMapping("/buslines")
    public ResponseEntity<List<BusLine>> getBusLines() {
        List<BusLine> busLines = busLineService.findAll();
        return ResponseEntity.ok(busLines);
    }

    @PostMapping("/buslines")
    public ResponseEntity<BusLine> addBusLine(@RequestBody BusLine busLine) {
        BusLine newBusLine = busLineService. addBusLine(busLine);
        return new ResponseEntity<>(newBusLine, HttpStatus.CREATED);
    }

}
