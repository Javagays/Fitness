package cn.easyproject.easyee.sm.coach.dao;

import java.io.Serializable;
import java.util.List;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.coach.entity.Coach;
import cn.easyproject.easyee.sm.hr.entity.Emp;

public interface CoachDao {
	
	
	public List<Coach> selectAll();
	
	public void add(Coach coach);
	
	public void delete(Serializable CoachId);
	
	public void deleteByIds(String[] coachIds);
	
	public void update(Coach coach);
	
	public Coach get(Integer CoachId);
	
	/**
	 * Pagination
	 * @param pageBean PageBean
	 * @param empCriteria Criteria
	 */
	public List pagination(PageBean pageBean);
	
	public int findMaxRow();

}
