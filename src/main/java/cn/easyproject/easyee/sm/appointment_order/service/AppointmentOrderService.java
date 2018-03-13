package cn.easyproject.easyee.sm.appointment_order.service;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.easyproject.easyee.sm.appointment_order.criteria.AppointmentOrderCriteria;
import cn.easyproject.easyee.sm.appointment_order.entity.AppointmentOrder;
import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.course.entity.Course;
/**
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
@Transactional
public interface AppointmentOrderService {
	public void save(AppointmentOrder appointmentOrder);
	public void delete(Serializable order_id);
	public void update(AppointmentOrder appointmentOrder);
	
	@Transactional(readOnly=true)
	public AppointmentOrder get(Integer order_id);

	@SuppressWarnings("rawtypes")
	@Transactional(readOnly=true)
	public void findByPage(PageBean pageBean, AppointmentOrderCriteria appointmentOrderCriteria);
	
	@Transactional(readOnly=true)
	public List<AppointmentOrder> findAll();

}
