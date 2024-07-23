Prerequisites
You should have the following configuration to run this application.

Technology
•	Java 17.0.11 (It is backward compatible with older versions of Java)
•	Spring Boot 3.3.1
•	Hibernate
•	H2 database (It can be changed easily to MySQL)
•	Junit 4.13.2 (and Jupiter also)

IDE
•	IntelliJ IDEA (Eclipse or VS will be fine)

Design Layout
•	This is a Model-View-Controller multitier application that is structured as follow:
•	View
o	This a command line terminal that takes customers inputs and submit them as a request to the controller.
o	This Client can easily be changed to Web or Mobile client without interrupting the rest of application layers.
•	Controller
o	This is the dispatcher (interceptor or façade) that delegates requests.
o	It mediates between the client requests (View) and the business layer.
o	To make it a Web application, then just spin-up a Rest Controller
•	Model
o	This is where all the entities and their ORM data modeling are defined.
o	These entities map to the database tables designed in the schema  
•	Service
o	This is where all the business rules and calculations take place.
•	DAO
o	Data Access Object layer that separates the business & persistence layers
o	All database interactions (e.g. CRUD) are encapsulated at this layer. 
•	DTO
o	Data Transfer Object are just POJOs that carry data around between layers.   

Steps
•	Clone this respiratory to your local env.
•	H2 database is configured and used automatically.
o	DDL is handled by Hibernate based on the entities’ definitions.
o	DML is generated from my import.sql resource file. 
o	Want MySQL, update the data-source URLs and credentials in resource file. 
•	Run this application in IntelliJ IDEA or from the command line prompt.
