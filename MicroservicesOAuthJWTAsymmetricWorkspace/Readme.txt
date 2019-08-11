Ref workspace
=============
	Import all project from MicroservicesOAuthJWTWorkspace

Goals
=====
1) Separate server
2) Resource server added to all microservices (fare, search, booking and checkin)
2) JWT token with OAuth protocol i.e., using JWT token in place of auth token.
3) Spring security in website
4) No changes in website
5) Asymmetric key

Modified / New Files
====================
1) The following files have been modified in authorization-server-jwt project
	OAuth2AuthorizationServer.java

2) The following files have been modified across all microservices (fare, search, booking and checkin)
	application.properties

Note: No changes required for PSS Website.
