![Java CI with Maven](https://github.com/aravindhrs/camunda-springboot-postgres/workflows/Java%20CI%20with%20Maven/badge.svg) ![CodeQL](https://github.com/aravindhrs/camunda-springboot-postgres/workflows/CodeQL/badge.svg)

# camunda-springboot-postgres
This repository is for camunda springboot postgres integration with authorization enabled.

  - Camunda Authorization (Basic auth)
  - Postgres 11 integrated
  - HikariCP Connection pooling
  - BPMN Models auto deployment enabled
  - Camunda Rest api enabled
  - Camunda Webapps included
  
### Implementation

- Main Class (Bootstrap):

	```sh
	@SpringBootApplication
	@EnableProcessApplication
	public class Application {
	
	  public static void main(String[] args) {
	    SpringApplication.run(Application.class);
	  }
	
	}
	
	```
- Camunda Basic Authentication:

	```sh
	@Configuration
	public class CamundaSecurityFilter {

	  @Bean
	  public FilterRegistrationBean<Filter> processEngineAuthenticationFilter() {
	    FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
	    registration.setName("camunda-auth");
	    registration.setFilter(getProcessEngineAuthenticationFilter());
	    registration.addInitParameter("authentication-provider",
	        "org.camunda.bpm.engine.rest.security.auth.impl.HttpBasicAuthenticationProvider");
	    registration.addUrlPatterns("/*");
	    registration.setOrder(1);
	    return registration;
	  }
	
	  @Bean
	  public Filter getProcessEngineAuthenticationFilter() {
	    return new ProcessEngineAuthenticationFilter();
	  }
	}
	```
	
- Process Deployment descriptor

	```sh
	<process-application xmlns="http://www.camunda.org/schema/1.0/ProcessApplication" 
	  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	
	  <process-archive>
	    <resource>process.bpmn</resource>
	    <properties>
	      <property name="isDeleteUponUndeploy">false</property>
	      <property name="isScanForProcessDefinitions">true</property>
	      <property name="javaSerializationFormatEnabled">true</property>
	    </properties>
	  </process-archive>
	
	</process-application>
	```	  

### Pre-Requisites

Below softwares need to be installed in the system before running this application.

| Software | Version |
| ------ | ------ |
| Java | 1.8 |
| Postgres | 11 |
| Maven | 3.6.x |
| Spring Tool Suite | 4 |

### Run this application

- Clone this project into your local machine
    ```sh
    git clone https://github.com/aravindhrs/camunda-springboot-postgres.git
    ```
- Run this command from command prompt:
    ```sh
    mvn clean install
    ```
- Import the project as existing maven project

- Create an empty database in postgres with name camundaworkflow
	```sh
	CREATE DATABASE camundaworkflow;
	```

- Update the application.yml file for db credentials
    ```sh
    server:
      port: 9091 
    spring:
      application:
        name: camundapostgres
    jpa:
      database-platform: org.hibernate.dialect.PostgreSQL9Dialect
    datasource:
      type: com.zaxxer.hikari.HikariDataSource
      url: jdbc:postgresql://localhost:5432/camundaworkflow
      username: postgres
      password: postgres
    hikari:
      jdbc-url: jdbc:postgresql://localhost:5432/camundaworkflow
      username: postgres
      password: postgres
      driver-class-name: org.postgresql.Driver
      pool-name: HikariCP
      idle-timeout: 3000
      minimum-idle: 10
      maximum-pool-size: 20
      connection-timeout: 2000
      connection-test-query: select 1
      transaction-isolation: TRANSACTION_READ_COMMITTED
    camunda:
      bpm:
        enabled: true
        #process-engine-name: andromeda
        admin-user:
          id: demo
          password: demo
          email: ufo@andromeda.com
          first-name: Andromeda
          last-name: Galaxy
        database:
          schema-update: true
        filter:
          create: All
        authorization:
          enabled: true
        history-level: full
        auto-deployment-enabled: true
        default-number-of-retries: 3
        job-execution:
          enabled: true
        webapp:
          application-path: /camundapostgres      
    ```
- Run as Spring boot application from STS IDE.

- From the browser access the cockpit as:
    ```sh
    http://localhost:9091
    ```
- It will prompt the popup for basic auth since we enabled camunda basic auth. Input the credentials as: 
    ```sh
    demo/demo
    ```
- Camunda rest api will be accessed like:
    ```sh
    http://localhost:9091/engine-rest/engine
    ```
- Camunda rest api authorization details are:
    ```sh
    demo/demo
    ```
    
- Webapps context-path:
	```sh
	/camundapostgres
	```    
