class LoginPagePos

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
  

	def enter_validCredentials
		(@browser.title.include? 'CharityWare').should == true
		@browser.text_field(:id, "txtUsername").set("ucladmin")
		@browser.text_field(:id, "txtPassword").set("open")
		@browser.button(:value => "Log In").click
	end
  
	def verify_validLogin
		if (@browser.title.include? 'CharityWareAdmin').should == true
 			#puts ""
		else
            puts "Test failed."
		end
	end

end


