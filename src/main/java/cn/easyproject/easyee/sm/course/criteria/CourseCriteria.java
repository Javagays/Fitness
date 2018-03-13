package cn.easyproject.easyee.sm.course.criteria;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.easyproject.easyee.sm.base.pagination.EasyCriteria;
import cn.easyproject.easyee.sm.base.util.StringUtils;


/**
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
public class CourseCriteria extends EasyCriteria implements Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	/*
 	 * 1. 条件属性
 	 */
	
	private Integer courseId;
	private Integer coachId;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date courseDate;
	private String courseName;
	private Time courseStart;
	private Time courseEnd;
	
	 /*
 	 * 2. 构造方法
 	 */
	public CourseCriteria() {
		super();
	}





	public CourseCriteria(Integer courseId, Integer coachId, Date courseDate, String courseName, Time courseStart,
			Time courseEnd) {
		super();
		this.courseId = courseId;
		this.coachId = coachId;
		this.courseDate = courseDate;
		this.courseName = courseName;
		this.courseStart = courseStart;
		this.courseEnd = courseEnd;
	}


	public CourseCriteria(Integer coachId, Date courseDate, String courseName) {
		super();
		this.coachId = coachId;
		this.courseDate = courseDate;
		this.courseName = courseName;
	}





	/*
 	 * 3. 条件生成抽象方法实现
 	 */
	public String getCondition() {
		values.clear(); //清除条件数据
		StringBuffer condition = new StringBuffer();
/*		if (StringUtils.isNotNullAndEmpty(this.getCourseId())) {
			condition.append(" and course.course_id= #{courseId}");
			values.put("courseId", this.getCourseId());
		}*/
		if (StringUtils.isNotNullAndEmpty(this.getCoachId())) {
			condition.append(" and course.coach_id = #{coachId}");
			values.put("coachId",  this.getCoachId());
		}
		if (StringUtils.isNotNullAndEmpty(this.getCourseName())) {
			condition.append(" and course.course_name = #{courseName}");
			values.put("courseName", this.getCourseName());
		}
		if (StringUtils.isNotNullAndEmpty(this.getCourseDate())) {
			condition.append(" and course.course_date >= '"+this.getCourseDate()+" 00:00:00' ");
			condition.append(" and course.course_date <= '"+this.getCourseDate()+" 23:59:59' ");
			values.put("courseDate",this.getCourseDate());
		}
		return condition.toString();
	}
	 /*
 	 * 4. Setters & Getters...
 	 */



	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getCoachId() {
		return coachId;
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}

	public Date getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(Date courseDate) {
		this.courseDate = courseDate;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Time getCourseStart() {
		return courseStart;
	}

	public void setCourseStart(Time courseStart) {
		this.courseStart = courseStart;
	}


	public Time getCourseEnd() {
		return courseEnd;
	}

	public void setCourseEnd(Time courseEnd) {
		this.courseEnd = courseEnd;
	}

	
}