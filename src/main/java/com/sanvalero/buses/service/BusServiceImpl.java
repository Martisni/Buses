package com.sanvalero.buses.service;

import com.sanvalero.buses.domain.Bus;
import com.sanvalero.buses.domain.BusLine;
import com.sanvalero.buses.domain.dto.BusInDTO;
import com.sanvalero.buses.exception.BusLineNotFoundException;
import com.sanvalero.buses.exception.BusNotFoundException;
import com.sanvalero.buses.repository.BusLineRepository;
import com.sanvalero.buses.repository.BusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private BusLineRepository busLineRepository;

    @Autowired
    private ModelMapper modelMapper;

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
    public Bus addBus(BusInDTO busDTO) throws BusLineNotFoundException {
        Bus newBus = new Bus();
        modelMapper.map(busDTO,newBus);

        BusLine busLine = busLineRepository.findById(busDTO.getLine())
                        .orElseThrow(BusLineNotFoundException::new);
        newBus.setBusLine(busLine);

        return busRepository.save(newBus);
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
