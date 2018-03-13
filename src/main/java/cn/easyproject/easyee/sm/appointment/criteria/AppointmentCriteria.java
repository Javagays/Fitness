package cn.easyproject.easyee.sm.appointment.criteria;

import java.io.Serializable;

import cn.easyproject.easyee.sm.base.pagination.EasyCriteria;
import cn.easyproject.easyee.sm.base.util.StringUtils;

public class AppointmentCriteria extends EasyCriteria implements Serializable{

	// Fields

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/*
	 	 * 1. 条件属性
	 	 */
		
		private Integer userId;
		private Integer appointmentId;
		private Integer coachId;
		private String appointmentTime;
		 /*
	 	 * 2. 构造方法
	 	 */
	
		public AppointmentCriteria(Integer userId, Integer appointmentId, Integer coachId,
				String appointmentTime) {
			super();
			this.userId = userId;
			this.appointmentId = appointmentId;
			this.coachId = coachId;
			this.appointmentTime = appointmentTime;
		}
		
		

		public AppointmentCriteria() {
			super();
		}



		/*
	 	 * 3. 条件生成抽象方法实现
	 	 */
		public String getCondition() {
			values.clear(); //清除条件数据
			StringBuffer condition = new StringBuffer();
			if (StringUtils.isNotNullAndEmpty(this.getCoachId())) {
				condition.append(" and c.Coach_Id=#{coachId}");
				values.put("coachId",this.getCoachId());
			}
			if (StringUtils.isNotNullAndEmpty(this.getAppointmentId())) {
				condition.append(" and a.order_id=#{appointmentId}");
				values.put("appointmentId",this.getAppointmentId());
			}
			if (StringUtils.isNotNullAndEmpty(this.getUserId())) {
				condition.append(" and u.user_id=#{userId}");
				values.put("userId",this.getUserId());
			}
			if (StringUtils.isNotNullAndEmpty(this.getAppointmentTime())) {
				condition.append(" and a.appointment_time >= '"+this.getAppointmentTime()+" 00:00:00' ");
				condition.append(" and a.appointment_time <= '"+this.getAppointmentTime()+" 23:59:59' ");
				values.put("appointmentTime",this.getAppointmentTime());
			}
			return condition.toString();
		}
		 /*
	 	 * 4. Setters & Getters...
	 	 */



		public Integer getUserId() {
			return userId;
		}



		public void setUserId(Integer userId) {
			this.userId = userId;
		}



		public Integer getAppointmentId() {
			return appointmentId;
		}



		public void setAppointmentId(Integer appointmentId) {
			this.appointmentId = appointmentId;
		}



		public Integer getCoachId() {
			return coachId;
		}



		public void setCoachId(Integer coachId) {
			this.coachId = coachId;
		}



		public String getAppointmentTime() {
			return appointmentTime;
		}



		public void setAppointmentTime(String appointmentTime) {
			this.appointmentTime = appointmentTime;
		}

}
