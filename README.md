**<h2>The Goal</h2>**
The goal is to have a an application that is broken down into multi-tiers and layers where each layer is decoupled from the others.
This way we can change the database provider (eg. H2 to MySQL) with minimal update to the resource properties file. 
Also any update or maintenance can be targeted toward a specific layer without needing to change any other code or logic elsewhere. 

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
  o	This is the dispatcher (interceptor or façade) that delegates requests to the intended business service.</br>
  o	It mediates between the client requests (View) and the business layer, while keeping the separation of concerns.</br>
  o	To make it a Web application or Mobile, then build your web or mobile client and spin-up a Rest Api Controller to handle the requests.</br>
* <ins>Model</ins></br>
  o	This is where all the entities and their ORM data modeling are defined.</br>
  o	These entities map to the database tables designed in the schema.</br>
* <ins>Service</ins></br>
  o	This is where all the business rules and calculations take place.</br>
  o	It is isolated from the persistent layer or the client layer.</br>
* <ins>DAO</ins></br>
  o	Data Access Object layer that separates the business & persistence layers.</br>
  o	All database interactions (e.g. CRUD) are encapsulated at this layer.</br>
*	<ins>DTO</ins></br>
  o	Data Transfer Object are just POJOs that carry data around between domains and layers.</br>
  o	Stuffing more data in the DTO objects allows for less traffic, and method calls over the network.</br>

**Steps**</br>
*	Clone this repository to your local env.</br>
*	H2 database is configured and used automatically.</br>
o	DDL is handled by Hibernate based on the entities’ definitions.</br>
o	DML is generated from my import.sql resource file.</br>
o	Want MySQL, update the data-source URLs and credentials in resource file.</br> 
*	Run this application in IntelliJ IDEA or from the command line prompt.</br>
