package cn.easyproject.easyee.sm.card.service;

import java.util.List;

import cn.easyproject.easyee.sm.card.entity.RecordsConsumption;

public interface RecordsConsumptionService {

	public List<RecordsConsumption> findAll();

	public void delete(int recordId);

}
