Ref Project
===========
	Import all projects except spring-boot-admin from MicroServicesCloudEurekaWorkspace
	
Goals
=====
1) Common API Gateway using Zuul
2) Eureka and Config Servers
3) Microservice endpoints are protected by API Gateway

Modified / New Files
====================
1) The following changes have been made in common-gateway project
	pom.xml
	application.properties
	common-apigateway.properties 

2) The following changes have been made in Booking, CheckIn and Website projects
	FareServiceProxy.java
	CheckinComponent.java
	BrownFieldSiteController.java
