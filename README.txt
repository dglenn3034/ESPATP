This is a file to help inform new users on the process to begin working on automated tests in katalon studio.


	1. Download and install Katalon studio here: https://www.katalon.com/
   
   
   KATALON STUDIO TESTING STRUCTURE
   
   1. Katalon has the following structure for setting up tests starting from the top: 
		
		Test Suites
		Test Cases
		Test Steps
		Test Objects
		
	2. Test Suites represents sets of test cases that can/should be run together logically. This is a one to many relationship between test suites and test cases.
	3. Test Cases are a set of Test Steps that make up on Test.
	4. A Test Step is a single command in Katalon that executes some WebUI function against the browser.
	5. Test Objects are the recipients of the Test Step that is running.

	GENERAL COMMENTS on Creating Tests
	1. Make every attempt to reuse the existing objects in the Object repository
	2. If you add a new control, take time to name it something easily recognizable, such as in Search results Add to Order Cart Button
	3. Make use of global variables defined in Profiles to allow the test to run in multiple environments (ESP, TCLOUD, Staging, Production). 
	4. the project is set to commit to a remote bucket in GitHub.

	GENERAL COMMENTS on Running Tests
	1. The Login information is now assumed to be in an excel file on your local machine. A copy of a 'dummy' form of the file is at: \\diskstation\data\esp\ATPs\logins.xlsx. You should copy this file to a local location and edit it to contain the credentials you are using for testing. Then select "Data Files" from the left side panel in Katalan Studio and browse to your local file. The form should populate with the values from your spreadsheet.

	2. Remember to select the appropriate Profile before running a test. These profiles contain the appropriate variable settings for each environment.
	
	