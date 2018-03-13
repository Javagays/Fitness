package cn.easyproject.easyee.sm.course.controller;


import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.easyproject.easyee.sm.base.controller.BaseController;
import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.util.StatusCode;
import cn.easyproject.easyee.sm.course.service.CourseService;
import cn.easyproject.easyee.sm.course.entity.Course;
import cn.easyproject.easyee.sm.course.criteria.CourseCriteria;
/**
 * 所有Controller处理类统一继承BaseController
 * 
 * BaseController中定义了一下内容：
 * - request, application Servlet API 
 * - 请求响应相关的JSON参数（EasyUI框架请求都是通过JSON响应） 
 * - 初始化JSON响应数据的方法（setJsonMap，setJsonMsgMap，setJsonPaginationMap(PageBean, Object...)） 
 * - 获得分页对象：super.getPageBean() 
 * 
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
@RestController
@RequestMapping("Course")
public class CourseController extends BaseController {
	public static Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	@Resource
	private CourseService courseService;
	
	/**
	 * 转向显示页面
	 * @return
	 */
	@RequestMapping("page")
	public ModelAndView page(ModelAndView mv){
		mv.setViewName("main/course/Course");
		return mv;
	}
	/**
	 * CRUD
	 * @return
	 */
	@RequestMapping("save")
	public Map<Object,Object> save(Course course){
		// 保存
		try {
			courseService.save(course);
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
		return super.setJsonMsgMap("rowData", course);
		
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
	public Map<Object,Object> list(CourseCriteria courseCriteria){
		PageBean pb = super.getPageBean(); // 获得分页对
		courseService.findByPage(pb,courseCriteria);
		// EasyUI框架响应结果都是JSON
		// JSON数据初始化，包含EasySSH Ajax响应信息和分页信息
		return super.setJsonPaginationMap(pb);
	}

	@RequestMapping("delete")
	public Map<Object,Object> delete(Course course){
		try {
			courseService.delete(course.getCourseId());
		} catch (Exception e) {
			e.printStackTrace();
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		return super.setJsonMsgMap();
	}
	
	@RequestMapping("update")
	public Map<Object,Object> update(Course course){
		try {
			courseService.update(course);
			super.setMsgKey("msg.updateSuccess");
		} catch (Exception e) {
			e.printStackTrace();
			super.setMsgKey("msg.updateFail");
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		
		return super.setJsonMsgMap();
	}
}
