package cn.easyproject.easyee.sm.coach.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.coach.criteria.CoachCriteria;
import cn.easyproject.easyee.sm.coach.entity.Coach;

@Transactional
public interface CoachService {
	
	public List<Coach> selectAll();
	
	public void add(Coach coach);
	
	public void delete(Serializable coachId);
	
	public void delete(String[] coachIds);
	
	public void update(Coach coach);
	
   public Coach get(Integer CoachId);
	
	/**
	 * Pagination
	 * @param pageBean PageBean
	 * @param empCriteria Criteria
	 */
	public List pagination(PageBean pageBean,CoachCriteria cc);
	
	public int findMaxRow();

}
