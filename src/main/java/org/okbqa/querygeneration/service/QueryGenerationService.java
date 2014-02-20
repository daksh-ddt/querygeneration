package org.okbqa.querygeneration.service;

import java.util.List;
import java.util.Vector;

import org.okbqa.querygeneration.model.DisambiguationResult;
import org.okbqa.querygeneration.model.NamedEntityCombination;
import org.okbqa.querygeneration.model.PseudoQuery;
import org.okbqa.querygeneration.model.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryGenerationService {
	@Autowired
	private ScoreCalculationService scoreCalculationService;
	
	@Autowired
	private QueryVariableBindingService queryVariableBindingService;
	
	/**
	 * @TODO Some logics 
	 * @param pseudoQueries
	 * @param disambiguationResults
	 * @return generated queries
	 */
	public Query[] generate(PseudoQuery pseudoQuery,
			DisambiguationResult disambiguationResult) {
		List<Query> queries = new Vector<Query>();
		
		for(NamedEntityCombination nec : disambiguationResult.getNamedEntityCombinations()) {
			Query query = new Query();
			
			query.setQuery(queryVariableBindingService.bind(pseudoQuery.getQuery(), nec));
			
			query.setScore(scoreCalculationService.calculate(pseudoQuery.getScore(), nec));
			
			queries.add(query);
		}
		
		return queries.toArray(new Query[0]);
	}
	
}
