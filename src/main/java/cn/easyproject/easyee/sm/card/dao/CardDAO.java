package cn.easyproject.easyee.sm.card.dao;

import java.util.List;

import cn.easyproject.easyee.sm.card.entity.Card;

public interface CardDAO {

	/*添加卡*/
	public void add(Card card);

	/*逻辑删除卡*/
	public void delete(int cardId);

	/*展示卡*/
	public List<Card> findAll();
	
	public List<Integer> allCardType();

}
