#************************
#* Valid The Link Login *
#************************

Given /^the user access Charity Login page$/ do
 @LoginPagePos = LoginPagePos.new(@browser)
 @LoginPagePos.visit_LoginPage
end

When /^the user enters valid credentials and clicks login$/ do
  @LoginPagePos.enter_validCredentials
end

Then /^the user is taken to charity admin page$/ do
  @LoginPagePos.verify_validLogin
end


#***********************
#* InValid Login *
#***********************
Given /^the user access Charity Login2 page$/ do
 @LoginPageNeg = LoginPageNeg.new(@browser)
 @LoginPageNeg.visit_LoginPage
end

When /^the user enters invalid credentials and clicks login$/ do
  @LoginPageNeg.enter_invalidCredentials
end

Then /^user is taken to failed login page$/ do
  @LoginPageNeg.verify_invalidLogin
end

#******************************************************************
#* direct access to other pages is not allowed without logging in *
#******************************************************************
Given /^the user has not logged in yet$/ do
 @AdminPage = AdminPage.new(@browser)
 #@AdminPage. visit_CharityAdminPage
end

When /^the user access Charity Admin page$/ do
  @AdminPage. visit_CharityAdminPage
end

Then /^the user should be taken to login page$/ do
  @AdminPage.verify_unauthorizedAccess
end


#******************************************************************
#* Approve functionality on UCLAdmin page *
#******************************************************************
Given /^the user is logged in and on reached user admin$/ do
 @AdminPage = AdminPage.new(@browser)
 #@AdminPage.visit_CharityAdminPage
end

When /^the user clicks approve on Admin page$/ do
  @AdminPage.click_Approve
end

Then /^approved request is removed$/ do
  @AdminPage.verify_requestRemoved
end

