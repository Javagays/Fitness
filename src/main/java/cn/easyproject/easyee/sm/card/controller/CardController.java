package cn.easyproject.easyee.sm.card.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.easyproject.easyee.sm.base.controller.BaseController;
import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.util.StatusCode;
import cn.easyproject.easyee.sm.card.entity.Card;
import cn.easyproject.easyee.sm.card.service.CardService;

@RestController
@RequestMapping("Card")
public class CardController extends BaseController {
	public static Logger logger = LoggerFactory.getLogger(CardController.class);

	@Resource
	private CardService cardService;

	@RequestMapping("page")
	public ModelAndView page(ModelAndView mav) {
		mav.setViewName("main/card/Card");
		return mav;
	}

	@RequestMapping("add")
	public Map<Object, Object> save(Card card) {
		try {
			cardService.add(card);
			// 处理成功 消息
			super.setMsgKey("msg.addSuccess");
		} catch (Exception e) {
			e.printStackTrace();
			super.setMsgKey("msg.addFail");
			super.setStatusCode(StatusCode.ERROR); // 默认为OK // 默认为OK
		}

		/*
		 * Ajax响应信息 statusCode: 响应状态码; msg: 响应消息; callback: 执行回调函数, locationUrl: 跳转页面
		 */
		// EasyUI框架响应结果都是JSON
		// JSON数据初始化，包含EasySSH Ajax响应信息
		// super.setJsonMsgMap();
		// 添加数据后，使用rowData信息更新行的内容
		return super.setJsonMsgMap("rowData", card);

		// 如果需要刷新，跳转到最后一页
		// int page = empService.findMaxPage(rows);
		// return super.setJsonMsgMap("rowData", dept, "page", page);
	}

	@RequestMapping("delete")
	public Map<Object, Object> delete(int cardId) {
		// try {
		// empService.delete(emp.getEmpno());
		// } catch (Exception e) {
		// e.printStackTrace();
		// super.setStatusCode(StatusCode.ERROR); //默认为OK
		// }
		// super.setJsonMsgMap();
		// 批量删除
		try {
			cardService.delete(cardId);
			// sysUserService.delete(sysUser.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			// 出错输出 500 响应
			// ServletControllerContext.getResponse().setStatus(500);
			super.setStatusCode(StatusCode.ERROR); // 默认为OK
		}
		return super.setJsonMsgMap();
	}

	// 查询所有
	@RequestMapping("select")
	public Map<Object,Object> findAll() {
		List<Card> cards=null;
		try {
			
		  cards = cardService.findAll();
			// sysUserService.delete(sysUser.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			// 出错输出 500 响应
			// ServletControllerContext.getResponse().setStatus(500);
			super.setStatusCode(StatusCode.ERROR); // 默认为OK
		}
		return super.setJsonMap("data",cards);
	}

	@RequestMapping("allCardType")
	public Object AllcardType() {
		return cardService.allCardType();
	}

}
