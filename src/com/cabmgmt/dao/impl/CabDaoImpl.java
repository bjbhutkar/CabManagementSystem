package com.cabmgmt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cabmgmt.dao.CabDao;
import com.cabmgmt.entity.Cab;
import com.cabmgmt.helper.DbUtil;

public class CabDaoImpl implements CabDao {

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public CabDaoImpl() {
	};

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = DbUtil.getInstance().getConnection();
		return conn;
	}

	public void addCab(Cab cab) {

		try {
			String queryString = "INSERT INTO Cab(cabId, driverName, status, city, idleTimestamp ) VALUES(?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, cab.getCabId());
			ptmt.setString(2, cab.getDriverName());
			ptmt.setString(3, cab.getStatus());
			ptmt.setString(4, cab.getCity());
			ptmt.setTimestamp(5, cab.getIdleTimestamp());
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

	public int getCabId() {
		int cabId = 0;

		try {
			String queryString = "SELECT cabId FROM CAB WHERE STATUS = IDLE";
			connection = getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(queryString);
			List<Timestamp> idleTsList = new ArrayList<Timestamp>();
			while(rs.next()) {
				idleTsList.add(rs.getTimestamp("idleTimestamp"));
			}
			Timestamp maxTs = Collections.max(idleTsList);
			while(rs.next()) {
				if(maxTs == rs.getTimestamp("idleTimestamp")) {
					cabId = rs.getInt("cabId");
				}
			}
			

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
		return cabId;

	}

	public void changeCabStatus(int cabId, String toChange) {

		try {
			String queryString = "update cab set status = ? where cabId=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);

			ptmt.setInt(1, cabId);
			ptmt.setString(2, toChange);

			int rowsUpdated = ptmt.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing cab status has been updated successfully!");
			}

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

	@Override
	public void changeCity(int cabId, String toChange) {
		try {
			String queryString = "update cab set city = ? where cabId=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);

			ptmt.setString(1, toChange);
			ptmt.setInt(2, cabId);

			int rowsUpdated = ptmt.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing cab status has been updated successfully!");
			}

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
