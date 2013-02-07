Feature: Charity Testing
	
	Scenario: Login positive flow
		Given the user access Charity Login page
		When the user enters valid credentials and clicks login
		Then the user is taken to charity admin page
		
	Scenario: Login negative flow
		Given the user access Charity Login2 page
		When the user enters invalid credentials and clicks login
		Then user is taken to failed login page

	Scenario: Check unauthorized access is not allowed
		Given the user has not logged in yet
		When the user access Charity Admin page
		Then the user should be taken to login page
		
	#Scenario: Check approve functionaly on ucladmin page
	#	Given the user is logged in and on reached user admin
	#	When the user clicks approve on Admin page
	#	Then approved request is removed
	
			
			