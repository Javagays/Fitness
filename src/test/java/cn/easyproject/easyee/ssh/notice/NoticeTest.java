package cn.easyproject.easyee.ssh.notice;

import org.junit.Test;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.util.SpringUtil;
import cn.easyproject.easyee.sm.hd.criteria.ActivityCriteria;
import cn.easyproject.easyee.sm.hd.entity.Activity;
import cn.easyproject.easyee.sm.hd.service.ActivityService;
import cn.easyproject.easyee.sm.notice.criteria.NoticeCriteria;
import cn.easyproject.easyee.sm.notice.entity.Notice;
import cn.easyproject.easyee.sm.notice.service.NoticeService;

public class NoticeTest {

	@Test
	public void test1() {
		
		NoticeService no = SpringUtil.getBean("noticeService");
		Notice not = new Notice();
	//	not.setNoticeId(3);   这里不用设置，否则会报错，因为数据库设置了自增
		not.setNoContent("寻物启事：一张绿色的卡片");
		no.save(not);
	}
	
	@Test
	public void test2() {
		NoticeService no = SpringUtil.getBean("noticeService");
		no.deleteById(6);
	}
	
	@Test
	public void test3() {
		NoticeService no = SpringUtil.getBean("noticeService");
		System.out.println(no.select());;
	}
	
	@Test
	public void test4() {
		NoticeService no = SpringUtil.getBean("noticeService");
		Notice noti = new Notice();
		noti.setNoticeId(1);
		noti.setNoContent("元宵过了，年味散了,你却胖了，嗯");
		no.update(noti);
	}
	
	@Test
	public void test5() {
		NoticeService ac = SpringUtil.getBean("noticeService");
		PageBean<Notice> pageBean = new PageBean<>();
		NoticeCriteria cc = new NoticeCriteria();
//		String acContent = null;
//		cc.setAcContent(acContent);
		pageBean.setPageTotal(ac.findMaxRow());
	//	pageBean.setRowsPerPage(4);
		
		System.out.println(ac.findByPage(pageBean, cc));
	}
}
