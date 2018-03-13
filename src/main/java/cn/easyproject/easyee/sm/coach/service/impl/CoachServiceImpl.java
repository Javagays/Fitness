package cn.easyproject.easyee.sm.coach.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.service.BaseService;
import cn.easyproject.easyee.sm.coach.criteria.CoachCriteria;
import cn.easyproject.easyee.sm.coach.dao.CoachDao;
import cn.easyproject.easyee.sm.coach.entity.Coach;
import cn.easyproject.easyee.sm.coach.service.CoachService;

@Service("coachService")
public class CoachServiceImpl extends BaseService implements CoachService {
	
	@Resource
	private CoachDao coachDao;

	@Override
	public List<Coach> selectAll() {
		
		return coachDao.selectAll();
	}

	@Override
	public void add(Coach coach) {
		coachDao.add(coach);

	}

	@Override
	public void delete(Serializable coachId) {
		coachDao.delete(coachId);

	}
	
	@Override
	public void delete(String[] coachIds) {
		coachDao.deleteByIds(coachIds);
	}


	@Override
	public void update(Coach coach) {
		coachDao.update(coach);

	}

	@Override
	public Coach get(Integer CoachId) {
		
		return coachDao.get(CoachId);
	}

	@Override
	public List pagination(PageBean pageBean,CoachCriteria cc) {
		pageBean.setFrom("Coach");
		pageBean.setSelect("Coach_Id, Coach_Name,Coach_Type,Coach_Experience,Coach_status,Coach_imageURL");
		pageBean.setEasyCriteria(cc);
		
		return coachDao.pagination(pageBean);
	}

	@Override
	public int findMaxRow() {
	    return coachDao.findMaxRow();
	}

	
}
