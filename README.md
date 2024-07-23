**<h2>Prerequisites</h2>**
You should have the following configuration to run this application

**Technology**</h2></br>
*	Java 17.0.11 (It is backward compatible with older versions of Java)</br>
*	Spring Boot 3.3.1</br>
*	Hibernate</br>
*	H2 database (It can be changed easily to MySQL)</br>
* Junit 4.13.2 (and Jupiter also)</br>

**IDE**</h2></br>
*	IntelliJ IDEA (Eclipse or VS will be fine)</br>

**Design Layout**</br>
This is a Model-View-Controller multitier application that is structured as follow:</br>
* <ins>View</ins></br>
  o	This a command line terminal that takes customers inputs and submit them as a request to the controller.</br>
  o	This Client can easily be changed to Web or Mobile client without interrupting the rest of application layers.</br>
* <ins>Controller</ins></br>
  o	This is the dispatcher (interceptor or façade) that delegates requests.</br>
  o	It mediates between the client requests (View) and the business layer.</br>
  o	To make it a Web application, then just spin-up a Rest Controller.</br>
* <ins>Model</ins></br>
  o	This is where all the entities and their ORM data modeling are defined.</br>
  o	These entities map to the database tables designed in the schema.</br>
* <ins>Service</ins></br>
  o	This is where all the business rules and calculations take place.</br>
* <ins>DAO</ins></br>
  o	Data Access Object layer that separates the business & persistence layers.</br>
  o	All database interactions (e.g. CRUD) are encapsulated at this layer.</br>
*	<ins>DTO</ins></br>
  o	Data Transfer Object are just POJOs that carry data around between layers.</br>   

**Steps**</br>
*	Clone this respiratory to your local env.</br>
*	H2 database is configured and used automatically.</br>
o	DDL is handled by Hibernate based on the entities’ definitions.</br>
o	DML is generated from my import.sql resource file.</br>
o	Want MySQL, update the data-source URLs and credentials in resource file.</br> 
*	Run this application in IntelliJ IDEA or from the command line prompt.</br>
