#spring-rest-aop

Example project illustrating:

- how to implement REST services with Spring

    - simple
    - with path variable
    - with request parameter
    - returning JSON response

- how to use Spring AOP with custom annotation ad point cut
- how to send parameters to the adivice
- how to get annotated method parameters
- how to access return value of the adivsed method
- how to use log4j2 with JSON layout

#Using the project:

1. Import in Eclipse as maven project
2. Deploy in Tomcat 8.0 under Eclipse
3. See JUnit tests
4. URL for the rest endpoints:
  [http://localhost:8080/spring-rest-aop/rest/greet](http://localhost:8080/spring-rest-aop/rest/greet) or
  [http://localhost:8080/spring-rest-aop/rest/greet/John](http://localhost:8080/spring-rest-aop/rest/greet/John) or
  [http://localhost:8080/spring-rest-aop/rest/greeting?name=John](http://localhost:8080/spring-rest-aop/rest/greeting?name=John)
