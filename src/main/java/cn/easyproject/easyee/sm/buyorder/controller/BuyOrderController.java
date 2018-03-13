package cn.easyproject.easyee.sm.buyorder.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.easyproject.easycommons.objectutils.EasyObjectExtract;
import cn.easyproject.easyee.sm.base.controller.BaseController;
import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.buyorder.criteria.BuyOrderCriteria;
import cn.easyproject.easyee.sm.buyorder.service.BuyOrderService;

@RestController
@RequestMapping("BuyOrder")
public class BuyOrderController extends BaseController{

	@Resource
	private BuyOrderService buyOrderService;
	
	@RequestMapping("page")
	public ModelAndView page(ModelAndView mv) {
		mv.setViewName("main/buyorder/BuyOrder");
		return mv;
	}
	
	/**
	 * 分页
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("list")
	public Map<Object,Object> list(BuyOrderCriteria cc){
		PageBean pb1 = super.getPageBean(); // 获得分页对
		buyOrderService.findByPage(pb1, cc);
		Map m=super.setJsonPaginationMap(pb1);

		return m;
	}
}
