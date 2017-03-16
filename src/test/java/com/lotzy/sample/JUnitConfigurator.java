package com.lotzy.sample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <pre>
 * Title: JUnitConfigurator
 * Description:
 * </pre>
 *
 * @author Lotzy
 * @version 1.0
 */
@EnableAspectJAutoProxy //enables AspectJ support within the Spring beans
@Configuration
@ComponentScan({"com.lotzy.sample"})
public class JUnitConfigurator {
	//nothing needed yet
}
