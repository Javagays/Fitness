package cn.easyproject.easyee.sm.appointment_order.dao;

import java.io.Serializable;
import java.util.List;

import cn.easyproject.easyee.sm.appointment_order.entity.AppointmentOrder;
import cn.easyproject.easyee.sm.base.pagination.PageBean;
/**
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
public interface AppointmentOrderDAO {
	
	public void save(AppointmentOrder appointmentOrder);

	public void delete(Serializable order_id);

	public AppointmentOrder get(Integer order_id);
	
	public void update(AppointmentOrder appointmentOrder);

	@SuppressWarnings("rawtypes")
	public List pagination(PageBean pageBean);

	public List<AppointmentOrder> findAll();
	
	public int findMaxRow();
}
