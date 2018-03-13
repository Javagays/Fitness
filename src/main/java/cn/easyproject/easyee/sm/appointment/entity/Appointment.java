package cn.easyproject.easyee.sm.appointment.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.easyproject.easyee.sm.coach.entity.Coach;

public class Appointment implements Serializable{
	
	// Fields
	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;
		private Integer appointmentId;
		private Integer userId;
		private Integer coachId;
		private String site;
		@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
		private Timestamp appointmentTime;
		private String userName;
		private String coachName;
		
		
		
		// Constructors
		
		/** default constructor */
		public Appointment() {
			super();
		}

		/** full constructor */
		
		public Appointment(Integer appointmentId, Integer userId, Integer coachId, String site,
				Timestamp appointmentTime, String userName, String coachName) {
			super();
			this.appointmentId = appointmentId;
			this.userId = userId;
			this.coachId = coachId;
			this.site = site;
			this.appointmentTime = appointmentTime;
			this.userName = userName;
			this.coachName = coachName;
		}
		
		public Appointment(Integer userId, Integer coachId, String site, Timestamp appointmentTime) {
			super();
			this.userId = userId;
			this.coachId = coachId;
			this.site = site;
			this.appointmentTime = appointmentTime;
		}

		public Integer getAppointmentId() {
			return appointmentId;
		}

		public void setAppointmentId(Integer appointmentId) {
			this.appointmentId = appointmentId;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public Integer getCoachId() {
			return coachId;
		}

		public void setCoachId(Integer coachId) {
			this.coachId = coachId;
		}

		public String getSite() {
			return site;
		}

		public void setSite(String site) {
			this.site = site;
		}

		public Timestamp getAppointmentTime() {
			return appointmentTime;
		}

		public void setAppointmentTime(Timestamp appointmentTime) {
			this.appointmentTime = appointmentTime;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getCoachName() {
			return coachName;
		}

		public void setCoachName(String coachName) {
			this.coachName = coachName;
		}

		@Override
		public String toString() {
			return "Appointment [appointmentId=" + appointmentId + ", userId=" + userId + ", coachId=" + coachId
					+ ", site=" + site + ", appointmentTime=" + appointmentTime + ", userName=" + userName
					+ ", coachName=" + coachName + "]";
		}

		
		
}
