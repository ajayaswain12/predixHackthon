package com.techm.predix.aveoaero.dto;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * 
 * @author predix -
 */
//@XmlRootElement
public class FlightDataWrapperDTO {	
	
	List<FlightParametersDTO> flightParametersDtoList = new ArrayList<FlightParametersDTO>();
	
	/**
	 * @return the flightParametersDtoList
	 */
	public List<FlightParametersDTO> getFlightParametersDtoList() {
		return this.flightParametersDtoList;
	}
	/**
	 * @param flightParametersDtoList the flightParametersDtoList to set
	 */
	public void setFlightParametersDtoList(List<FlightParametersDTO> flightParametersDtoList) {
		this.flightParametersDtoList = flightParametersDtoList;
	}
}
