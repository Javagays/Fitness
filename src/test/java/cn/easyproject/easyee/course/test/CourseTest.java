package cn.easyproject.easyee.course.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.Test;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.util.SpringUtil;
import cn.easyproject.easyee.sm.course.criteria.CourseCriteria;
import cn.easyproject.easyee.sm.course.entity.Course;
import cn.easyproject.easyee.sm.course.service.CourseService;

public class CourseTest {

	CourseService courseService = SpringUtil.getBean("courseService");
	
	@Test
	public void testSave() {
		courseService.save(new Course(1000, 1000, new Date(2018, 3, 2), new Time(6, 1, 1), new Time(7, 1, 1), "黄鹤楼"));
	}

	@Test
	public void testDelete() {
		courseService.delete(3);
	}

	@Test
	public void testUpdate() {
		courseService.update(new Course(1000, 1000, new Date(100, 3, 2), new Time(6, 1, 1), new Time(7, 1, 1), "黄鹤楼"));
	}

	@Test
	public void testGet() {
		Course course = courseService.get(2);
		System.out.println(course);
	}

	@Test
	public void testFindByPage() {
		PageBean<Course> pageBean = new PageBean<>();
		CourseCriteria courseCriteria = new CourseCriteria();
		courseService.findByPage(pageBean, courseCriteria);
		List<Course> data = pageBean.getData();
		for (Course course : data) {
			System.out.println(course);
		}
	}

	@Test
	public void testFindAll() {
		List<Course> data = courseService.findAll();
		for (Course course : data) {
			System.out.println(course);
		}
	}

}
