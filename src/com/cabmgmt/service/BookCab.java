package com.cabmgmt.service;

import com.cabmgmt.constants.Constants;
import com.cabmgmt.dao.BookingDao;
import com.cabmgmt.dao.BookingHelperDao;
import com.cabmgmt.dao.CabDao;
import com.cabmgmt.dao.impl.BookingDaoImpl;
import com.cabmgmt.dao.impl.BookingHelperDaoImpl;
import com.cabmgmt.dao.impl.CabDaoImpl;
import com.cabmgmt.entity.Booking;


public class BookCab {
		public void bookCab(){
			BookingHelperDao  bookinghelperdao = new BookingHelperDaoImpl();
			CabDao cabDao = new CabDaoImpl();
			int cabId = cabDao.getCabId();
			if(cabId!=0) {
				Booking book = new Booking();
				bookinghelperdao.setBookingId();
				book.setBookingId(bookinghelperdao.getBookingId());
				book.setCabId(cabId);
				BookingDao bookingdao = new BookingDaoImpl();
				bookingdao.addBooking(book);
				ChangeStatus changeStatus = new ChangeStatus();
				changeStatus.updateStatus(book.getCabId(), Constants.ON_TRIP);
			}
			else {
				System.out.println("Booking is not confirmed, Since no cabs are available at the moment.");
			}
			
		}

}
