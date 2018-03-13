package cn.easyproject.easyee.sm.course.entity;

import java.sql.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
public class Course implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer courseId;
	private Integer coachId;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date courseDate;
	@JsonFormat(pattern="HH:mm:ss",timezone="GMT+8")
	private Time courseStart;
	@JsonFormat(pattern="HH:mm:ss",timezone="GMT+8")
	private Time courseEnd;
	private String courseName;
	

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(Integer courseId, Integer coachId, Date courseDate, Time courseStart, Time courseEnd,
			String courseName) {
		super();
		this.courseId = courseId;
		this.coachId = coachId;
		this.courseDate = courseDate;
		this.courseStart = courseStart;
		this.courseEnd = courseEnd;
		this.courseName = courseName;
	}

	public Course(Integer coachId, Date courseDate, Time courseStart, Time courseEnd, String courseName) {
		super();
		this.coachId = coachId;
		this.courseDate = courseDate;
		this.courseStart = courseStart;
		this.courseEnd = courseEnd;
		this.courseName = courseName;
	}

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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", coachId=" + coachId + ", courseDate=" + courseDate + ", courseStart="
				+ courseStart + ", courseEnd=" + courseEnd + ", courseName=" + courseName + "]";
	}


}