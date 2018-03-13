package cn.easyproject.easyee.sm.appointment.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.easyproject.easyee.sm.appointment.criteria.AppointmentCriteria;
import cn.easyproject.easyee.sm.appointment.entity.Appointment;
import cn.easyproject.easyee.sm.base.pagination.PageBean;

public interface AppointmentService {
	
	public void save(Appointment appointment);
	public void delete(Serializable appointmentId);
	public void update(Appointment appointment);
	
	@Transactional(readOnly=true)
	public Appointment get(Integer appointmentId);

	@SuppressWarnings("rawtypes")
	@Transactional(readOnly=true)
	public void findByPage(PageBean pageBean, AppointmentCriteria appointmentCriteria);
	
	@Transactional(readOnly=true)
	public List<Appointment> findAll();

}
