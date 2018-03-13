package cn.easyproject.easyee.sm.hd.criteria;

import cn.easyproject.easyee.sm.base.pagination.EasyCriteria;
import cn.easyproject.easyee.sm.base.util.StringUtils;

public class ActivityCriteria extends EasyCriteria implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6783266713307100623L;

	private Integer activityId;
	
	private String acContent;
	
	
	public ActivityCriteria() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCondition() {
		values.clear(); //清除条件数据
		StringBuffer condition = new StringBuffer();
		if(StringUtils.isNotNullAndEmpty(this.getActivityId())){
			condition.append(" and activity_id like #{activityId}");
			values.put("activityId", "%"+this.getActivityId()+"%");
		}
		if(StringUtils.isNotNullAndEmpty(this.getAcContent())){
			condition.append(" and ac_content=#{acContent}");
			values.put("acContent",this.getAcContent());
		}
		return condition.toString();
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getAcContent() {
		return acContent;
	}

	public void setAcContent(String acContent) {
		this.acContent = acContent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
