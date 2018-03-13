package cn.easyproject.easyee.sm.appointment.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.easyproject.easyee.sm.appointment.criteria.AppointmentCriteria;
import cn.easyproject.easyee.sm.appointment.dao.AppointmentDAO;
import cn.easyproject.easyee.sm.appointment.entity.Appointment;
import cn.easyproject.easyee.sm.appointment.service.AppointmentService;
import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.service.BaseService;
import cn.easyproject.easyee.sm.hr.criteria.EmpCriteria;

@Service("appointmentService")
public class AppointmentServiceImpl extends BaseService implements AppointmentService{

	@Resource
	AppointmentDAO appointmentDAO;
	
	@Override
	public void save(Appointment appointment) {
		appointmentDAO.save(appointment);
	}

	@Override
	public void delete(Serializable appointmentId) {
		appointmentDAO.delete(appointmentId);
	}

	@Override
	public void update(Appointment appointment) {
		appointmentDAO.update(appointment);
	}
	
	@SuppressWarnings({ "rawtypes" })
	@Override
	public void findByPage(PageBean pageBean, AppointmentCriteria appointmentCriteria) {
		pageBean.setFrom(" appointment_order a, Coach c ,user u ");
		pageBean.setSelect("a.order_id, a.site, a.appointment_time,c.Coach_Id, c.Coach_name , u.user_id, u.user_name");
		pageBean.addCondition("and a.Coach_Id=c.Coach_Id and a.user_id=u.user_id");
		pageBean.setPrimaryTable("a");
		pageBean.setEasyCriteria(appointmentCriteria);
		// 按条件分页查询
		appointmentDAO.pagination(pageBean);
	}

	@Override
	public List<Appointment> findAll() {
		return appointmentDAO.findAll();
	}

	@Override
	public Appointment get(Integer appointmentId) {
		return appointmentDAO.get(appointmentId);
	}

}
