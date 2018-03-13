package cn.easyproject.easyee.sm.card.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.easyproject.easyee.sm.base.service.BaseService;
import cn.easyproject.easyee.sm.card.dao.CardDAO;
import cn.easyproject.easyee.sm.card.entity.Card;
import cn.easyproject.easyee.sm.card.service.CardService;

@Service("cardService")
public class CardServiceImpl extends BaseService implements CardService {

	@Resource
	CardDAO cardDAO;

	/* 添加卡 */
	@Override
	public void add(Card card) {
		cardDAO.add(card);
	}

	/* 删除卡 */
	@Override
	public void delete(int cardId) {
		cardDAO.delete(cardId);
	}

	/* 展示卡 */
	@Override
	public List<Card> findAll() {
		return cardDAO.findAll();
	}

	/*卡种类*/
	@Override
	public List<Map> allCardType() {
		
		List<Map> list = new ArrayList<>();
		Map<String, Object> type = new HashMap<String, Object>();
		
		list.add(type);
		type.put("name", "私教百次卡");
		type.put("value", Card.HUNDREDTIMESCARD);

		list.add(type);
		type.put("name", "私教72次卡");
		type.put("value", Card.SEVENTYTIMESCARD);
		
		list.add(type);
		type.put("name", "私教36次卡");
		type.put("value", Card.THIRTYTIMESCARD);
		
		list.add(type);
		type.put("name", "私教次卡");
		type.put("value", Card.ONCETIMECARD);
		
		list.add(type);
		type.put("name", "私教月卡");
		type.put("value", Card.THIRTYTIMESCARD);
		
		list.add(type);
		type.put("name", "私教季卡");
		type.put("value", Card.GRATISCARD);

		list.add(type);
		type.put("name", "VIP");
		type.put("value", Card.VIPCARD);
		
		list.add(type);
		type.put("name", "自由训练年卡");
		type.put("value", Card.FREEYEARCARD);
		
		list.add(type);
		type.put("name", "自由训练百天卡");
		type.put("value", Card.FREEHUNDREDCARD);
		
		list.add(type);
		type.put("name", "自由训练百次卡");
		type.put("value", Card.HUNDREDFREETIMECARD);
		
		return list;
	}

}
