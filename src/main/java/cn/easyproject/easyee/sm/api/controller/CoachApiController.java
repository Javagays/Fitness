package cn.easyproject.easyee.sm.api.controller;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.easyproject.easyee.sm.base.util.SerializeUtil;
import cn.easyproject.easyee.sm.base.util.StatusCode;
import cn.easyproject.easyee.sm.coach.entity.Coach;
import cn.easyproject.easyee.sm.coach.service.CoachService;

@RequestMapping("/api/CoachApi")
@RestController
public class CoachApiController extends BaseapiController{
	
	
	@Resource
	private CoachService coachService;

	@RequestMapping("findAll")
	public Map<Object,Object> findAll(String token){
		
		Map<Object, Object>  JsonMap = new HashMap<>();
		 List<Coach> coachs = null;
		try {
				
			     if(Authentication(token) != null) {
			    	 coachs =	coachService.selectAll();
					 JsonMap.put("data", coachs);
			     }else {
			    	 JsonMap.put("msg", "token失效");
			    	 JsonMap.put("code", 401);
			     }
		 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonMap;
	}
	
	@RequestMapping("get")
	public Map<Object,Object> get(Integer coachId,String token){
		Map<Object, Object>  JsonMap = new HashMap<>();
		Coach coach = null;
		try {
		     if(Authentication(token) != null) {
		    	  coach= coachService.get(coachId);
				 JsonMap.put("data", coach);
		     }else {
		    	 JsonMap.put("msg", "token失效");
		    	 JsonMap.put("code", 401);
		     }
		 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonMap;
	}
	

}
