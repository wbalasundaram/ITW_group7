package test;

//We depend on Selenium jars (both webdriver and standalone server)
//and JUnit (3.8 here, but 4.x is completely okay as well).
//Configure the build path setting to suit your environment.

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

import ConnectionManager.ApproveCharityRequests;
import ConnectionManager.Charity;
import ConnectionManager.EditAccounts;



public class ManageApplicationTabTest {

	@Test
	public void test() {
		//Instantiate Selenium webdriver
		//WebDriver driver = new HtmlUnitDriver();
		WebDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","lib/chromedriver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();

		//Point the webdriver to the API URI
        driver.get("http://localhost:8080/CharityWare/charityAdmin.jsp");
        //System.out.println(driver.getPageSource());

        WebElement but = driver.findElement(By.tagName("button"));
        but.click();

        WebElement formWizard = driver.findElement(By.tagName("legend"));
        WebElement typeOptions = driver.findElement(By.id("typeoptons"));

        WebElement option0 = typeOptions.findElement(By.xpath("option[0]"));

//        Select s = new Select(option0);
//        System.out.println(s.getAllSelectedOptions());
//        s.selectByIndex(0);

        Assert.assertTrue(formWizard.isDisplayed());
        Assert.assertTrue(option0.isDisplayed());

//        List<Charity> charityFromXML;
//		try {
//			charityFromXML = EditAccounts.httpGet("http://localhost:8080/CharityWare/REST/charity/charities");
//			String charityNameFromXML = charityFromXML.get(0).getCharityName();
//			String charityEmailFromXML = charityFromXML.get(0).getEmail();
//
//			System.out.println(charityName.getText());
//			System.out.println(charityFromXML.get(0).getCharityName());
//
//			Assert.assertTrue("charity name match", charityName.getText().equals(charityNameFromXML));
//			Assert.assertTrue("charity email match", charityEmail.getText().equals(charityEmailFromXML));
//
//			if(charityFromXML.get(0).getCharityDescription() != null){
//				String purposeFromXML = charityFromXML.get(0).getCharityDescription().trim();
//				Assert.assertTrue("puropse match", purpose.getText().trim().equals(purposeFromXML));
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		//driver.close();
	}

}
