require "rubygems"
require "watir-webdriver"

browser = Watir::Browser.new :firefox

#browser2 = Watir::Browser.new :firefox

WEBDRIVER = true

Before do
  @browser = browser
  #@browser2 = browser2
end

