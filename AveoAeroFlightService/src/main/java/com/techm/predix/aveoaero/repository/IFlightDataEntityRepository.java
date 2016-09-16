package com.techm.predix.aveoaero.repository;


import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.predix.aveoaero.entity.FlightDataEntity;


@Repository
public interface IFlightDataEntityRepository extends JpaRepository<FlightDataEntity, Long>
{
	
}