package cn.easyproject.easyee.sm.hd.entity;

public class Activity {
	
/*
 *  Activity_id          int not null auto_increment,
   ac_content           varchar(255) comment '活动内容',
   primary key (Activity_id)
 */
	private Integer activityId;
	
	private String acContent;    //這裡的字段要和前端傳過來的字段一樣，否則無法接受成功

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

	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", acContent=" + acContent + "]";
	}

	public Activity(Integer activityId, String acContent) {
		super();
		this.activityId = activityId;
		this.acContent = acContent;
	}

	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
