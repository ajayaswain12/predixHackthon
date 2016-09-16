package com.techm.predix.aveoaero.dto;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * 
 * @author predix -
 */
@XmlRootElement
public class FlightParametersDTO {

	private BigDecimal flight_id;
	private double time;
	private BigDecimal frame;
	private double e07;
	private double e08;
	private double e60;
	private double e61;
	private BigDecimal l01;
	private double m61;
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
	 * @return the e07
	 */
	public double getE07() {
		return e07;
	}
	/**
	 * @param e07 the e07 to set
	 */
	public void setE07(double e07) {
		this.e07 = e07;
	}
	/**
	 * @return the e08
	 */
	public double getE08() {
		return e08;
	}
	/**
	 * @param e08 the e08 to set
	 */
	public void setE08(double e08) {
		this.e08 = e08;
	}
	/**
	 * @return the e60
	 */
	public double getE60() {
		return e60;
	}
	/**
	 * @param e60 the e60 to set
	 */
	public void setE60(double e60) {
		this.e60 = e60;
	}
	/**
	 * @return the e61
	 */
	public double getE61() {
		return e61;
	}
	/**
	 * @param e61 the e61 to set
	 */
	public void setE61(double e61) {
		this.e61 = e61;
	}
	/**
	 * @return the l01
	 */
	public BigDecimal getL01() {
		return l01;
	}
	/**
	 * @param l01 the l01 to set
	 */
	public void setL01(BigDecimal l01) {
		this.l01 = l01;
	}
	/**
	 * @return the m61
	 */
	public double getM61() {
		return m61;
	}
	/**
	 * @param m61 the m61 to set
	 */
	public void setM61(double m61) {
		this.m61 = m61;
	}
	
	
}
