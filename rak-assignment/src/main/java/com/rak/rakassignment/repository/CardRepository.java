package com.rak.rakassignment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rak.rakassignment.domain.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {
		
	@Query("SELECT card FROM Card card WHERE card.cardNo = :cardNo AND card.cardPin = :cardPin")
	Card checkCardInSystem( @Param("cardNo") long cardNo, @Param("cardPin") Integer cardPin); 
	
	@Query("SELECT  CASE WHEN card.cardNo = :cardNo AND card.cardPin = :cardPin THEN 1 ELSE 0 END AS cardAuth FROM Card card") 
	int authCard ( @Param("cardNo") long cardNo, @Param("cardPin") Integer cardPin);
		
}
