package com.cabmgmt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cabmgmt.dao.BookingDao;
import com.cabmgmt.entity.Booking;
import com.cabmgmt.helper.DbUtil;


public class BookingDaoImpl implements BookingDao {

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	public BookingDaoImpl() {};
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = DbUtil.getInstance().getConnection();
		return conn;
	}
	
	
	public void addBooking(Booking booking) {
		
		try {
			String queryString = "INSERT INTO Booking(bookingId, cabId) VALUES(?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, booking.getBookingId());
			ptmt.setInt(2, booking.getCabId());
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	
	
	
}
