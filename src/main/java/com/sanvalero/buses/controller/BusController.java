package com.sanvalero.buses.controller;

import com.sanvalero.buses.domain.Bus;
import com.sanvalero.buses.domain.dto.BusInDTO;
import com.sanvalero.buses.exception.BusLineNotFoundException;
import com.sanvalero.buses.exception.BusNotFoundException;
import com.sanvalero.buses.exception.ErrorMessage;
import com.sanvalero.buses.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/buses")
    public ResponseEntity<List<Bus>> getBuses(@RequestParam(name = "wifi", defaultValue = "") String wifi) {
        if (wifi.equals("")) {
            return ResponseEntity.ok(busService.findAll());
        } else {
            boolean hasWifi = Boolean.parseBoolean(wifi);
            return ResponseEntity.ok(busService.findByHasWifi(hasWifi));
        }
    }

    @GetMapping("/buses/{id}")
    public ResponseEntity<Bus> getBus(@PathVariable long id) throws BusNotFoundException {
        Bus bus = busService.findById(id);
        return ResponseEntity.ok(bus);
    }

    @PostMapping("/buses")
    public ResponseEntity<Bus> addBus(@RequestBody BusInDTO busDTO) throws BusLineNotFoundException {
        Bus newBus = busService.addBus(busDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBus);
    }

    @DeleteMapping("/buses/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable long id) throws BusNotFoundException {
        busService.deleteBus(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/buses/{id}")
    public ResponseEntity<Bus> modifyBus(@PathVariable long id, @RequestBody Bus bus) throws BusNotFoundException{
        Bus modifiedBus = busService.modifyBus(id, bus);
        return ResponseEntity.status(HttpStatus.OK).body(modifiedBus);
    }

    @ExceptionHandler(BusNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleBusNotFoundException(BusNotFoundException bnfe) {
        ErrorMessage errorMessage = new ErrorMessage(404, bnfe.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusLineNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleBusLineNotFoundException(BusLineNotFoundException blnfe) {
        ErrorMessage errorMessage = new ErrorMessage(404, blnfe.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleBusNotFoundException(MethodArgumentNotValidException manve) {
        Map<String, String> errors = new HashMap<>();
        manve.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        ErrorMessage badRequestErrorMessage = new ErrorMessage(400, "Bad Request", errors);
        return new ResponseEntity<>(badRequestErrorMessage, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorMessage> handleException(Exception e) {
//        ErrorMessage errorMessage = new ErrorMessage(500, "Internal Server Error");
//        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
