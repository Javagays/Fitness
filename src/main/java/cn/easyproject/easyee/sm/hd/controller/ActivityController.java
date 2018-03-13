package cn.easyproject.easyee.sm.hd.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.easyproject.easycommons.objectutils.EasyObjectExtract;
import cn.easyproject.easyee.sm.base.controller.BaseController;
import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.util.StatusCode;
import cn.easyproject.easyee.sm.coach.criteria.CoachCriteria;
import cn.easyproject.easyee.sm.hd.criteria.ActivityCriteria;
import cn.easyproject.easyee.sm.hd.entity.Activity;
import cn.easyproject.easyee.sm.hd.service.ActivityService;
import cn.easyproject.easyee.sm.hr.criteria.EmpCriteria;

@RestController
@RequestMapping("Activity")
public class ActivityController extends BaseController{

	@Resource
	private ActivityService activityservice;
	
	@RequestMapping("page")
	public ModelAndView page(ModelAndView mv) {
		mv.setViewName("main/hd/Activity");
		return mv;
	}
	
	@RequestMapping("add")
	public Map<Object,Object> add(Activity activity){
		try {
			activityservice.add(activity);
			//处理成功，消息
			super.setMsgKey("msg.saveSuccess");
		} catch (Exception e) {
			e.printStackTrace();
			super.setMsgKey("msg.saveFail");
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		return super.setJsonMsgMap("rowData",activity);
	}
//	
//	@RequestMapping("delete")
//	public Map<Object,Object> delete(Activity activity){
//		try {
//			if(activityservice.findActivityCountByActivityId(activity.getActivityId())==0){
//				activityservice.deleteById(activity.getActivityId());
//			}else{
//				//super.setMsgKey("hd.ActivityController.activityExists");
//				super.setStatusCode(StatusCode.ERROR);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			super.setStatusCode(StatusCode.ERROR); //默认为OK
//		}
//		return super.setJsonMsgMap();
//	}
	
	@RequestMapping("delete")
	public Map<Object, Object> delete(Activity activity) {
		// try {
		// empService.delete(emp.getEmpno());
		// } catch (Exception e) {
		// e.printStackTrace();
		// super.setStatusCode(StatusCode.ERROR); //默认为OK
		// }
		// super.setJsonMsgMap();
		// 批量删除
		try {
			activityservice.deleteById(activity.getActivityId());
			// sysUserService.delete(sysUser.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			// 出错输出 500 响应
			// ServletControllerContext.getResponse().setStatus(500);
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		return super.setJsonMsgMap();
	}
	@RequestMapping("update")
	public Map<Object,Object> update(Activity activity){
		try {
			activityservice.update(activity);
			super.setMsgKey("msg.updateSuccess");
		} catch (Exception e) {
			e.printStackTrace();
			super.setMsgKey("msg.updateFail");
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		
		return super.setJsonMsgMap();
	}
	
	@RequestMapping("select")
	public Map<Object,Object> select(int ids){
		try {
			activityservice.get(ids);
			super.setMsgKey("msg.selectSuccess");
		} catch (Exception e) {
			e.printStackTrace();
			super.setMsgKey("msg.selectFail");
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		
		return super.setJsonMsgMap();
	}
	
	
	@RequestMapping("findAll")
	public Map<Object,Object> findAll(){
		try {
			activityservice.findAll();
			
			
			super.setMsgKey("msg.findSuccess");
		} catch (Exception e) {
			e.printStackTrace();
			super.setMsgKey("msg.findFail");
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		
		return super.setJsonMsgMap();
	}
	

	/**
	 * 分页
	 * @param pageBean 
	 * @param ActivityCriteria 
	 * 
	 * @return
	 */
//	
//	@SuppressWarnings("rawtypes")
//	@RequestMapping("list")
//	public Map<Object, Object> pagination(PageBean pageBean, ActivityCriteria ActivityCriteria) {
//		PageBean pb = super.getPageBean(); // 获得分页对
//
//		activityservice.findByPage(pb, ActivityCriteria);
//		// EasyUI框架响应结果都是JSON
//		// JSON数据初始化，包含EasySSH Ajax响应信息和分页信息
//		// 使用抽取的集合作为分页数据
//		 List<Map> list = EasyObjectExtract.extract(pb.getData(),
//		// "empno","ename",
//		// "job", "dept.dname#dname");
//		// // 使用抽取的集合作为分页数据
//		 pb.setData(list);
//
//		return super.setJsonPaginationMap(pb,"allActivity",activityservice.findAll());
//	}
//	

	/**
	 * 分页
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("list")
	public Map<Object,Object> list(PageBean pb, ActivityCriteria cc){
		PageBean pb1 = super.getPageBean(); // 获得分页对
		activityservice.findByPage(pb1, cc);
		// EasyUI框架响应结果都是JSON
		// JSON数据初始化，包含EasySSH Ajax响应信息和分页信息
		List<Map> list = EasyObjectExtract.extract(pb1.getData(), "activityId","acContent");
		pb1.setData(list);
		
	
		Map m=super.setJsonPaginationMap(pb1);

		return m;
	}

	/**
	 * 查询所有部门，以JSON返回，添加修改用户时，下拉列表使用
	 * 
	 * @return
	 */
	@RequestMapping("allActivity")
	public Object allActivity() {
		return activityservice.findAll();
	}

}
