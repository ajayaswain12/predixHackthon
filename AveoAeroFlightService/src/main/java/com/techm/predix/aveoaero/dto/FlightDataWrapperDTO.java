package com.techm.predix.aveoaero.dto;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * 
 * @author predix -
 */
@XmlRootElement
public class FlightDataWrapperDTO {	
	
	FlightParametersDTO flightParameterData = new FlightParametersDTO();
	FlightPathDTO flightPathData = new FlightPathDTO();
	/**
	 * @return the flightParameterData
	 */
	public FlightParametersDTO getFlightParameterData() {
		return flightParameterData;
	}
	/**
	 * @param flightParameterData the flightParameterData to set
	 */
	public void setFlightParameterData(FlightParametersDTO flightParameterData) {
		this.flightParameterData = flightParameterData;
	}
	/**
	 * @return the flightPathData
	 */
	public FlightPathDTO getFlightPathData() {
		return flightPathData;
	}
	/**
	 * @param flightPathData the flightPathData to set
	 */
	public void setFlightPathData(FlightPathDTO flightPathData) {
		this.flightPathData = flightPathData;
	}
	
}
