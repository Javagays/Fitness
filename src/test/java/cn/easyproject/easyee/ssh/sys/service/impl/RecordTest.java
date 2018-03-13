package cn.easyproject.easyee.ssh.sys.service.impl;

import org.junit.Test;

import cn.easyproject.easyee.sm.base.util.SpringUtil;
import cn.easyproject.easyee.sm.card.service.RecordsConsumptionService;

public class RecordTest {

	RecordsConsumptionService rc = SpringUtil.getBean("recordsConsumptionService");
	
	@Test
	public void test() {
		System.out.println(rc.findAll());
		System.out.println("---------------------------");
	}
	
	@Test
	public void deletetest() {
		System.out.println("------delete   success-----------------");
	}
	

}
