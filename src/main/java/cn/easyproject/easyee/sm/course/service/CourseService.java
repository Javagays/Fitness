package cn.easyproject.easyee.sm.course.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.course.criteria.CourseCriteria;
import cn.easyproject.easyee.sm.course.entity.Course;

@Transactional
public interface CourseService {
	public void save(Course course);
	public void delete(Serializable courseId);
	public void update(Course course);
	@Transactional(readOnly=true)
	public Course get(Integer courseId);

	@SuppressWarnings("rawtypes")
	@Transactional(readOnly=true)
	public void findByPage(PageBean pageBean, CourseCriteria courseCriteria);
	
	@Transactional(readOnly=true)
	public List<Course> findAll();
}
