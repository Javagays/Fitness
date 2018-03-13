package cn.easyproject.easyee.ssh.buyorder;

import org.junit.Test;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.util.SpringUtil;
import cn.easyproject.easyee.sm.buyorder.criteria.BuyOrderCriteria;
import cn.easyproject.easyee.sm.buyorder.entity.BuyOrder;
import cn.easyproject.easyee.sm.buyorder.service.BuyOrderService;

public class BuyOrderTest {

	BuyOrderService buy = SpringUtil.getBean("buyOrderService");
	
	@Test
	public void test() {
//		BuyOrderService buy = SpringUtil.getBean("buyOrderService");
		buy.select();
	} 
	
	@Test
	public void test2() {
	//	ActivityService ac = SpringUtil.getBean("activityService");
		PageBean<BuyOrder> pageBean = new PageBean<>();
		BuyOrderCriteria  cf = new BuyOrderCriteria();
//		String acContent = null;
//		cc.setAcContent(acContent);
//		pageBean.setPageTotal(buy.findMaxRow());
		pageBean.setRowsPerPage(10);
		
		System.out.println(buy.findByPage(pageBean, cf));
	}
}
