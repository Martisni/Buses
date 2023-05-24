package com.sanvalero.buses.repository;

import com.sanvalero.buses.domain.BusStop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusStopRepository extends CrudRepository<BusStop, Long> {
}
