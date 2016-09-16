package com.techm.predix.aveoaero;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.neo4j.cypher.internal.compiler.v2_1.ast.rewriters.flattenBooleanOperators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techm.predix.aveoaero.dto.FlightParametersDTO;
import com.techm.predix.aveoaero.dto.FlightPathDTO;
import com.techm.predix.aveoaero.entity.FlightDataEntity;
import com.techm.predix.aveoaero.repository.IFlightDataEntityRepository;






@RestController
public class FlightDataService {

	@Autowired
	private IFlightDataEntityRepository flightDataEntityRepo;
	
	@RequestMapping(value = "/getFlightParameters", method = RequestMethod.GET)
	public @ResponseBody List<FlightParametersDTO> getFlightParameters() {
		List<FlightParametersDTO> flightParametersList = new ArrayList<FlightParametersDTO>();
		FlightParametersDTO flightParametersDTO = null;

		try {
			List<FlightDataEntity> flightDataFromDb = flightDataEntityRepo.findAll();
			for(FlightDataEntity flightDataEntity : flightDataFromDb){
				flightParametersDTO =  new FlightParametersDTO();
				flightParametersDTO.setFlight_id(flightDataEntity.getId().getFlightId());
				flightParametersDTO.setTime(flightDataEntity.getId().getTime());
				flightParametersDTO.setFrame(flightDataEntity.getFrame());
				flightParametersDTO.setE07(flightDataEntity.getE07());
				flightParametersDTO.setE08(flightDataEntity.getE08());
				flightParametersDTO.setE60(flightDataEntity.getE60());
				flightParametersDTO.setE61(flightDataEntity.getE61());
				flightParametersDTO.setL01(flightDataEntity.getL01());
				flightParametersDTO.setM61(flightDataEntity.getM61());
				
				flightParametersList.add(flightParametersDTO);
			}
		} catch (Exception e) {
			System.out.println("Exception in getFlightParameters()");
			e.printStackTrace();
		}		
		return flightParametersList;
	}
	
	@RequestMapping(value = "/getFlightPathData", method = RequestMethod.GET)
	public @ResponseBody List<FlightPathDTO> getFlightData() {
		List<FlightPathDTO> flightDataDtoList = new ArrayList<FlightPathDTO>();
		FlightPathDTO flightDataDto = null;

		try {
			List<FlightDataEntity> flightDataFromDb = flightDataEntityRepo.findAll();
			for(FlightDataEntity flightDataEntity : flightDataFromDb){
				flightDataDto =  new FlightPathDTO();
				flightDataDto.setFlight_id(flightDataEntity.getId().getFlightId());
				flightDataDto.setTime(flightDataEntity.getId().getTime());
				flightDataDto.setFrame(flightDataEntity.getFrame());
				flightDataDto.setM50(flightDataEntity.getM50());
				flightDataDto.setM51(flightDataEntity.getM51());
				flightDataDto.setM52(flightDataEntity.getM52());
				
				flightDataDtoList.add(flightDataDto);
			}
		} catch (Exception e) {
			System.out.println("Exception in getFlightParameters()");
			e.printStackTrace();
		}		
		return flightDataDtoList;
	}
	
	@RequestMapping(value = "/getAllFlightData/{flight_id}", method = RequestMethod.GET)
	public @ResponseBody List<FlightPathDTO> getAllFlightData(@PathVariable BigDecimal flight_id) {
		List<FlightPathDTO> flightDataDtoList = new ArrayList<FlightPathDTO>();
		FlightPathDTO flightDataDto = null;

		try {
			List<FlightDataEntity> flightDataFromDb = flightDataEntityRepo.findAll();
			for(FlightDataEntity flightDataEntity : flightDataFromDb){
				if(flight_id.equals(flightDataEntity.getId().getFlightId())){
					flightDataDto =  new FlightPathDTO();
					flightDataDto.setFlight_id(flightDataEntity.getId().getFlightId());
					flightDataDto.setTime(flightDataEntity.getId().getTime());
					flightDataDto.setFrame(flightDataEntity.getFrame());
					flightDataDto.setM50(flightDataEntity.getM50());
					flightDataDto.setM51(flightDataEntity.getM51());
					flightDataDto.setM52(flightDataEntity.getM52());
					
					flightDataDtoList.add(flightDataDto);
				}
				
			}
		} catch (Exception e) {
			System.out.println("Exception in getFlightParameters()");
			e.printStackTrace();
		}		
		return flightDataDtoList;
	}
	
	@RequestMapping(value = "/getAllFlightPlotData/{flight_id}", method = RequestMethod.GET)
	public @ResponseBody List<FlightPathDTO> getAllFlightPlotData(@PathVariable BigDecimal flight_id) {
		List<FlightPathDTO> flightDataDtoList = new ArrayList<FlightPathDTO>();
		FlightPathDTO flightDataDto = null;

		try {
			List<FlightDataEntity> flightDataFromDb = flightDataEntityRepo.findAll();
			for(FlightDataEntity flightDataEntity : flightDataFromDb){
				if(flight_id.equals(flightDataEntity.getId().getFlightId())){
					flightDataDto =  new FlightPathDTO();
					flightDataDto.setFlight_id(flightDataEntity.getId().getFlightId());
					flightDataDto.setTime(flightDataEntity.getId().getTime());
					flightDataDto.setFrame(flightDataEntity.getFrame());
					flightDataDto.setM50(flightDataEntity.getM50());
					flightDataDto.setM51(flightDataEntity.getM51());
					flightDataDto.setM52(flightDataEntity.getM52());
					
					flightDataDtoList.add(flightDataDto);
				}
				
			}
		} catch (Exception e) {
			System.out.println("Exception in getFlightParameters()");
			e.printStackTrace();
		}		
		return flightDataDtoList;
	}
}
