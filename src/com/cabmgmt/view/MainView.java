package com.cabmgmt.view;

import com.cabmgmt.constants.Constants;
import com.cabmgmt.service.BookCab;
import com.cabmgmt.service.ChangeCity;
import com.cabmgmt.service.ChangeStatus;


public class MainView {

	public static void main(String[] args) {
	
	        BookCab bookcab = new BookCab();
	        bookcab.bookCab();
	        
	        ChangeCity changeCity = new ChangeCity();
	        changeCity.updateCity(1, "Pune");
	        
        	ChangeStatus cs = new ChangeStatus();
        	cs.updateStatus(1, Constants.IDLE);
	}
}


