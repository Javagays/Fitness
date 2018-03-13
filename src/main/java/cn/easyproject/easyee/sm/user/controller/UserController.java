package cn.easyproject.easyee.sm.user.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import cn.easyproject.easyee.sm.api.controller.BaseapiController;
import cn.easyproject.easyee.sm.base.controller.BaseController;
import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.util.SerializeUtil;
import cn.easyproject.easyee.sm.base.util.StatusCode;
import cn.easyproject.easyee.sm.user.criteria.UserCriteria;
import cn.easyproject.easyee.sm.user.entity.User;
import cn.easyproject.easyee.sm.user.service.UserService;


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
@RequestMapping("/api/User")
public class UserController {
	public static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private UserService userService;
	
	@Resource
	RedisTemplate redisTemplate;
	
	
	
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("getClarifyCode")
	public Map<Object,Object> getClarifyCode(String user_phone) {
		
	  
	  Map<Object,Object> jsonMap = new HashMap();
	  	
	
				
				/*
				 * 手机号码
				 * 图形验证码
				 * 短信验证码
				 * 
				 * 后端：手机号码，
				 * 
				 * --- 登录手机验证码获得接口
				 * 
				 * 1. 客户发送手机号码
				 * 2. 后端生成短信验证码
				 * 3. 将【手机号码:验证码】存入 redis，设置过期时间 5 min 
				 * -
				 * 
				 * --- 登录
				 * 
				 * 1.从客户端接收，手机号码，短信验证码
				 * 2. redis 【手机号码:验证码】 -- 删除
				 * 3.redis 【token:userinfo】
				 * 
				 * 
				 * -- api 调
				 * 1.token
				 * 2. 
				 * 				 
				 */
	  			Random random = new Random();
	  			String sRand = "";
	  			for(int i=0;i<4;i++) {
	  				String rand = String.valueOf(random.nextInt(10));
	  				sRand += rand;
	  			}
	  				
				String clarifyCode = sRand;
//				SerializeUtil.serialize(clarifyCode);
				redisTemplate.opsForValue().set(user_phone, clarifyCode,180, TimeUnit.SECONDS );
				//设置过期时间5分钟
				//redisTemplate
				
				
				//返回短信验证码
				jsonMap.put("data", null);
				
				System.out.println(clarifyCode);
		
				return jsonMap;
	}
	
		@RequestMapping("login")
		public  Map<Object,Object> login (String user_phone,String clarifyCode){
		 Map<Object,Object> jsonMap = new HashMap();
		 
		 System.out.println(user_phone);
		 System.out.println(clarifyCode);
		 
		 System.out.println(redisTemplate.opsForValue().get(user_phone));
		if(clarifyCode !=null && clarifyCode.equals(redisTemplate.opsForValue().get(user_phone))) {
			String token  = UUID.randomUUID().toString();
			
			while(redisTemplate.opsForValue().get(token) != null) {
				//已经存在token，生成不同的token
				token  = UUID.randomUUID().toString();
			}
			User u = userService.get(user_phone);
//			SerializeUtil.serialize(u);
			System.out.println(u);
			System.out.println(BaseapiController.gson.toJson(u));
			redisTemplate.opsForValue().set(token,BaseapiController.gson.toJson(u));
			//redis 【手机号码:验证码】 -- 删除
			redisTemplate.delete(user_phone);
			jsonMap.put("data", token);
			return jsonMap;
		}
		return jsonMap;
	}
	
	
}
