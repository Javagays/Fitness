package cn.easyproject.easyee.ssh.sys.service.impl;

import org.junit.Test;

import cn.easyproject.easyee.sm.base.util.SpringUtil;
import cn.easyproject.easyee.sm.card.entity.Card;
import cn.easyproject.easyee.sm.card.service.CardService;

public class CardTest {

	CardService cs = SpringUtil.getBean("cardService");
	
	@Test
	public void test() {
		System.out.println(cs.findAll());
	}
	
	@Test
	public void typeTest() {
		System.out.println(cs.allCardType());
	}
	
	@Test
	public void addTest() {
		Card card = new Card("私教周卡",303,3000,"动感单车",90,"逆袭Fitnness",7,3000,"菜菜",0);
		cs.add(card);
	}
	
	
	
}
