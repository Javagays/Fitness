package cn.easyproject.easyee.sm.appointment_order.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

//import java.util.HashSet;
//import java.util.Set;

/**
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
public class AppointmentOrder implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer order_id;
	private Integer user_id;
	private Integer Coach_Id;
	private String site;
	private String user_name;
	private String coach_name;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
	private Timestamp appointment_time;
	
	
//	private Set moduleEmps = new HashSet(0);

	// Constructors

	/** default constructor */
	public AppointmentOrder() {
	}

	/** full constructor */
	public AppointmentOrder(Integer order_id, Integer user_id, Integer coach_Id, String site, String user_name,
			String coach_name, Timestamp appointment_time) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		Coach_Id = coach_Id;
		this.site = site;
		this.user_name = user_name;
		this.coach_name = coach_name;
		this.appointment_time = appointment_time;
	}
	
	
	
	public AppointmentOrder(Integer user_id, Integer coach_Id, String site, Timestamp appointment_time) {
		super();
		this.user_id = user_id;
		Coach_Id = coach_Id;
		this.site = site;
		this.appointment_time = appointment_time;
	}

	// Property accessors

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getCoach_Id() {
		return Coach_Id;
	}

	public void setCoach_Id(Integer coach_Id) {
		Coach_Id = coach_Id;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getCoach_name() {
		return coach_name;
	}

	public void setCoach_name(String coach_name) {
		this.coach_name = coach_name;
	}

	public Timestamp getAppointment_time() {
		return appointment_time;
	}

	public void setAppointment_time(Timestamp appointment_time) {
		this.appointment_time = appointment_time;
	}

	@Override
	public String toString() {
		return "AppointmentOrder [order_id=" + order_id + ", user_id=" + user_id + ", Coach_Id=" + Coach_Id + ", site="
				+ site + ", user_name=" + user_name + ", coach_name=" + coach_name + ", appointment_time="
				+ appointment_time + "]";
	}

}