package com.sanvalero.buses.service;

import com.sanvalero.buses.domain.Bus;
import com.sanvalero.buses.domain.BusLine;
import com.sanvalero.buses.exception.BusLineNotFoundException;
import com.sanvalero.buses.exception.BusNotFoundException;

import java.util.List;

public interface BusLineService {

    List<BusLine> findAll();
    BusLine findByName(String name);
    BusLine findById(long id) throws BusLineNotFoundException;
    BusLine addBusLine(BusLine busLine);
    void deleteBusLine(long id) throws BusLineNotFoundException;
    BusLine modifyBusLine(long id, BusLine newBusLine) throws BusLineNotFoundException;
}
