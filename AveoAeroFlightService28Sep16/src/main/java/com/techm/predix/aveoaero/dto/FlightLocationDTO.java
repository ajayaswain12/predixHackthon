package com.techm.predix.aveoaero.dto;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * 
 * @author predix -
 */
@XmlRootElement
public class FlightLocationDTO {
	
	/*String flightPathData = "";

	*//**
	 * @return the flightPathData
	 *//*
	public String getFlightPathData() {
		return this.flightPathData;
	}

	*//**
	 * @param flightPathData the flightPathData to set
	 *//*
	public void setFlightPathData(String flightPathData) {
		this.flightPathData = flightPathData;
	}	*/
	String loc;
	String totalDistance;
	String distFromData;
	String distFromCalculation;
	String difference;	
	String errorTotalCourse;
	/**
	 * @return the loc
	 */
	public String getLoc() {
		return loc;
	}
	/**
	 * @param loc the loc to set
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}
	/**
	 * @return the totalDistance
	 */
	public String getTotalDistance() {
		return totalDistance;
	}
	/**
	 * @param totalDistance the totalDistance to set
	 */
	public void setTotalDistance(String totalDistance) {
		this.totalDistance = totalDistance;
	}
	/**
	 * @return the distFromData
	 */
	public String getDistFromData() {
		return distFromData;
	}
	/**
	 * @param distFromData the distFromData to set
	 */
	public void setDistFromData(String distFromData) {
		this.distFromData = distFromData;
	}
	/**
	 * @return the distFromCalculation
	 */
	public String getDistFromCalculation() {
		return distFromCalculation;
	}
	/**
	 * @param distFromCalculation the distFromCalculation to set
	 */
	public void setDistFromCalculation(String distFromCalculation) {
		this.distFromCalculation = distFromCalculation;
	}
	/**
	 * @return the difference
	 */
	public String getDifference() {
		return difference;
	}
	/**
	 * @param difference the difference to set
	 */
	public void setDifference(String difference) {
		this.difference = difference;
	}
	/**
	 * @return the errorTotalCourse
	 */
	public String getErrorTotalCourse() {
		return errorTotalCourse;
	}
	/**
	 * @param errorTotalCourse the errorTotalCourse to set
	 */
	public void setErrorTotalCourse(String errorTotalCourse) {
		this.errorTotalCourse = errorTotalCourse;
	}
	
	
}
