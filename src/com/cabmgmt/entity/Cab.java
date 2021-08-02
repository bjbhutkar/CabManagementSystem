package com.cabmgmt.entity;

import java.sql.Timestamp;

import com.cabmgmt.constants.Constants;

public class Cab {
	
		private int cabId;
		private String driverName;
		private String status;
		private String city;
		private Timestamp idleTimestamp;
	

		public Timestamp getIdleTimestamp() {
			return idleTimestamp;
		}

		public void setIdleTimestamp(Timestamp idleTimestamp) {
			this.idleTimestamp = idleTimestamp;
		}

		public Cab(int cabId, String driverName, String city, String currentLocation) {
			this.cabId = cabId;
			this.driverName = driverName;
			this.status = Constants.IDLE;
			this.city = city;
		}

		public int getCabId() {
			return cabId;
		}
		
		public String getDriverName() {
			return driverName;
		}
		
		public void setDriverName(String driverName) {
			this.driverName = driverName;
		}
		
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		@Override
		public String toString() {
			return "Cab [cabId=" + cabId + ", driverName=" + driverName + ", Status=" + status + ", city=" + city+", idleTimestamp=" + idleTimestamp +"]";
		}

		
		
		
		
		
}
