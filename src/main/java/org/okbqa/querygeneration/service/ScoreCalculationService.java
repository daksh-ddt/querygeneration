package org.okbqa.querygeneration.service;

import org.okbqa.querygeneration.model.NamedEntity;
import org.okbqa.querygeneration.model.NamedEntityCombination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ScoreCalculationService {
	private static final Logger logger = LoggerFactory.getLogger(ScoreCalculationService.class);
	
	public double calculate(double qScore, NamedEntityCombination nec) {
		double dScore = 0;

		if(nec.getScore() == 0) {
			// average of named entity's scores
			for(NamedEntity ne : nec.getNamedEntities()) {
				logger.info("{}", ne.getScore());
				dScore += ne.getScore() * 1 / nec.getNamedEntities().length; 
			}
			logger.info("{}", dScore);
		} else {
			// use given score
			dScore = nec.getScore();
		}
		
		// pseudo query score * 0.5 + average of named entity's scores * 0.5
		return qScore * 0.5 + dScore * 0.5;
	}
}
