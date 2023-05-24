package com.sanvalero.buses.repository;

import com.sanvalero.buses.domain.Bus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends CrudRepository<Bus, Long> {

    //Query Methods
    List<Bus> findAll();
    List<Bus> findByHasWifi(boolean hasWifi);
    Bus findByCode(String code);
}
