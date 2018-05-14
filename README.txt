This is a file to help inform new users on the process to begin working on automated tests in katalon studio.

	GETTING FILES AND CHECKING INTO TFS
	
	1. Download and install Katalon studio here: https://www.katalon.com/
	2. If you are planning to add a new test or edit an existing one, you must first check out the folder in TFS
	   named P:\ATP\ESP.
	3. When you have finished your edits, if you have added any new files to the ATP\ESP folders, you will need to add them manually in TFS.
	4. If you have only made edits to existing files, you will simply check back in your changes.
   
   
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

	GENERAL COMMENTS
	1. Make every attempt to reuse the existing objects in the Object repository
	2. If you add a new control, take time to name it something easily recognizable, such as Form.control as in Search results Add to Order Cart Button
	3. Make use of global variables defined in Profiles to allow the test to run in multiple environments (ESP, TCLOUD, Staging, Production). 
	4. There are two profiles already created, TCLoud Production and ESP Production. You must set the appropripate profile before executing the test
	
	