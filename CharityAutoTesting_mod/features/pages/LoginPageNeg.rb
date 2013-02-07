class LoginPageNeg

	attr_accessor :user_field, :password_field, :signon_button

	URLS = { :url => "http://localhost:8080/CharityWare/login.jsp"}


	def initialize(browser)
		@browser = browser
	end

	def method_missing(sym, *args, &block)
		@browser.send sym, *args, &block
	end

	def visit_LoginPage
		@browser.goto URLS[:url]
	end
  

	def enter_invalidCredentials
		(@browser.title.include? 'CharityWare').should == true
		@browser.text_field(:id, "txtUsername").set("xyz")
		@browser.text_field(:id, "txtPassword").set("xyz")
		sleep 2
		@browser.button(:value => "Log In").click
	end
	
	def verify_invalidLogin
		sleep 2
		#if (@browser.title.include? 'CharityWareAdmin').should == false
		if (@browser.text.include? "failed").should == true
 			puts ""
		else
            puts "Test failed. Failed login doesn't show any failure message!!"
		end
	end

end