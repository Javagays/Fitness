package cn.easyproject.easyee.sm.buyorder.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.buyorder.criteria.BuyOrderCriteria;
import cn.easyproject.easyee.sm.buyorder.entity.BuyOrder;

@Transactional
public interface BuyOrderService {

	public List<BuyOrder> select();
	
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly=true)
	public List<BuyOrder> findByPage(PageBean pageBean,BuyOrderCriteria BuyOrderCriteria);
	
	public int findMaxRow();
}
