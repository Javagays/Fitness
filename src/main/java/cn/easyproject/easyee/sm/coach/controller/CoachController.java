package cn.easyproject.easyee.sm.coach.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.easyproject.easycommons.imageutils.EasyImageCompressionUtils;
import cn.easyproject.easycommons.objectutils.EasyObjectExtract;
import cn.easyproject.easyee.sm.base.controller.BaseController;
import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.util.StatusCode;
import cn.easyproject.easyee.sm.coach.criteria.CoachCriteria;
import cn.easyproject.easyee.sm.coach.entity.Coach;
import cn.easyproject.easyee.sm.coach.service.CoachService;
import cn.easyproject.easyee.sm.course.entity.Course;
import cn.easyproject.easyee.sm.course.service.CourseService;
import cn.easyproject.easyee.sm.hr.criteria.DeptCriteria;
import cn.easyproject.easyee.sm.hr.entity.Dept;

@RestController
@RequestMapping("Coach")
public class CoachController extends BaseController{
	
	@Resource
	private CoachService coachService;
	
	private CourseService courseService;
	
	/*
	 * 转向显示页面
	 */
	@RequestMapping("page")
	public ModelAndView page(ModelAndView mav) {
		mav.setViewName("main/coach/Coach");
		return mav;
	}
	
	/**
	 * CRUD
	 * @return
	 */
	@RequestMapping("add")
	public Map<Object,Object> save( MultipartFile myfile, Coach coach){
		
		
		// 保存
		try {
			SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 //如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解  
	         //如果想上传多个文件，那么 这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解  
	        //并且上传多个文件时，前台表单中的所有<input type="file"/>的name都应该是myfiles，否则参数里的myfiles无法获取到所有上传的文件  
	            if(myfile.isEmpty()){  
	                System.out.println("文件未上传");  
	            }else{  
//	                System.out.println("文件长度: " + myfile.getSize());  
//	                System.out.println("文件类型: " + myfile.getContentType());  
//	                System.out.println("文件名称: " + myfile.getName());  
//	                System.out.println("文件原名: " + myfile.getOriginalFilename());
	            	String myfileName = myfile.getOriginalFilename();
	                //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中  
	                String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");  
	                //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的 
	                File dir = new File(realPath);
	               
	       
	            	String ex="";
	        		if (myfileName.contains(".")) {
	        			ex=myfileName.substring(myfileName.lastIndexOf("."));
	        		}
	        		
	        		 String picName=UUID.randomUUID().toString().replace("-", "")+ex;
	        		File distPic=new File(dir,picName);
	        		while (distPic.exists()) {
	        			picName=UUID.randomUUID().toString().replace("-", "")+ex;
	        			distPic=new File(dir,picName);
	        		}
	        		
	        			//FileUtils.copyFile(pic, distPic);
	        		 FileUtils.copyInputStreamToFile(myfile.getInputStream(),distPic); 
	        			
	        			try {
	        				File smallPic = new File(dir, "small_" + picName);
	        				EasyImageCompressionUtils.compressPicByMaxWidthAndMaxHeight(distPic, smallPic, 150, 150);
	        			} catch (Exception e) {
	        				e.printStackTrace();
	        			}
	                
	                
	                System.out.println("========================================");  

	                
	                
	                
	                
	                coach.setCoachStarttime(sdf.parse(coach.getCoachStarttimeStr()));
	                coach.setCoachEndtime(sdf.parse(coach.getCoachEndtimeStr()));
	                coach.setCoachImageUrl("small_" + picName);
	                coachService.add(coach);
	             // 处理成功 消息
	    			super.setMsgKey("msg.addSuccess");
	            }  
		} catch (Exception e) {
			e.printStackTrace();
			super.setMsgKey("msg.addFail");
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
		return super.setJsonMsgMap("rowData",coach);
		
		// 如果需要刷新，跳转到最后一页
//		int page = deptService.findMaxPage(rows);
//		return super.setJsonMsgMap("rowData", dept, "page", page);
	}
	
	/**
	 * 分页
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("list")
	public Map<Object,Object> list(CoachCriteria cc){
		PageBean pb = super.getPageBean(); // 获得分页对
		coachService.pagination(pb, cc);
		// EasyUI框架响应结果都是JSON
		// JSON数据初始化，包含EasySSH Ajax响应信息和分页信息
		List<Map> list = EasyObjectExtract.extract(pb.getData(),"coachId", "coachName","coachType","coachStatus","coachImageUrl");
		pb.setData(list);
		
	
		Map m=super.setJsonPaginationMap(pb);

		return m;
	}

	
	@RequestMapping("delete")
	public Map<Object,Object> delete(String[] coachId){
		try {
			coachService.delete(coachId);
		} catch (Exception e) {
			e.printStackTrace();
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		return super.setJsonMsgMap();
	}
	
	@RequestMapping("update")
	public Map<Object,Object> update(Coach coach){
		try {
			coachService.update(coach);
			super.setMsgKey("msg.updateSuccess");
		} catch (Exception e) {
			e.printStackTrace();
			super.setMsgKey("msg.updateFail");
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		
		return super.setJsonMsgMap();
	}
	
	@RequestMapping("allCourse")
	public Object  allCourse(){
		List<Course> courses =	courseService.findAll();
		System.out.println(courses);
		return  courses;
	}

}
