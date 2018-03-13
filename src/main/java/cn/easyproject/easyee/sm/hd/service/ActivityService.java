	package cn.easyproject.easyee.sm.hd.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.hd.criteria.ActivityCriteria;
import cn.easyproject.easyee.sm.hd.entity.Activity;
@Transactional
public interface ActivityService {

    public void add(Activity activity);
	
	public void deleteById(int ids);
	
	public List<Activity> get(int ids);
	
	public void update(Activity activity);

	public int findActivityCountByActivityId(Integer activityId);
	
	public List<Activity> findAll();
	
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly=true)
	public List<Activity> findByPage(PageBean pageBean,ActivityCriteria ActivityCriteria);
	
	public int findMaxRow();
}
