package com.techm.predix.aveoaero.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the avioaerodata database table.
 * 
 */
@Embeddable
public class AvioDataNew1PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FLIGHT_ID")
	private BigDecimal flightId;

	@Column(name="TIME")
	private double time;

	public AvioDataNew1PK() {
	}
	public BigDecimal getFlightId() {
		return this.flightId;
	}
	public void setFlightId(BigDecimal flightId) {
		this.flightId = flightId;
	}
	public double getTime() {
		return this.time;
	}
	public void setTime(double time) {
		this.time = time;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AvioDataNew1PK)) {
			return false;
		}
		AvioDataNew1PK castOther = (AvioDataNew1PK)other;
		return 
			(this.flightId == castOther.flightId)
			&& (this.time == castOther.time);
	}

	/*public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.flightId ^ (this.flightId >>> 32)));
		hash = hash * prime + ((int) (this.time ^ (this.time >>> 32)));
		
		return hash;
	}*/
}