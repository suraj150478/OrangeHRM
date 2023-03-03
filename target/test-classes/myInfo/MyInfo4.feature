@personalInfo
Feature: OrangeHRM Personal Information
    User can see and update Personal Information

		Background: user is logged in to OrangeHRM
			Given User opens OrangeHRM URL
			And User enters username as Admin and password as admin123
			And Click on login
    	And User clicks on the My Info link
    	Then User should see my info section

		Scenario: Update personal information with correct input
    	Given user is in Personal Information section
    	When user update the fields with new input
    	And user clicks on the Save button
    	
    Scenario: Giving invalid input spaces in required field of Personal Information section
    	Given user is in Personal Information section
    	When user update the required fields with spaces
    	And user clicks on the Save button
    	But it should show me error message
    	
    Scenario: Giving invalid input numbers in required field of Personal Information section
    	Given user is in Personal Information section
    	When user update the required fields with numbers
    	And user clicks on the Save button
    	But it should show me error message