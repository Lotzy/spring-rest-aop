package com.lotzy.sample.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * Title: VeryUsefulAspect class
 * Description: Aspect definition class
 * </pre>
 *
 * @author Lotzy
 * @version 1.0
 */
@Aspect
@Component //without this will not work
public class VeryUsefulAspect {

	private static final Logger log = LoggerFactory.getLogger(VeryUsefulAspect.class);

	/**
	 * When @Around is used the method signature and structure must necessarily be like this
	 * @param pjp - the proceeding join point, a must because we need to call ProceedingJoinPoint.proceed() to execute the annotated method
	 * @param loggable - this absolutely needs to be declared and must respect java variable naming convention derived from the annotation interface name.
	 * Same rule for @annotation(loggable)
	 * Example: @MumuAnnotation then mumuAnnotation
	 * @return generic object
	 * @throws Throwable if something goes wrong
	 */
	@Around("@annotation(loggable)")
	public Object myAdvice(ProceedingJoinPoint pjp, Loggable loggable) throws Throwable {
		log.debug("Executing myAdvice!! - Begin");
		Object returnValue = null;

		log.debug("Start method execution");
		returnValue = pjp.proceed(); //this will execute the annotated method
		log.debug("After method execution");
		return returnValue;
	}
}
