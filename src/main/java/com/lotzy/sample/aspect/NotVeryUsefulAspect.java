package com.lotzy.sample.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * Title: NotVeryUsefulAspect class
 * Description: Aspect definition class
 * </pre>
 *
 * @author Lotzy
 * @version 1.0
 */
@Aspect
@Component //without this shit will not work
public class NotVeryUsefulAspect {

	private static final Logger log = LoggerFactory.getLogger(NotVeryUsefulAspect.class);

	/**
	 * Advice method that will be called when the custom annotation @Auditable is encountered on some methods
	 * @param auditable - this absolutely needs to be declared and must respect java variable naming convention derived from the annotation interface name.
	 * Same rule for @annotation(auditable)
	 * Example: @MumuAnnotation then mumuAnnotation
	 */
	@After("@annotation(auditable)") //same for @Before
	public void myAdvice(Auditable auditable) {
		log.debug("Executing myAdvice!!");
	}

}
