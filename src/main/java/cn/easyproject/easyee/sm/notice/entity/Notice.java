package cn.easyproject.easyee.sm.notice.entity;

public class Notice {

	/*
	 *  notice_id            int not null auto_increment,
        no_content           varchar(255) comment '公告内容',
	 */
	private Integer noticeId;
	
	private String noContent;

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

	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notice(Integer noticeId, String noContent) {
		super();
		this.noticeId = noticeId;
		this.noContent = noContent;
	}

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", noContent=" + noContent + "]";
	}

	
}
