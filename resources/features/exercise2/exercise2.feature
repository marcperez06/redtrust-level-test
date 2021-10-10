Feature: Exercise 2, Some Frontend test
	
	This feature try to solve the exercise 2 of level test, using a Gherkin language.
	
	For the authorization for spotify api, I assume that user and token are stored in a file
	
	Scenario: Verify profile user on Spotify Webpage
		Given a valid user for Spotify
		When access to profile page
		Then verify that email is "marc.perez.rodriguez.redtrust@gmail.com"
		
	Scenario Outline: Exploratory Testing of all the links in a webpage
		Given a webpage <url>
		When get all the links
		Then verify that each link returns the status code 200
		
		Examples:
			|            url             |
			| https://www.spotify.com/es |