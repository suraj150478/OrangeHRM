Feature: Add new dependent

	Background: user is logged in to OrangeHRM
		Given User opens OrangeHRM URL
		And User enters username as Admin and password as admin123
		And Click on login
    And User clicks on the My Info link
    Then User should see my info section

  Scenario Outline: Add a new dependent
    Given user is in Dependents section
    And user click on the Add button
    And user fill in the required fields "<name>" "<relation>" "<others>" "<dob>" for the new dependent
    And user clicks on the Save button
    Examples:
    	|  name | relation | others  |     dob    |
    	| Suraj | o			   | Brother | 1999-01-01 |
    	| Saket | c				 | null    | 2014-10-02 |

  Scenario Outline: Edit existing dependent
    Given user is in Dependents section
    When user search for an "<Ename>" dependent
    When user click on the dependent Edit button
    And user fill in the required fields "<name>" "<relation>" "<others>" "<dob>" for the new dependent
    And user clicks on the Save button
    Examples:
    	| Ename |  name | relation | others  |     dob    |
    	| Saket | Sumit | o			   | Sister  | 2000-01-05 |

  Scenario Outline: Delete existing dependent
    Given user is in Dependents section
    When user search for an "<existing>" dependent
    And user click on the Dependents Delete button
    Then user confirm the deletion
		Examples:
			|existing|
			|  Suraj |