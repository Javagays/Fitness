package cn.easyproject.easyee.sm.card.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import cn.easyproject.easyee.sm.base.service.BaseService;
import cn.easyproject.easyee.sm.card.dao.RecordsConsumptionDAO;
import cn.easyproject.easyee.sm.card.entity.RecordsConsumption;
import cn.easyproject.easyee.sm.card.service.RecordsConsumptionService;

@Service("recordsConsumptionService")
@Lazy(true)
public class RecordsConsumptionServiceImpl extends BaseService implements RecordsConsumptionService{

	@Resource
	RecordsConsumptionDAO rcDAO;
	
	/*显示订单信息列表*/
	@Override
	public List<RecordsConsumption> findAll() {
		return rcDAO.findAll();
	}

	/*删除订单信息列表*/
	@Override
	public void delete(int recordId) {
		rcDAO.delete(recordId);
	}

}
