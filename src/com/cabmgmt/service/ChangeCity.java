package com.cabmgmt.service;

import com.cabmgmt.dao.CabDao;
import com.cabmgmt.dao.impl.CabDaoImpl;

public class ChangeCity {
public void updateCity(int cabId, String toChange) {
		
		CabDao cabDao = new CabDaoImpl();
		cabDao.changeCity(cabId, toChange);
		
		
	}
	
}
