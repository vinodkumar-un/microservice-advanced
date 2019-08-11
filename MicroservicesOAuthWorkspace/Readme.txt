Ref Project
===========
	Import all microservices and pss-website projects from microservices workspace
	Import separate-authorization-server project from OAuthWorkspace

Goals
=====
1) Microservices security using OAuth2 protocol	

Note:
1) Separate Authorization server
2) Resource server added to all microservices (fare, search, booking and checkin)
3) Reddis in-memory nosql db
4) Spring security in website
5) Resource server is not required in web site.


Modified / New files
====================
1) Following files have been modified / added across all microservices (fare, search, booking and checkin)
	pom.xml						[modified]
	application.properties				[modified]
	OAuth2ResourceServer.java			[new]
	Application.java				[modified]

2) Additionally following files have been modified in Booking and CheckIn microservices
	BookingComponent.java		[modified]
	CheckInComponent.java		[modified]

3) Following files have been modified / added in FlightsWebSite project:
	pom.xml					[modified]
	application.properties			[modified]
	Application.java			[modified]
	BrownFieldSiteController.java		[modified]
	SecurityConfig.java			[new]
		