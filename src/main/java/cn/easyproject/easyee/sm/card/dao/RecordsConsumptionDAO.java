package cn.easyproject.easyee.sm.card.dao;

import java.util.List;

import cn.easyproject.easyee.sm.card.entity.RecordsConsumption;

public interface RecordsConsumptionDAO {

	public List<RecordsConsumption> findAll();

	public void delete(int recordId);
	
}
