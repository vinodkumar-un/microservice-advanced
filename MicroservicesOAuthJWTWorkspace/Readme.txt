Ref workspace
=============
	- Import Fare, Search, Booking, CheckIn and FlightsWebsite projects from MicroservicesOAuthWorkspace
	- Import separate-authorization-server from MicroservicesOAuthWorkspace and rename it as 'authorization-server-jwt'

Goals
=====
1) Separate Auth server
2) Resource server added to all microservices (fare, search, booking and checkin)
3) JWT token with OAuth protocol i.e., using JWT token in place of auth token.
4) Spring security in website
5) Resource server is not required in web site.
6) Symmetric key

Modified / New Files
====================
1) The following files have been modified in authorization-server-jwt project
	pom.xml
	application.properties 
	OAuth2AuthorizationServer.java

2) The following files have been modified across all microservices (fare, search, booking and checkin)
	pom.xml
	application.properties
	OAuth2ResourceServer.java

Note: No changes required for PSS Website.


	
