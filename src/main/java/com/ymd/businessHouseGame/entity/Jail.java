package com.ymd.businessHouseGame.entity;

import java.math.BigDecimal;

public class Jail implements Cell {
	
	private final BigDecimal penality=new BigDecimal(150);
	

	public BigDecimal getPenality() {
		return penality;
	}

	

}
