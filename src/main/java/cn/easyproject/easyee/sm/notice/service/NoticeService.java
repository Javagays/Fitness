package cn.easyproject.easyee.sm.notice.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.hd.criteria.ActivityCriteria;
import cn.easyproject.easyee.sm.hd.entity.Activity;
import cn.easyproject.easyee.sm.notice.criteria.NoticeCriteria;
import cn.easyproject.easyee.sm.notice.entity.Notice;

@Transactional
public interface NoticeService {

	public void save(Notice notice);
	
    public void deleteById(int ids);
	
	public List<Notice> select();
	
	public void update(Notice notice);
	
	public List<Notice> get(int ids);

//	public int findNoticeCountByNoticeId(Integer noticeId);
	
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly=true)
	public List<Notice> findByPage(PageBean pageBean,NoticeCriteria noticeCriteria);
	
	public int findMaxRow();
}
