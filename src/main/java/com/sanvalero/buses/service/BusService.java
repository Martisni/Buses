package com.sanvalero.buses.service;

import com.sanvalero.buses.domain.Bus;
import com.sanvalero.buses.exception.BusNotFoundException;

import java.util.List;

public interface BusService {

    List<Bus> findAll();
    List<Bus> findByHasWifi(boolean hasWifi);
    Bus findById(long id) throws BusNotFoundException;
    Bus addBus(Bus bus);
    void deleteBus(long id) throws BusNotFoundException;
    Bus modifyBus(long id, Bus newBus) throws BusNotFoundException;
}
