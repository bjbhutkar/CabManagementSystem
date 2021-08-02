package com.cabmgmt.dao;

import com.cabmgmt.entity.Cab;

public interface CabDao {
	
	public void addCab(Cab cab);

	public int getCabId();
	
	public void changeCabStatus(int cabId, String i);

	public void changeCity(int cabId, String toChange);
}
