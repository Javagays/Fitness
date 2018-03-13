package cn.easyproject.easyee.user.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Test;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.util.SpringUtil;
import cn.easyproject.easyee.sm.user.criteria.UserCriteria;
import cn.easyproject.easyee.sm.user.entity.User;
import cn.easyproject.easyee.sm.user.service.UserService;

public class UserTest {

	
	UserService userService = SpringUtil.getBean("userService");
	@Test
	public void testSave() {
//		userService.save(new User("刘", "123123", 1, "湖北", "深圳", "广州", new Date(10, 11, 1), "1010", new Date(1111)));
	}

	@Test
	public void testDelete() {
		userService.delete(2);
		List<User> data = userService.findAll();
		System.out.println(data);
	}

	@Test
	public void testUpdate() {
//		User user = new User("刘", "123123", 100, "湖北", "深圳", "广州", new Date(10, 11, 1), "1010", new Date(1111));
//		user.setUser_id(2);
//		userService.update(user);
//		List<User> data = userService.findAll();
//		System.out.println(data);
	}
	
	@Test
	public void testGet() {
		
		System.out.println(userService.get("13912345678"));
	}
	

	@Test
	public void testFindByPage() {
		PageBean<User> pageBean = new PageBean<>();
		UserCriteria userCriteria = new UserCriteria();
		userService.findByPage(pageBean, userCriteria);
		List<User> data = pageBean.getData();
		System.out.println(data);
	}

	@Test
	public void testFindAll() {
		List<User> data = userService.findAll();
		System.out.println(data);
	}

}
