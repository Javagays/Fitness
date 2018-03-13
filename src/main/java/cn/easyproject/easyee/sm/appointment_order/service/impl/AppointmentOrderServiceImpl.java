package cn.easyproject.easyee.sm.appointment_order.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.easyproject.easyee.sm.appointment_order.criteria.AppointmentOrderCriteria;
import cn.easyproject.easyee.sm.appointment_order.dao.AppointmentOrderDAO;
import cn.easyproject.easyee.sm.appointment_order.entity.AppointmentOrder;
import cn.easyproject.easyee.sm.appointment_order.service.AppointmentOrderService;
import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.service.BaseService;

/**
 * 业务实现类统一继承 BaseService 类
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
@Service("appointmentOrderService")
public class AppointmentOrderServiceImpl extends BaseService implements AppointmentOrderService {

	@Resource
	AppointmentOrderDAO appointmentOrderDAO;
	
	@Override
	public void save(AppointmentOrder appointmentOrder) {
		appointmentOrderDAO.save(appointmentOrder);
	}

	@Override
	public void delete(Serializable order_id) {
		appointmentOrderDAO.delete(order_id);
	}

	@Override
	public void update(AppointmentOrder appointmentOrder) {
		appointmentOrderDAO.update(appointmentOrder);
	}

	@SuppressWarnings({ "rawtypes"})
	@Override
	public void findByPage(PageBean pageBean, AppointmentOrderCriteria appointmentOrderCriteria) {
		pageBean.setFrom("appointment_order appointment_order");
		pageBean.setSelect("appointment_order.*");
//		pageBean.setEasyCriteria(courseCriteria);
		// 按条件分页查询
		appointmentOrderDAO.pagination(pageBean);
	}

	@Override
	public List<AppointmentOrder> findAll() {
		return appointmentOrderDAO.findAll();
	}

	@Override
	public AppointmentOrder get(Integer order_id) {
		return appointmentOrderDAO.get(order_id);
	}
}