package com.bookingflight.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import com.bookingflight.beans.*;
import com.bookingflight.services.FlightReservationClient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightReservationController {

	@Autowired
	FlightReservationClient client;

    @RequestMapping(value="/getBestPricesFlights",method = RequestMethod.GET)
    public List<FlightInfo> getBestPricesFlights(@RequestParam(value="origin") String origin,@RequestParam(value="dest") String desc) {
    	FlightInfo flight = new FlightInfo();
    	flight.setDestination("Toronto");
    	flight.setOrigin("Vancouver");
    	flight.setPrice(new BigDecimal("1200.01"));
    	List<FlightInfo> flightList = new ArrayList<FlightInfo>();
    	flightList.add(flight);
        return flightList;
    }
    
    public List<FlightInfo> calculateFlightsWithBestRate(){
    	Date startTime = null;
    	Date endTime = null;
    	String origin = null;
    	String dest = null;
    	List<FlightInfo> flightList = client.getAllFLights(startTime,endTime,origin,dest);
    	Collections.sort(flightList, new Comparator<FlightInfo>() {
			@Override
			public int compare(FlightInfo o1, FlightInfo o2) {
				if ( o1.getPrice().subtract(o2.getPrice()).longValueExact() > 0.0) {
					return 0;
				}
				return 1;
			}		
    	});
       return flightList.subList(0,2);
    }
    
}
