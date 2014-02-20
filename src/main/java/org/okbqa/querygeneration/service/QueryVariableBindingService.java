package org.okbqa.querygeneration.service;

import org.okbqa.querygeneration.model.NamedEntity;
import org.okbqa.querygeneration.model.NamedEntityCombination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class QueryVariableBindingService {
	private static final Logger logger = LoggerFactory.getLogger(QueryVariableBindingService.class);

	public String bind(String queryString, NamedEntityCombination nec) {

		for(NamedEntity ne : nec.getNamedEntities()) {
			while(queryString.contains("?" + ne.getVariable())) {
				queryString = queryString.replace("?" + ne.getVariable(), "<" + ne.getValue() + ">");
			}
		}
		
		return queryString;
	}

}
