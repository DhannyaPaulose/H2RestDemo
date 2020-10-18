package com.rak.rakassignment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="card")
public class Card {
	
//	private int cardId;
	private long cardNo;
	private int cardPin;
	
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Card(long cardNo, int cardPin) {
		super();
		this.cardNo = cardNo;
		this.cardPin = cardPin;
	}


//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	public int getCardId() {
//		return cardId;
//	}
//	public void setCardId(int cardId) {
//		this.cardId = cardId;
//	}
	
	@Id
	@Column(name = "cardNo" , nullable = false)
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	
	@Column(name = "cardPin" , nullable = false)
	public int getCardPin() {
		return cardPin;
	}
	public void setCardPin(int cardPin) {
		this.cardPin = cardPin;
	}


	@Override
	public String toString() {
		return "Card [ cardNo=" + cardNo + ", cardPin=" + cardPin + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cardNo ^ (cardNo >>> 32));
		result = prime * result + cardPin;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (cardNo != other.cardNo)
			return false;
		if (cardPin != other.cardPin)
			return false;
		return true;
	}
	
	

}
