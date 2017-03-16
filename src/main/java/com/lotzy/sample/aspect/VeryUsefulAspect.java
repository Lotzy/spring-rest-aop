package com.lotzy.sample.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * Title: VeryUsefulAspect class
 * Description: Aspect definition class
 * Copyright: Copyright (c) 2017
 * Company: Almaviva S.p.A.
 * </pre>
 *
 * @author Lotzy (lotzy_l@yahoo.com)
 * @version 1.0
 */
@Aspect
@Component //without this shit will not work
public class VeryUsefulAspect {

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
		System.out.println("Executing myAdvice!! - Begin");
		Object returnValue = null;

		System.out.println("Start method execution");
		returnValue = pjp.proceed(); //this will execute the annotated method
		System.out.println("After method execution");
		return returnValue;
	}
}
