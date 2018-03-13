package cn.easyproject.easyee.sm.coach.criteria;

import cn.easyproject.easyee.sm.base.pagination.EasyCriteria;
import cn.easyproject.easyee.sm.base.util.StringUtils;

public class CoachCriteria extends EasyCriteria{
	
	
	private Integer coachId;
	private String coachName;
	private String coachType ;
	private String coachExperience;
	private Integer coachStatus;
	
	

	public CoachCriteria() {
		super();
	}


	/*
 	 * 3. 条件生成抽象方法实现
 	 */
	@Override
	public String getCondition() {
		values.clear(); //清除条件数据
		StringBuffer condition = new StringBuffer();
		if(StringUtils.isNotNullAndEmpty(this.getCoachName())){
			condition.append(" and Coach_Name like #{coachName}");
			values.put("coachName", "%"+this.getCoachName()+"%");
		}
		if(StringUtils.isNotNullAndEmpty(this.getCoachId())){
			condition.append(" and Coach_Id=#{coachId}");
			values.put("coachId",this.getCoachId());
		}
		if(StringUtils.isNotNullAndEmpty(this.getCoachType())){
			condition.append(" and Coach_type=#{coachType}");
			values.put("coachType",this.getCoachType());
		}
		if(StringUtils.isNotNullAndEmpty(this.getCoachExperience())){
			condition.append(" and coach_Experience like #{coachExperience}");
			values.put("coachExperience", "%"+this.getCoachExperience()+"%");
		}
		if(StringUtils.isNotNullAndEmpty(this.getCoachStatus())){
			condition.append(" and coach_status like #{coachStatus}");
			values.put("coachStatus", "%"+this.getCoachStatus()+"%");
		}
		return condition.toString();
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
	public Integer getCoachStatus() {
		return coachStatus;
	}
	public void setCoachStatus(Integer coachStatus) {
		this.coachStatus = coachStatus;
	}
	
	

}
