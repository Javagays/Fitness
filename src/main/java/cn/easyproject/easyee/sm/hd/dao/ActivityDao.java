package cn.easyproject.easyee.sm.hd.dao;

import java.util.List;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.hd.entity.Activity;

public interface ActivityDao {

	public void add(Activity activity);
	
	public void deleteById(int ids);
	
	public List<Activity> get(int ids);
	
	public void update(Activity activity);
	
	public int findActivityCountByActivityId(Integer activityId);
	
	public List<Activity> findAll();
	
	@SuppressWarnings("rawtypes")   	//意思是忽略警告
	public List<Activity> pagination(PageBean pageBean);
	
	public int findMaxRow();
}
