package com.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.CabType;
@SpringBootTest
class CabTypeServiceTest {
	
	@Autowired
	CabTypeService cabtypeService;

	@Test
	void testGetallcabType() {
		List<CabType> listOfCabType = cabtypeService.getallcabType();
		assertNotNull(listOfCabType);//memory of list
		assertEquals(7, listOfCabType.size());
		CabType cabtype =listOfCabType.get(2);
		assertEquals(100, cabtype.getBase_fare());
		
	}

	//@Test
	void testAddCabType() {
		List<CabType> listOfCabType = cabtypeService.getallcabType();
		CabType cabtype = new CabType();
		cabtype.setCabtype_id(10L);
		cabtype.setCabtype_name("farrari");
		cabtype.setBase_fare(200.0);
		cabtype.setKmhr_fare(20);
		String value =cabtypeService.addCabType(cabtype);
		assertEquals("Cab Type added successfully", value);
		String value_one =cabtypeService.addCabType(cabtype);
		assertEquals("Internal Server Error", value_one);
	}

	

}