package com.techm.predix.aveoaero.repository;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techm.predix.aveoaero.entity.FlightDataEntity;


@Repository
public interface IFlightDataEntityRepository extends JpaRepository<FlightDataEntity, Long>
{
	String GET_FLIGHT_DETAILS = "select a from FlightDataEntity a where a.id.flightId = ?1 ";

	@Query(GET_FLIGHT_DETAILS)
	List<FlightDataEntity>   findByflightId(BigDecimal flight_id);
}