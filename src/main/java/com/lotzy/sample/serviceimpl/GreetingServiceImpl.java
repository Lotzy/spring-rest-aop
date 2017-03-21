package com.lotzy.sample.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lotzy.sample.service.GreetingService;

/**
 * <pre>
 * Title: GreetingServiceImpl class
 * Description: Greeting service implementation
 * </pre>
 *
 * @author Lotzy
 * @version 1.0
 */
@Service
public class GreetingServiceImpl implements GreetingService {

	private static final Logger log = LoggerFactory.getLogger(GreetingServiceImpl.class);

	@Override
  public String greet(String who) {
		log.debug("Greet " + who);
    return String.format("hello, %s!", who);
  }
}
