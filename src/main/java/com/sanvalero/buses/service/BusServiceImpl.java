package com.sanvalero.buses.service;

import com.sanvalero.buses.domain.Bus;
import com.sanvalero.buses.exception.BusNotFoundException;
import com.sanvalero.buses.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    @Override
    public List<Bus> findByHasWifi(boolean hasWifi) {
        return busRepository.findByHasWifi(hasWifi);
    }

    @Override
    public Bus findById(long id) throws BusNotFoundException {
        return busRepository.findById(id)
                .orElseThrow(BusNotFoundException::new);
    }

    @Override
    public Bus addBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public void deleteBus(long id) throws BusNotFoundException {
        Bus bus = busRepository.findById(id)
                .orElseThrow(BusNotFoundException::new);
        busRepository.delete(bus);
    }

    @Override
    public Bus modifyBus(long id, Bus newBus) throws BusNotFoundException {
        Bus existingBus = busRepository.findById(id)
                .orElseThrow(BusNotFoundException::new);
        existingBus.setCode(newBus.getCode());
        // Setear el resto de campos
        return busRepository.save(existingBus);
    }
}
