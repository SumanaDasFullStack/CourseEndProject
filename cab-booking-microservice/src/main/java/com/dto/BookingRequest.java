package com.dto;

import lombok.Data;

@Data
public class BookingRequest {
	 
	    private Long sourceId;
	    private Long destinationId;
	    private Long cabTypeId;

}