# camunda-springboot-postgres
 This repository is for camunda springboot postgres integration with authorization enabled
 
#Pre Requisite
Maven 3.6.x
Java 1.8
Postgresql v11
Spring Tool Suite 4

#Run this application

Clone this project into your local machine

git clone https://github.com/aravindhrs/camunda-springboot-postgres.git

Run this command from command prompt:

mvn clean install

Import the project as existing maven project

Update the application.yml file for db credentials

Run as Spring boot application from STS IDE.

From the browser access the cockpit as:

http://localhost:9091

It will prompt the popup for basic auth since we enabled camunda basic auth. Input the credentials as: demo/demo

Camunda rest api will be accessed like:
http://localhost:9091/engine-rest/engine

#Features
Camunda Authorization enabled
Camunda Auto deployment enabled
Camunda Spring boot postgres integration
Hikaricp Datasource support
