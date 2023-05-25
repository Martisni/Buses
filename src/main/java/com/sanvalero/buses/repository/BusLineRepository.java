package com.sanvalero.buses.repository;

import com.sanvalero.buses.domain.BusLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusLineRepository extends CrudRepository<BusLine, Long> {

    List<BusLine> findAll();
    BusLine findByName(String name);
}
