package cn.easyproject.easyee.sm.card.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import cn.easyproject.easyee.sm.card.entity.Card;


@Transactional
public interface CardService {

	/*添加卡*/
	public void add(Card card);

	/*逻辑刪除卡*/
	public void delete(int cardId);

	/*展示卡*/
	public List<Card> findAll();
	
	/*展示卡种类*/
	public List<Map> allCardType();

}
