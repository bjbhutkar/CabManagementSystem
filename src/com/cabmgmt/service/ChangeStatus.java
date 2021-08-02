package com.cabmgmt.service;

import com.cabmgmt.dao.CabDao;
import com.cabmgmt.dao.impl.CabDaoImpl;

public class ChangeStatus {

	public void updateStatus(int cabId, String toChange) {
		
		CabDao cabDao = new CabDaoImpl();
		cabDao.changeCabStatus(cabId, toChange);
		
		
	}
	
	
}
