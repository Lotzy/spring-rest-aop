package com.lotzy.sample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * <pre>
 * Title: AppConfigurator class
 * Description: Spring application configuration with annotations
 * </pre>
 *
 * @author Lotzy
 * @version 1.0
 */
@EnableWebMvc
@EnableAspectJAutoProxy //enables AspectJ support within the Spring beans
@Configuration
@ComponentScan({"com.lotzy.sample"})
public class AppConfigurator {
	//nothing needed yet
}
