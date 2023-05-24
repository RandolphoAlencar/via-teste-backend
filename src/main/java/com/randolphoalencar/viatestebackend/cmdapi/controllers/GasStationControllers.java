package com.randolphoalencar.viatestebackend.cmdapi.controllers;

import java.util.Arrays;

import com.randolphoalencar.viatestebackend.cmdapi.models.Car;

public final class GasStationControllers {
	
	public static void gasStation(Integer pumps, Car[] car) {
		
		
		Arrays.sort(car);
		
		System.out.println("\n\n\n");
		
		for(Car cars : car){
				
			System.out.println("       " + cars);
		}
				
		return;
	}

}
