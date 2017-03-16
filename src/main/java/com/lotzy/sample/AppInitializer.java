package com.lotzy.sample;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * <pre>
 * Title: AppInitializer class
 * Description: As of servlet 3.0 there is no need for web.xml so to run Spring REST, this class is needed to initialize the servlet container
 * Copyright: Copyright (c) 2017
 * Company: Almaviva S.p.A.
 * </pre>
 *
 * @author Lotzy (lotzy_l@yahoo.com)
 * @version 1.0
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
      return new Class[] { AppConfigurator.class };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
      return null;
  }

  @Override
  protected String[] getServletMappings() {
      return new String[] { "/" };
  }

}
