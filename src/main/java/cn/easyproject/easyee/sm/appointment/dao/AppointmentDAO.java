package cn.easyproject.easyee.sm.appointment.dao;

import java.io.Serializable;
import java.util.List;

import cn.easyproject.easyee.sm.appointment.entity.Appointment;
import cn.easyproject.easyee.sm.base.pagination.PageBean;

public interface AppointmentDAO {
	
	public void save(Appointment appointment);

	public void delete(Serializable appointmentId);

	public Appointment get(Integer appointmentId);
	
	public void update(Appointment appointment);

	@SuppressWarnings("rawtypes")
	public List pagination(PageBean pageBean);

	public List<Appointment> findAll();
	
	public int findMaxRow();

}
