package cn.easyproject.easyee.ssh.hd.activityservice.impl;

import org.junit.Test;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.util.SpringUtil;
import cn.easyproject.easyee.sm.coach.criteria.CoachCriteria;
import cn.easyproject.easyee.sm.coach.entity.Coach;
import cn.easyproject.easyee.sm.hd.criteria.ActivityCriteria;
import cn.easyproject.easyee.sm.hd.entity.Activity;
import cn.easyproject.easyee.sm.hd.service.ActivityService;

public class ActivityTest {

	@Test
	public void test1() {
		ActivityService ac = SpringUtil.getBean("activityService");
		System.out.println(ac);
		Activity aa = new Activity();
		//aa.setActivityId(9);
		aa.setAcContent("每逢佳节盘三斤，逆袭健身让你轻");
		ac.add(aa);
		System.out.println(aa);
	}
	
	@Test
	public void test2() {
		ActivityService ac = SpringUtil.getBean("activityService");
		System.out.println(ac);
		ac.deleteById(5);
	}
	
	@Test
	public void test3() {
		ActivityService ac = SpringUtil.getBean("activityService");
		ac.get(1);
	}
	
	@Test
	public void test5() {
		ActivityService ac = SpringUtil.getBean("activityService");
		ac.findAll();
	}
	
	@Test
	public void test6() {
		ActivityService ac = SpringUtil.getBean("activityService");
		PageBean<Activity> pageBean = new PageBean<>();
		ActivityCriteria cc = new ActivityCriteria();
//		String acContent = null;
//		cc.setAcContent(acContent);
		pageBean.setPageTotal(ac.findMaxRow());
		pageBean.setRowsPerPage(4);
		
		System.out.println(ac.findByPage(pageBean, cc));
	}
	
	@Test
	public void test7() {
		ActivityService ac = SpringUtil.getBean("activityService");
		ac.findActivityCountByActivityId(2);
	}
	
	@Test
	public void test8() {
		ActivityService ac = SpringUtil.getBean("activityService");
		System.out.println(ac.findAll());;
	}
	
	@Test
	public void test9() {
		ActivityService ac = SpringUtil.getBean("activityService");
		Activity aa = new Activity();
		aa.setActivityId(25);
		aa.setAcContent("你的老妖还好吗？");
		ac.update(aa);
	}
}
