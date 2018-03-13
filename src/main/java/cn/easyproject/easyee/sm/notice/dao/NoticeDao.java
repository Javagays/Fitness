package cn.easyproject.easyee.sm.notice.dao;

import java.util.List;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.hd.entity.Activity;
import cn.easyproject.easyee.sm.notice.criteria.NoticeCriteria;
import cn.easyproject.easyee.sm.notice.entity.Notice;

public interface NoticeDao {

	public void add(Notice notice);
	
	public void deleteById(int ids);
	
	public List<Notice> select();
	
	public void update(Notice notice);
	
	public List<Notice> get(int ids);
	
	public int findNoticeCountByNoticeId(Integer noticeId);
	
	@SuppressWarnings("rawtypes")   	//意思是忽略警告
	public List<Notice> pagination(PageBean pageBean);
	
	public int findMaxRow();
}
 