package com.lingfeng.service.impl;

import com.lanlan.base.BaseDao;
import com.lanlan.base.BaseServiceImpl;
import com.lingfeng.dao.CardDao;
import com.lingfeng.model.Card;
import com.lingfeng.service.CardService;

public class CardServiceImpl extends BaseServiceImpl<Card> implements CardService{

	private CardDao cardDao;
	
	public CardServiceImpl() {
		super();
	}
	
	public CardServiceImpl(BaseDao<Card> dao) {
		super(dao);
	}

	public CardDao getCardDao() {
		return cardDao;
	}

	public void setCardService(CardDao cardDao) {
		super.setDao(cardDao);
		this.cardDao = cardDao;
	}
	
	

}
