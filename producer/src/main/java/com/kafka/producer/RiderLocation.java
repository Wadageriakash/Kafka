package com.kafka.producer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RiderLocation {

	private String riderId;
	private double latitude;
	private double longitude;
}
