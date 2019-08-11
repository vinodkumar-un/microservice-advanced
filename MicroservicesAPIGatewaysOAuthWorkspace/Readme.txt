Ref Projects
============
	Import MicroservicesAPIGatewaysWorkspace
	Import authorization-server-jwt project from MicroservicesOAuthJWTWorkspace
	
Goals
=====
1) Common API Gateway using Zuul
2) Microservices security using OAuth 2.0 and JWT tokens

Modified Projects
=================
1) All microservices (fare, search, booking and checkin) projects need to be modified to add resource server
2) Additionally Booking and CheckIn microservices need to be further modified to all OAuth2RestTemplate.
3) Modify PSS WebSite project to add Spring Security and OAuth2RestTemplate.

Modified / New Files
====================
1) The following changes have been made across all microservices
	pomt.xml
	bootstrap.properties
	OAuth2ResourceServer.java
	Application.java

2) Additionally the following changes have been made in Booking and CheckIn microservices
	BookingComponent.java
	CheckInComponent.java

3) The following changes have been made in FlightsWebSite
	pom.xml
	BrownFieldSiteController.java
	SecurityConfig.java
	Application.java
	
Improvements
===========
Feign doesn't use RestTemplate. But use following workaround solution to make it to work:
https://stackoverflow.com/questions/29439653/spring-cloud-feign-with-oauth2resttemplate








