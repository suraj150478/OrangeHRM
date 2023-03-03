Feature: OrangeHRM My Info
    As an employee see and update My Information

		Background: User is logged in to OrangeHRM
			Given User opens OrangeHRM URL
			And User enters username as Admin and password as admin123
			And Click on login
				
		Scenario: View My Info page
    	Given User is on Dashboard page
    	When User clicks on the My Info link
    	Then User should see my info section
	
    Scenario: Change Profile picture section
    	Given User is on Dashboard page
    	When User clicks on the My Info link
    	And User clicks on Image
    	Then User can see the Change profile picture section