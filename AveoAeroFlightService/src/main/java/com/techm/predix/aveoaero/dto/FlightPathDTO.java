package com.techm.predix.aveoaero.dto;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * 
 * @author predix -
 */
@XmlRootElement
public class FlightPathDTO {
	
	private BigDecimal flight_id;
	private double time;
	private BigDecimal frame;
	private double m50;
	private double m51;
	private double m52;
	/**
	 * @return the flight_id
	 */
	public BigDecimal getFlight_id() {
		return flight_id;
	}
	/**
	 * @param flight_id the flight_id to set
	 */
	public void setFlight_id(BigDecimal flight_id) {
		this.flight_id = flight_id;
	}
	/**
	 * @return the time
	 */
	public double getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(double time) {
		this.time = time;
	}
	/**
	 * @return the frame
	 */
	public BigDecimal getFrame() {
		return frame;
	}
	/**
	 * @param frame the frame to set
	 */
	public void setFrame(BigDecimal frame) {
		this.frame = frame;
	}
	/**
	 * @return the m50
	 */
	public double getM50() {
		return m50;
	}
	/**
	 * @param m50 the m50 to set
	 */
	public void setM50(double m50) {
		this.m50 = m50;
	}
	/**
	 * @return the m51
	 */
	public double getM51() {
		return m51;
	}
	/**
	 * @param m51 the m51 to set
	 */
	public void setM51(double m51) {
		this.m51 = m51;
	}
	/**
	 * @return the m52
	 */
	public double getM52() {
		return m52;
	}
	/**
	 * @param m52 the m52 to set
	 */
	public void setM52(double m52) {
		this.m52 = m52;
	}
	
	
}
