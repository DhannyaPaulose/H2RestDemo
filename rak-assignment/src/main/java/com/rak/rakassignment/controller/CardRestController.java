package com.rak.rakassignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rak.rakassignment.domain.Card;
import com.rak.rakassignment.repository.CardRepository;
import com.rak.rakassignment.service.CardService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class CardRestController {
	
	@Autowired
	CardService cardService;
	
	@Autowired
	CardRepository cardRepository;
	
	
	@PostMapping("/createcard")
	public Card createCard(@RequestBody Card card) {
		return cardRepository.save(card);
	}
	
	@GetMapping("/cards")
	public List<Card> getAllCardDetails(){
		return cardRepository.findAll();
	}
	
	@GetMapping("/card/{cardNo}")
	public Card getCardByCardNo(@PathVariable(value = "cardNo") long cardNo,@RequestParam(value="cardPin") int cardPin) throws Exception {
		return cardService.checkCardNo(cardNo, cardPin);
	}
	
	@GetMapping("/is-card/{cardNo}/{cardPin}")
	public boolean isCardExist(@PathVariable(value = "cardNo") long cardNo, @PathVariable(value = "cardPin") int cardPin) throws Exception {
		boolean isCard = cardService.authCard(cardNo, cardPin) == 1 ? true : false;
		return isCard;
	}

}
