package cn.easyproject.easyee.sm.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import cn.easyproject.easyee.sm.user.entity.User;


@RestController
public class BaseapiController {
	
	public static Gson gson=new Gson();
	
	@Resource
	RedisTemplate redisTemplate;

	public User Authentication(String token) {
	
		System.out.println(token);
		System.out.println(redisTemplate.opsForValue().get(token).toString());
		
		if(redisTemplate.opsForValue().get(token) != null) {
			return (User) gson.fromJson(redisTemplate.opsForValue().get(token).toString(), User.class);
		}
		
		return null;
		
	}

}
