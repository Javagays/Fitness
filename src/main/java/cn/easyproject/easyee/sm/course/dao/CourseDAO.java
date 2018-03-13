package cn.easyproject.easyee.sm.course.dao;

import java.io.Serializable;
import java.util.List;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.course.entity.Course;
/**
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
public interface CourseDAO {
	
	public void save(Course course);

	public void delete(Serializable courseId);

	public void update(Course course);

	public Course get(Integer courseId);

	@SuppressWarnings("rawtypes")
	public List pagination(PageBean pageBean);

	public List<Course> findAll();
	
	public int findMaxRow();
}
