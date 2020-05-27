# camunda-springboot-post
This repository is for camunda springboot postgres integration with authorization enabled.

  - Camunda Authorization (Baisc auth)
  - Postgres 11 integrated
  - HikariCP Connection pooling
  - BPMN Models auto deployment enabled
  - Camunda Rest api enabled
  - Camunda Webapps included

### Pre Requisites

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
      minimum-idle: 30
      maximum-pool-size: 10
      connection-timeout: 2000
      connection-test-query: select 1
      transaction-isolation: TRANSACTION_READ_UNCOMMITTED
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
