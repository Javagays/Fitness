package cn.easyproject.easyee.sm.course.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.service.BaseService;
import cn.easyproject.easyee.sm.course.service.CourseService;
import cn.easyproject.easyee.sm.course.dao.CourseDAO;
import cn.easyproject.easyee.sm.course.entity.Course;
import cn.easyproject.easyee.sm.course.criteria.CourseCriteria;

/**
 * 业务实现类统一继承 BaseService 类
 * 
 *
 */
@Service("courseService")
public class CourseServiceImpl extends BaseService implements CourseService {

	@Resource
	CourseDAO courseDAO;
	
	@Override
	public void save(Course course) {
		courseDAO.save(course);
	}

	@Override
	public void delete(Serializable courseId) {
		courseDAO.delete(courseId);
	}

	@Override
	public void update(Course course) {
		courseDAO.update(course);
	}

	@Override
	public Course get(Integer courseId) {
		return courseDAO.get(courseId);
	}

	@SuppressWarnings({ "rawtypes"})
	@Override
	public void findByPage(PageBean pageBean, CourseCriteria courseCriteria) {
		pageBean.setFrom("course course");
		pageBean.setSelect("course.*");
		pageBean.setEasyCriteria(courseCriteria);
		// 按条件分页查询
		courseDAO.pagination(pageBean);
	}

	@Override
	public List<Course> findAll() {
		return courseDAO.findAll();
	}
}
