package cn.easyproject.easyee.sm.appointment.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.easyproject.easyee.sm.appointment.criteria.AppointmentCriteria;
import cn.easyproject.easyee.sm.appointment.entity.Appointment;
import cn.easyproject.easyee.sm.appointment.service.AppointmentService;
import cn.easyproject.easyee.sm.base.controller.BaseController;
import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.util.StatusCode;

@RestController
@RequestMapping("Appointment")
public class AppointmentController extends BaseController{
public static Logger logger = LoggerFactory.getLogger(AppointmentController.class);
	
	@Resource
	private AppointmentService appointmentService;
	
	/**
	 * 转向显示页面
	 * @return
	 */
	@RequestMapping("page")
	public ModelAndView page(ModelAndView mv){
		mv.setViewName("main/appointment/Appointment");
		return mv;
	}
	/**
	 * CRUD
	 * @return
	 */
	@RequestMapping("save")
	public Map<Object,Object> save(Appointment appointment){
		// 保存
		try {
			appointmentService.save(appointment);
			// 处理成功 消息
			super.setMsgKey("msg.saveSuccess");
		} catch (Exception e) {
			e.printStackTrace();
			super.setMsgKey("msg.saveFail");
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		
		/*
		 * Ajax响应信息
		 * statusCode: 响应状态码;  
		 * msg: 响应消息;   
		 * callback: 执行回调函数,
		 * locationUrl: 跳转页面
		 */
		// EasyUI框架响应结果都是JSON
		// JSON数据初始化，包含EasySSH Ajax响应信息
		// super.setJsonMsgMap();
		
		
		// 添加数据后，使用rowData信息更新行的内容
		// 返回JSON
		return super.setJsonMsgMap("rowData", appointment);
		
		// 如果需要刷新，跳转到最后一页
//		int page = courseService.findMaxPage(rows);
//		return super.setJsonMsgMap("rowData", course, "page", page);
	}
	
	/**
	 * 分页
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("list")
	public Map<Object,Object> list(AppointmentCriteria appointmentCriteria){
		PageBean pb = super.getPageBean(); // 获得分页对
		appointmentService.findByPage(pb,appointmentCriteria);
		// EasyUI框架响应结果都是JSON
		// JSON数据初始化，包含EasySSH Ajax响应信息和分页信息
		return super.setJsonPaginationMap(pb);
	}

	@RequestMapping("delete")
	public Map<Object,Object> delete(Appointment appointment){
		try {
			appointmentService.delete(appointment.getAppointmentId());
		} catch (Exception e) {
			e.printStackTrace();
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		return super.setJsonMsgMap();
	}
	
	@RequestMapping("update")
	public Map<Object,Object> update(Appointment appointment){
		try {
			appointmentService.update(appointment);
			super.setMsgKey("msg.updateSuccess");
		} catch (Exception e) {
			e.printStackTrace();
			super.setMsgKey("msg.updateFail");
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		
		return super.setJsonMsgMap();
	}

}
