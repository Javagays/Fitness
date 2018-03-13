package cn.easyproject.easyee.sm.buyorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.service.BaseService;
import cn.easyproject.easyee.sm.buyorder.criteria.BuyOrderCriteria;
import cn.easyproject.easyee.sm.buyorder.dao.BuyOrderDao;
import cn.easyproject.easyee.sm.buyorder.entity.BuyOrder;
import cn.easyproject.easyee.sm.buyorder.service.BuyOrderService;

@Service("buyOrderService")
public class BuyOrderServiceImpl extends BaseService implements BuyOrderService{

	@Autowired
	BuyOrderDao buyOrderDao;
	
	@Override
	public List<BuyOrder> select() {
		
		return buyOrderDao.select();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<BuyOrder> findByPage(PageBean pageBean, BuyOrderCriteria BuyOrderCriteria) {
		pageBean.setFrom("Buy_Order b");     //这里的from指向数据库的目的地，一定要与数据库的表名一致，和大小写没关系
		pageBean.setSelect("b.order_id,b.user_id,b.card_name,b.card_type,b.card_price,b.card_course,"
				+ "b.card_date,b.card_site,b.card_salesman,b.card_face_amount,b.use_number,b.card_state");
		pageBean.setPrimaryTable("b");
		pageBean.setEasyCriteria(BuyOrderCriteria);
		return buyOrderDao.pagination(pageBean);
	}

	@Override
	public int findMaxRow() {
		return buyOrderDao.findMaxRow();
	}

}
