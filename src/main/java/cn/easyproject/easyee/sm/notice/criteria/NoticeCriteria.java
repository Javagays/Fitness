package cn.easyproject.easyee.sm.notice.criteria;

import cn.easyproject.easyee.sm.base.pagination.EasyCriteria;
import cn.easyproject.easyee.sm.base.util.StringUtils;

@SuppressWarnings("serial")
public class NoticeCriteria extends EasyCriteria implements java.io.Serializable{

	
	private Integer noticeId;	//这里的noticeId要与前端对应，才可以传值
	
	private String noContent;
	
	public NoticeCriteria() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCondition() {
		values.clear(); //清除条件数据
		StringBuffer condition = new StringBuffer();
		if(StringUtils.isNotNullAndEmpty(this.getNoticeId())){
			condition.append(" and notice_id like #{noticeId}");    //这里的noticeId也要和上面的一样才可以
			values.put("noticeId", "%"+this.getNoticeId()+"%");
		}
		if(StringUtils.isNotNullAndEmpty(this.getNoContent())){
			condition.append(" and ac_content=#{acContent}");
			values.put("noContent",this.getNoContent());
		}
		return condition.toString();
	}

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoContent() {
		return noContent;
	}

	public void setNoContent(String noContent) {
		this.noContent = noContent;
	}

}
