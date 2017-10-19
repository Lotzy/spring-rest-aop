package com.lotzy.sample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.lotzy.sample.entity.Message;

/**
 * <pre>
 * Title: ReviewingAspect class
 * Description: Aspect definition class
 * </pre>
 *
 * @author Lotzy
 * @version 1.0
 */
@Aspect
@Component //without this will not work
public class ReviewingAspect {

	private static final Logger log = LoggerFactory.getLogger(ReviewingAspect.class);

	@AfterReturning(pointcut="@annotation(review)", returning="retVal")
	public void myAdvice(JoinPoint jp, Review review, Object retVal) throws Throwable {
		Object[] args = jp.getArgs();
		for (int i = 0; i < args.length; i++) {
			log.debug((String) args[i]);
		}
		log.debug(retVal.toString());
		ResponseEntity<?> reponse = (ResponseEntity<?>) retVal;
		Message msg = (Message) reponse.getBody();
		log.debug(msg.getMsg());
		log.debug(review.method());
	}

}
