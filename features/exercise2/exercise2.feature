Feature: Exercise 1, some verifications for use of redtrust agent
	
	This feature try to solve the exercise 2 of level test, using a Gherkin language.
	
	For the authentification for spotify api, I assume that user and token are stored and not are declared in the test case.
	
	Scenario Outline: Add new song to playlist in spotify
		Given access to spotify api
		When add the song <song> to playlist <playlist>
		Then verify that song is added to playlist
		
		Examples:
			|  user  | certificate |         url          |              message                 |
			| user01 |    cert01   | https://hacienda.com | user01 cannot use certificate cert01 |
			| user01 |    cert02   | https://hacienda.com | user01 can use certificate cert02    |
			| user01 |    cert03   | https://hacienda.com | user01 cannot use certificate cert03 |
			| user02 |    cert01   | https://hacienda.com | user02 cannot use certificate cert01 |
			| user02 |    cert02   | https://hacienda.com | user02 cannot use certificate cert02 |
			| user02 |    cert03   | https://hacienda.com | user02 cannot use certificate cert03 |
			| user03 |    cert01   | https://hacienda.com | user03 cannot use certificate cert01 |
			| user03 |    cert02   | https://hacienda.com | user03 cannot use certificate cert02 |
			| user03 |    cert03   | https://hacienda.com | user03 cannot use certificate cert03 |