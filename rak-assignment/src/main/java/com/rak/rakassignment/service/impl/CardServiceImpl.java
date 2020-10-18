package com.rak.rakassignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rak.rakassignment.domain.Card;
import com.rak.rakassignment.repository.CardRepository;
import com.rak.rakassignment.service.CardService;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	CardRepository cardRespository;

	@Override
	public Card checkCardNo(Long cardNo, int cardPin) throws Exception {
		Card card = cardRespository.checkCardInSystem(cardNo, cardPin);

		return card;
	}

	@Override
	public int authCard(Long cardNo, int cardPin) throws Exception {

		return cardRespository.authCard(cardNo, cardPin);
	}

}
