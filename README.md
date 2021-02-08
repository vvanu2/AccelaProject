# AccelaProject
Coding Assignment from Accela

The main purpose of this project is to demonstrate the capabilities of spring boot for developing Web Services for CRUD Operations using in-memory database. It is a simple application with database access to demonstrate spring Boot RESTful web service for CRUD Operations.

Firstly, I have used Java 8 with Spring Boot and the project is built using Maven and tested in Postman for testing the rest endpoints. It uses in-memory H2 database to store the data. It show how it is easy to start a web service with embedded tomcat and embedded H2 database to perform the CRUD operations.
Secondly, I have implemented the MVC design pattern and separated the different layers into controller, service, repository, model, dto, etc. I have also implemented the ResourceNotFoundException and is thrown when the said person id or address does not exist to be edited or deleted
Thirdly, I have implemented the unit tests for Controllers and Service layer classes.
Lastly, I have done configuration of the whole project including H2 database configuration through application.properties and pom.xml.
Moreover, I have tested the RESTful application with Postman tool.
Note: I am also providing the jar file as a part of this project.

## Prerequisite

To develop this project, I have used:
- 	Java JDK 8 (1.8)
- 	Maven compatible with JDK 8
- 	Spring Tool Suite IDE
- 	Postman tool (Used for testing REST web services)

## Open Source tools used:
-	Spring Framework - MVC
-	Spring Boot - Data JPA,  Web
-	H2 - in-memory database
-	Maven - build tool
-	JUnit – Testing Framework

## Static H2 Credentials to access the database using h2-console when the spring boot application is running:
- sa/password

## Project Overview

This is a simple application named as AccelaProject. It is a simple Restful web service with basic CRUD operations and it is a standalone application that can be run independently. It is designed using Spring Boot, Data JPA and H2 database. Here we are using embedded tomcat and embedded H2 database.
The project is built using Maven as a multi-module project. Given below are the modules and the small description to them.
The project has been separated into different layers and consists of the following layers:

-	Controller layer
-	Service layer
-	DTO(Data Transfer Objects) layer
-	Repository layer
-	Model layer

Controller package has 3 controller classes PersonController, AddressController and PersonAddressController. The controllers call the service class methods to perform the data access layer operations which are defined in repository layer. There is also a DTO layer for joining person with the addresses. The Address and Person entities have been defined in the model package in the application.
All the following have been implemented within the given endpoints:
1. Add Person (id, firstName, lastName)
	- Endpoint: /api/v1/persons 
	- Method: POST
	- Controller: PersonController
  
2. Edit Person (firstName, lastName)
	- Endpoint: /api/v1/persons/{id} 
	- Method: PUT
	- Controller: PersonController

3. Delete Person (id)
	- Endpoint: /api/v1/persons/{id} 
	- Method: DELETE
	- Controller: PersonController

4. Add Address to person [multiple required] (id, street, city, state, postal
   - Endpoint: /api/v1/PersonWithAddresses
	 - Method: POST
	 - Controller: PersonAddressController

5. Edit Address (street, city, state, postalCode)
	- Endpoint: /api/v1/addresses/{id} 
	- Method: PUT
	- Controller: AddressController

6. Delete Address (id)
	- Endpoint: /api/v1/addresses/{id} 
	- Method: DELETE
	- Controller: AddressController

7. Count Number of Persons
	- Endpoint: /api/v1/personsCount 
	- Method: GET
	- Controller: PersonController

8. List Persons
	- Endpoint: /api/v1/persons 
	- Method: GET
	- Controller: PersonController

A sample from the postman response is shown below for the List Persons:

Sub Path: /persons

Full URL: http://localhost:8080/api/v1/persons

Method:   GET

Sends:    N/A

Receives: JSON

Sample Input: N/A

Sample Output;
```json
[{
	"id": 1,
	"firstname": "Jai",
	"lastname": "Vardhan",
	
},
{
	"id": 2,
	"firstname": "Atul",
	"lastname": "Nanda",
},
{
	"id": 3,
	"firstname": "Priya",
	"lastname": "Mathur",
}]
```

## Application Properties

Spring Boot solves our problem with automatic configuration as we use an embedded Tomcat and an embedded H2 database. The default location of the application.properties file is within the classpath, for example under src/main/resources in a maven project.

Let's take a detailed look;
-	Server Configuration   -   The default configuration port is 8080 and has not been changed
-	H2 Database Configuration  - We also need to specify whether the console is activated, so that we can use H2 database via the console, create our tables and initialize our db entries. (Once this is enabled, we can run the application and hit the url http://localhost:8080/h2-console from the browser)
#### H2 configuration
spring.h2.console.enabled=true
- DataSource Configuration -    Instead of writing a connection string, we are defining the parameters via our properties file as below: We are going to use in memory databse when we need to connect the database via the console;
#### Data source configuration
spring.datasource.url=jdbc:h2:mem:testdb\
spring.datasource.driverClassName=org.h2.Driver\
spring.datasource.username=sa\
spring.datasource.password=password\
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect


## Steps to Run the Application:
1.	Clone the project from GitHub into your local machine.
2.	Import the project into STS using Maven->Existing Maven Projects
3.	Build the project using Run As -> Maven Build(goals –> clean install)
Note : It is better to clean the local .m2 repository before building/running this project otherwise sometimes it gives ClassNotFoundException 
4.	Once the maven build is successful, run the AccelaProjectApplication.java as a Spring Boot App.
5.	If the application starts successfully, test it using postman 

## Improvements Suggested:
If there would have been some more time, I could have added lombok dependency to generate the setters and getters automatically. No. of code lines would have been reduced. Also could have used ModelMapper. 

