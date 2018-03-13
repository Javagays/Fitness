package cn.easyproject.easyee.ssh.sys.service.impl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.util.SpringUtil;
import cn.easyproject.easyee.sm.coach.criteria.CoachCriteria;
import cn.easyproject.easyee.sm.coach.entity.Coach;
import cn.easyproject.easyee.sm.coach.service.CoachService;
import cn.easyproject.easyee.sm.coach.service.impl.CoachServiceImpl;

public class CoachServiceTest {
	
	 CoachService coachService = SpringUtil.getBean("coachService");

	@Test
	public void test() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		
		 Coach coach = new Coach("Dekongzhen", "专业二级跑步教练/国家一级运动员", "1345678978", "Fitness", "跑步损伤康复，增肌减脂", "2年", "images/liyazhou.jpg",1,format.parse("2017-03-08"), format.parse("2018-02-03"));
		coachService.add(coach);
		
	}
	
	@Test
	public void test1() throws ParseException {
		
		System.out.println(coachService.selectAll());
		
	}
	
	@Test
	public void test2() throws ParseException {
		Coach coach = new Coach();
		coach.setCoachName("hanzhirui");
		coach.setCoachId(4);
		coachService.update(coach);
		
		
	}
	
	@Test
	public void test3() throws ParseException {
		coachService.delete(4);
	}
	
	@Test
	public void test4() throws ParseException {
		System.out.println(coachService.get(1));;
	}
	
	@Test
	public void test5() throws ParseException {
		System.out.println(coachService.findMaxRow());;
	}
	
	@Test
	public void test6() throws ParseException {
		PageBean<Coach>  pageBean = new PageBean<>();
		CoachCriteria   cc = new CoachCriteria();
		cc.setCoachName("Gavin");
		pageBean.setPageTotal(coachService.findMaxRow());
		pageBean.setRowsPerPage(2);
		
		System.out.println(coachService.pagination(pageBean, cc));
	}

}
