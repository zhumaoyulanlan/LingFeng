package com.lingfeng.dao.impl;

import com.lanlan.base.BaseDaoImpl;
import com.lingfeng.dao.CardDao;
import com.lingfeng.model.Card;

public class CardDaoImpl extends BaseDaoImpl<Card> implements CardDao{

	public CardDaoImpl() {
		super(Card.class);
	}

}
