package org.okbqa.querygeneration.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.okbqa.querygeneration.model.Payload;
import org.okbqa.querygeneration.model.Query;
import org.okbqa.querygeneration.service.QueryGenerationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class QueryGenerationController {
	
	private static final Logger logger = LoggerFactory.getLogger(QueryGenerationController.class);
	
	@Autowired
	private QueryGenerationService queryGenerationService;
	
	private ObjectMapper objectMapper = new ObjectMapper();

	private Payload parsePayload(HttpServletRequest request) {
		if (0 < request.getContentLength()) {
			try {
				return objectMapper.readValue(request.getInputStream(), Payload.class);
			} catch (JsonParseException e) {
				logger.info(e.getMessage());
				
				throw new HttpMessageNotReadableException(e.getMessage());
			} catch (JsonMappingException e) {
				logger.info(e.getMessage());
				
				throw new HttpMessageNotReadableException(e.getMessage());
			} catch (IOException e) {
				logger.info(e.getMessage());
				
				throw new HttpMessageNotReadableException(e.getMessage());
			}
		} else {
			logger.info("ContentLength is 0");
			
			throw new HttpMessageNotReadableException("ContentLength is 0");
		}
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public Query[] generate(HttpServletRequest request) {
		Payload payload = parsePayload(request);
		
		logger.debug("Input: {}", payload);
		
		Query[] queries = queryGenerationService.generate(payload.getPseudoQuery(), payload.getDisambiguationResult());
		
		logger.debug("Output: {}", Arrays.toString(queries));
		
		return queries;
	}
	
}
