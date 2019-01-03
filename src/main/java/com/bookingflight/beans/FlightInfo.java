package com.bookingflight.beans;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightInfo {
@JsonProperty("origin")
public String origin;
@JsonProperty("desc")
public String destination;
@JsonProperty("price")
public BigDecimal price;

public String getOrigin() {
	return origin;
}
public void setOrigin(String origin) {
	this.origin = origin;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public BigDecimal getPrice() {
	return price;
}
public void setPrice(BigDecimal price) {
	this.price = price;
}

}