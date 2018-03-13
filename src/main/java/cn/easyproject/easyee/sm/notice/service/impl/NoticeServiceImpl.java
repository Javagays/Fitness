package cn.easyproject.easyee.sm.notice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.hd.criteria.ActivityCriteria;
import cn.easyproject.easyee.sm.hd.entity.Activity;
import cn.easyproject.easyee.sm.notice.criteria.NoticeCriteria;
import cn.easyproject.easyee.sm.notice.dao.NoticeDao;
import cn.easyproject.easyee.sm.notice.entity.Notice;
import cn.easyproject.easyee.sm.notice.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	@Resource
	NoticeDao noticedao;
	
	@Override
	public void save(Notice notice) {
		noticedao.add(notice);
	}

	@Override
	public void deleteById(int ids) {
		noticedao.deleteById(ids);
	}

	@Override
	public List<Notice> select() {
		return noticedao.select();
	}

	@Override
	public void update(Notice notice) {
		noticedao.update(notice);
	}


//	@Override
//	public int findNoticeCountByNoticeId(Integer noticeId) {
//		return noticedao.findNoticeCountByNoticeId(noticeId);
//	}

	@Override
	public int findMaxRow() {
		return noticedao.findMaxRow();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Notice> findByPage(PageBean pageBean, NoticeCriteria noticeCriteria) {
		pageBean.setFrom("Notice n");
		pageBean.setSelect("n.notice_id,n.no_content");
		pageBean.setPrimaryTable("n");
		pageBean.setEasyCriteria(noticeCriteria);
		return noticedao.pagination(pageBean);
		
	}

	@Override
	public List<Notice> get(int ids) {
		// TODO Auto-generated method stub
		return noticedao.get(ids);
	}

}
