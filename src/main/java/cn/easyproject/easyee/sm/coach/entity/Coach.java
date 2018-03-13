package cn.easyproject.easyee.sm.coach.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Coach implements Serializable{
	/*
	   Coach_Id             Integer not null auto_increment comment '教练ID，关联课程表和预约订单表以及消费记录表',
	   Coach_name           varchar(20) not null comment '教练姓名',
	   Coach_Content        varchar(255) not null comment '教练简介',
	   Coach_Phoneno        varchar(64) not null comment '手机号',
	   Coach_motto          varchar(64) comment '座右铭',
	   Coach_type           varchar(64) not null comment '格斗，增肌减脂',
	   Coach_experience     varchar(10) comment '年限',
	   Coach_imageURL       varchar(64) not null comment '教练头像',
	   Coach_status         Integer not null comment '隐藏字段(0是教练没空，1教练有空',
	 
	   Coach_starttime    datetime comment '教练开始课时间',
	   Coach_endtime    datetime comment '教练结束课时间',  
	   */
	   
	private Integer coachId;
	private String coachName;
	private String coachContent;
	private String coachPhoneno ;
	private String coachMotto;
	private String coachType ;
	private String coachExperience;
	private String coachImageUrl;
	private Integer coachStatus;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date coachStarttime;
	private String coachStarttimeStr;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date coachEndtime;
	private String coachEndtimeStr;
	
	
	public Coach() {
		super();
	}
	
	

	public Coach(String coachName, String coachContent, String coachPhoneno, String coachMotto, String coachType,
			String coachExperience, String coachImageUrl, Integer coachStatus, Date coachStarttime, Date coachEndtime) {
		super();
		this.coachName = coachName;
		this.coachContent = coachContent;
		this.coachPhoneno = coachPhoneno;
		this.coachMotto = coachMotto;
		this.coachType = coachType;
		this.coachExperience = coachExperience;
		this.coachImageUrl = coachImageUrl;
		this.coachStatus = coachStatus;
		this.coachStarttime = coachStarttime;
		this.coachEndtime = coachEndtime;
	}



	public Coach(Integer coachId, String coachName, String coachContent, String coachPhoneno, String coachMotto,
			String coachType, String coachExperience, String coachImageUrl, Integer coachStatus, Date coachStarttime,
			Date coachEndtime) {
		super();
		this.coachId = coachId;
		this.coachName = coachName;
		this.coachContent = coachContent;
		this.coachPhoneno = coachPhoneno;
		this.coachMotto = coachMotto;
		this.coachType = coachType;
		this.coachExperience = coachExperience;
		this.coachImageUrl = coachImageUrl;
		this.coachStatus = coachStatus;
		this.coachStarttime = coachStarttime;
		this.coachEndtime = coachEndtime;
	}

	
	public String getCoachStarttimeStr() {
		return coachStarttimeStr;
	}



	public void setCoachStarttimeStr(String coachStarttimeStr) {
		this.coachStarttimeStr = coachStarttimeStr;
	}



	public String getCoachEndtimeStr() {
		return coachEndtimeStr;
	}



	public void setCoachEndtimeStr(String coachEndtimeStr) {
		this.coachEndtimeStr = coachEndtimeStr;
	}



	public Integer getCoachId() {
		return coachId;
	}


	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}


	public String getCoachName() {
		return coachName;
	}


	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}


	public String getCoachContent() {
		return coachContent;
	}


	public void setCoachContent(String coachContent) {
		this.coachContent = coachContent;
	}


	public String getCoachPhoneno() {
		return coachPhoneno;
	}


	public void setCoachPhoneno(String coachPhoneno) {
		this.coachPhoneno = coachPhoneno;
	}


	public String getCoachMotto() {
		return coachMotto;
	}


	public void setCoachMotto(String coachMotto) {
		this.coachMotto = coachMotto;
	}


	public String getCoachType() {
		return coachType;
	}


	public void setCoachType(String coachType) {
		this.coachType = coachType;
	}


	public String getCoachExperience() {
		return coachExperience;
	}


	public void setCoachExperience(String coachExperience) {
		this.coachExperience = coachExperience;
	}


	public String getCoachImageUrl() {
		return coachImageUrl;
	}


	public void setCoachImageUrl(String coachImageUrl) {
		this.coachImageUrl = coachImageUrl;
	}


	public Integer getCoachStatus() {
		return coachStatus;
	}


	public void setCoachStatus(Integer coachStatus) {
		this.coachStatus = coachStatus;
	}


	public Date getCoachStarttime() {
		return coachStarttime;
	}


	public void setCoachStarttime(Date coachStarttime) {
		this.coachStarttime = coachStarttime;
	}


	public Date getCoachEndtime() {
		return coachEndtime;
	}


	public void setCoachEndtime(Date coachEndtime) {
		this.coachEndtime = coachEndtime;
	}



	@Override
	public String toString() {
		return "Coach [coachId=" + coachId + ", coachName=" + coachName + ", coachContent=" + coachContent
				+ ", coachPhoneno=" + coachPhoneno + ", coachMotto=" + coachMotto + ", coachType=" + coachType
				+ ", coachExperience=" + coachExperience + ", coachImageUrl=" + coachImageUrl + ", coachStatus="
				+ coachStatus + ", coachStarttime=" + coachStarttime + ", coachEndtime=" + coachEndtime + "]";
	}
	
	
	
	
}
