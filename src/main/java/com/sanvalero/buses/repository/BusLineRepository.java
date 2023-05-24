package com.sanvalero.buses.repository;

import com.sanvalero.buses.domain.BusLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusLineRepository extends CrudRepository<BusLine, Long> {
}
