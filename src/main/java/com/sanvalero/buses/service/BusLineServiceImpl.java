package com.sanvalero.buses.service;

import com.sanvalero.buses.domain.BusLine;
import com.sanvalero.buses.exception.BusLineNotFoundException;
import com.sanvalero.buses.repository.BusLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusLineServiceImpl implements BusLineService{

    @Autowired
    private BusLineRepository busLineRepository;

    @Override
    public List<BusLine> findAll() {
        return busLineRepository.findAll();
    }

    @Override
    public BusLine findByName(String name) {
        return busLineRepository.findByName(name);
    }

    @Override
    public BusLine findById(long id) throws BusLineNotFoundException {
        return busLineRepository.findById(id)
                .orElseThrow(BusLineNotFoundException::new);
    }

    @Override
    public BusLine addBusLine(BusLine busLine) {
        return busLineRepository.save(busLine);
    }

    @Override
    public void deleteBusLine(long id) throws BusLineNotFoundException {
        BusLine busLine = busLineRepository.findById(id)
                .orElseThrow(BusLineNotFoundException::new);
        busLineRepository.delete(busLine);
    }

    @Override
    public BusLine modifyBusLine(long id, BusLine newBusLine) throws BusLineNotFoundException {
        return null;
    }
}
