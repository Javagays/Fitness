package cn.easyproject.easyee.sm.hd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.hd.criteria.ActivityCriteria;
import cn.easyproject.easyee.sm.hd.dao.ActivityDao;
import cn.easyproject.easyee.sm.hd.entity.Activity;
import cn.easyproject.easyee.sm.hd.service.ActivityService;
import cn.easyproject.easyee.sm.hr.criteria.EmpCriteria;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService{

	@Resource
	ActivityDao activitydao;
	
	@Override
	public void add(Activity activity) {
		activitydao.add(activity);
	}

	@Override
	public void deleteById(int ids) {
		activitydao.deleteById(ids);
	}


	@Override
	public int findActivityCountByActivityId(Integer activityId) {
		return activitydao.findActivityCountByActivityId(activityId);
	}

	@Override
	public List<Activity> findAll() {
		// TODO Auto-generated method stub
		return activitydao.findAll();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Activity> findByPage(PageBean pageBean, ActivityCriteria ActivityCriteria) {
		pageBean.setFrom("Activity a");
		pageBean.setSelect("a.activity_id,a.ac_content");
		pageBean.setPrimaryTable("a");
		pageBean.setEasyCriteria(ActivityCriteria);
		return activitydao.pagination(pageBean);
		
	}

	@Override
	public int findMaxRow() {
		// TODO Auto-generated method stub
		return activitydao.findMaxRow();
	}

	@Override
	public void update(Activity activity) {
		activitydao.update(activity);
	}

	@Override
	public List<Activity> get(int ids) {
		
		return activitydao.get(ids);
	}

	
}
