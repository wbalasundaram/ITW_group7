class AdminPage

	attr_accessor :user_field, :password_field, :signon_button

	URLS = { :url => "http://localhost:8080/CharityWare/uclAdmin.jsp"}


	def initialize(browser)
		@browser = browser
	end

	def method_missing(sym, *args, &block)
		@browser.send sym, *args, &block
	end

	def visit_CharityAdminPage
		@browser.goto URLS[:url]
	end
  

	def verify_unauthorizedAccess
		sleep 2
		@browser.element(:id => "tab_2").click
		sleep 2
		@browser.element(:id => "tab_3").click
		if (@browser.title.include? 'CharityWare').should == false
 			puts ""
		else
            puts "Test failed. Unauthorized access to the page!!"
		end
	end

	def click_Approve
		@browser.radio(:id => "reject0").set
#(:id => "reject0").set
	end
	
	def verify_requestRemoved
		if (@browser.text.include? "Carers UK").should == true
 			puts ""
		else
            puts "Test Failed. Result was not removed after approved"
		end
	end
end