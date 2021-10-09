Feature: Exercise 1, some verifications for use of redtrust agent
	
	This feature try to solve the exercise 1 of level test, using a Gherkin language.
	
	For the password for users, I assume that are stored as environment property and not are declared in the test case.
	For the browser used, I assume that this tests cases are executed in all browsers.
	
	I create two test case that are the same, but one with more steps than other.
	
	Sorry for the urls used, I'm not use certificates when navigate for internet. 
	
	Scenario Outline: Verify correct functionality of policy in Redtrust Agent
		Given an user <user> with access to Redtrust Agent
		When try to use the certificate <certificate> in the url: <url>
		Then the Redtrust Server generates a log with the message <message>
		
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
	
	Scenario Outline: Verify correct functionality of policy in Redtrust Agent (v2)
		Given an user <user>
		When try to login in  Redtrust Agent
		Then the user is loged in Redtrust Agent
		When navigates to url: <url>
		And try to use the certificate <certificate>
		Then the Redtrust Server generates a log with the message <message>
		
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