package cn.easyproject.easyee.sm.notice.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.easyproject.easycommons.objectutils.EasyObjectExtract;
import cn.easyproject.easyee.sm.base.controller.BaseController;
import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.util.StatusCode;
import cn.easyproject.easyee.sm.notice.criteria.NoticeCriteria;
import cn.easyproject.easyee.sm.notice.entity.Notice;
import cn.easyproject.easyee.sm.notice.service.NoticeService;

@RestController
@RequestMapping("Notice")
public class NoticeController extends BaseController{
 
	@Resource
	private NoticeService noticeService;
	
	@RequestMapping("page")
	public ModelAndView page(ModelAndView mv) {
		mv.setViewName("main/notice/notice");
		return mv;
	}
	
	@RequestMapping("add")
	public Map<Object,Object> add(Notice notice){
		try {
			noticeService.save(notice);
			//处理成功，消息
			super.setMsgKey("msg.saveSuccess");
		} catch (Exception e) {
			e.printStackTrace();
			super.setMsgKey("msg.saveFail");
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		return super.setJsonMsgMap("rowData",notice);
	}
	
	@RequestMapping("delete")
	public Map<Object, Object> deleteById(Notice notice) {
		// try {
		// empService.delete(emp.getEmpno());
		// } catch (Exception e) {
		// e.printStackTrace();
		// super.setStatusCode(StatusCode.ERROR); //默认为OK
		// }
		// super.setJsonMsgMap();
		// 批量删除
		try {
			noticeService.deleteById(notice.getNoticeId());
			// sysUserService.delete(sysUser.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			// 出错输出 500 响应
			// ServletControllerContext.getResponse().setStatus(500);
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		return super.setJsonMsgMap();
	}
	
	@RequestMapping("update")
	public Map<Object,Object> update(Notice notice){
		try {
			noticeService.update(notice);;
			super.setMsgKey("msg.updateSuccess");
		} catch (Exception e) {
			e.printStackTrace();
			super.setMsgKey("msg.updateFail");
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		
		return super.setJsonMsgMap();
	}
	@RequestMapping("select")
	public Map<Object,Object> select(int ids){
		try {
			noticeService.get(ids);
			super.setMsgKey("msg.selectSuccess");
		} catch (Exception e) {
			e.printStackTrace();
			super.setMsgKey("msg.selectFail");
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		
		return super.setJsonMsgMap();
	}
	/**
	 * 分页
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("list")
	public Map<Object,Object> list(PageBean pb, NoticeCriteria cc){
		PageBean pb1 = super.getPageBean(); // 获得分页对
		noticeService.findByPage(pb1, cc);
		// EasyUI框架响应结果都是JSON
		// JSON数据初始化，包含EasySSH Ajax响应信息和分页信息
	//	List<Map> list = EasyObjectExtract.extract(pb1.getData(), "noticeId","NoContent");
	//	pb1.setData(list);
		
	
		Map m=super.setJsonPaginationMap(pb1);

		return m;
	}
}
