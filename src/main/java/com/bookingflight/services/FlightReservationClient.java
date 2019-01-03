package com.bookingflight.services;

import java.util.Date;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bookingflight.beans.*;

@Service
public class FlightReservationClient {
	private final RestTemplate restTemplate;

	public FlightReservationClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public List<FlightInfo> getAllFLights(Date startDate, Date endDate, String origin, String dest) {
		ResponseEntity<List<FlightInfo>> response = restTemplate.exchange(
				  "http://localhost:8080/employees/",
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<FlightInfo>>(){});
		return response.getBody();
	}
}
