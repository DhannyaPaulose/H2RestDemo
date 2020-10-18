package com.rak.rakassignment.service;

import com.rak.rakassignment.domain.Card;

public interface CardService {
	Card checkCardNo(Long cardNo, int cardPin) throws Exception;
	int authCard(Long cardNo, int cardPin) throws Exception;
}
