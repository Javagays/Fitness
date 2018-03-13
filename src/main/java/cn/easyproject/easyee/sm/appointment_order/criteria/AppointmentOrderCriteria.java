package cn.easyproject.easyee.sm.appointment_order.criteria;

import cn.easyproject.easyee.sm.base.pagination.EasyCriteria;
import cn.easyproject.easyee.sm.base.util.StringUtils;


/**
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
public class AppointmentOrderCriteria extends EasyCriteria implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
 	 * 1. 条件属性
 	 */
	
	private Integer user_id;
	private Integer order_id;
	private Integer coach_id;
	private String start_appointment_time;
	private String end_appointment_time;	
	 /*
 	 * 2. 构造方法
 	 */
	public AppointmentOrderCriteria() {
		super();
	}

	public AppointmentOrderCriteria(Integer user_id, Integer order_id, Integer coach_id, String start_appointment_time,
			String end_appointment_time) {
		super();
		this.user_id = user_id;
		this.order_id = order_id;
		this.coach_id = coach_id;
		this.start_appointment_time = start_appointment_time;
		this.end_appointment_time = end_appointment_time;
	}


	/*
 	 * 3. 条件生成抽象方法实现
 	 */
	public String getCondition() {
		values.clear(); //清除条件数据
		StringBuffer condition = new StringBuffer();
		if (StringUtils.isNotNullAndEmpty(this.getCoach_id())) {
			condition.append(" and coach_id like #{coach_id}");
			values.put("coach_id", "%" + this.getCoach_id() + "%");
		}
		if (StringUtils.isNotNullAndEmpty(this.getOrder_id())) {
			condition.append(" and order_id like #{order_id}");
			values.put("order_id", "%" + this.getOrder_id() + "%");
		}
		if (StringUtils.isNotNullAndEmpty(this.getUser_id())) {
			condition.append(" and user_id like #{user_id}");
			values.put("user_id", "%" + this.getUser_id() + "%");
		}
		if (StringUtils.isNotNullAndEmpty(this.getStart_appointment_time())) {
			condition.append(" and appointment_time >=to_date('"+this.getStart_appointment_time()+"','YYYY-MM-DD HH:mm')");
		}
		if (StringUtils.isNotNullAndEmpty(this.getEnd_appointment_time())) {
			condition.append(" and appointment_time <=to_date('"+this.getEnd_appointment_time()+"','YYYY-MM-DD HH:mm')");
		}
		return condition.toString();
	}
	 /*
 	 * 4. Setters & Getters...
 	 */

	public Integer getCoach_id() {
		return coach_id;
	}

	public void setCoach_id(Integer coach_id) {
		this.coach_id = coach_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getStart_appointment_time() {
		return start_appointment_time;
	}

	public void setStart_appointment_time(String start_appointment_time) {
		this.start_appointment_time = start_appointment_time;
	}

	public String getEnd_appointment_time() {
		return end_appointment_time;
	}

	public void setEnd_appointment_time(String end_appointment_time) {
		this.end_appointment_time = end_appointment_time;
	} 
	
}