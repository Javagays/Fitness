package cn.easyproject.easyee.sm.buyorder.dao;

import java.util.List;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.buyorder.entity.BuyOrder;
import cn.easyproject.easyee.sm.hd.entity.Activity;

public interface BuyOrderDao {

	public List<BuyOrder> select();
	
	@SuppressWarnings("rawtypes")   	//意思是忽略警告
	public List<BuyOrder> pagination(PageBean pageBean);
	
	public int findMaxRow();
}
