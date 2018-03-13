package cn.easyproject.easyee.sm.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.hd.criteria.ActivityCriteria;
import cn.easyproject.easyee.sm.hd.entity.Activity;
import cn.easyproject.easyee.sm.hd.service.ActivityService;

@RestController
@RequestMapping("/api/Activity")
public class ActivityApiController {

	@Resource
	private ActivityService activityService;
	
	
	
	@RequestMapping("select")
	public Map<Object,Object> select(Integer ids){
		
		Map<Object, Object> m = new HashMap<>();
		try {
		//	Map map = new HashMap<>();
			System.out.println(ids);
		List<Activity> list= activityService.get(ids);
		
		m.put("code", 200);
		m.put("msg", "请求处理成功");
		m.put("data", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("list")
	public Map<Object,Object> list(PageBean pb, ActivityCriteria cc){
		
		Map<Object, Object> m = new HashMap<>();
	//	PageBean pb1 = super.getPageBean(); // 获得分页对
		List<Activity> list = activityService.findByPage(pb, cc);
		m.put("code", 200);
		m.put("msg", "服务请求成功");
		m.put("data", list);
			
		System.out.println(m);
		return m;
	}
}
