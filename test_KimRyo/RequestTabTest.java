package test;

//We depend on Selenium jars (both webdriver and standalone server)
//and JUnit (3.8 here, but 4.x is completely okay as well).
//Configure the build path setting to suit your environment.

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import ConnectionManager.ApproveCharityRequests;
import ConnectionManager.Charity;



public class RequestTabTest {

	@Test
	public void test() {
		//Instantiate Selenium webdriver
		//WebDriver driver = new HtmlUnitDriver();
		WebDriver driver = new FirefoxDriver();

		//Point the webdriver to the API URI
        driver.get("http://localhost:8080/CharityWare/uclAdmin.jsp");

        WebElement requestTable = driver.findElement(By.className("resultSet"));
        //System.out.println("first: " + first);

        WebElement charityName = requestTable.findElement(By.xpath("tbody/tr[2]/td[2]"));
        WebElement regNum = requestTable.findElement(By.xpath("tbody/tr[2]/td[3]"));
        WebElement charityEmail = requestTable.findElement(By.xpath("tbody/tr[2]/td[4]"));
        WebElement purpose = requestTable.findElement(By.xpath("tbody/tr[2]/td[5]"));

        List<Charity> charityFromXML;
		try {
			charityFromXML = ApproveCharityRequests.httpGet("http://localhost:8080/CharityWare/REST/charity/charities");
			String charityNameFromXML = charityFromXML.get(0).getCharityName();
			String regNumFromXML = charityFromXML.get(0).getRegistrationNo();
			String charityEmailFromXML = charityFromXML.get(0).getEmail();
			String purposeFromXML = charityFromXML.get(0).getCharityDescription().trim();

			Assert.assertTrue("charity name match", charityName.getText().equals(charityNameFromXML));
			Assert.assertTrue("registration num match", regNum.getText().equals(regNumFromXML));
			Assert.assertTrue("charity email match", charityEmail.getText().equals(charityEmailFromXML));
			Assert.assertTrue("puropse match", purpose.getText().trim().equals(purposeFromXML));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//driver.close();
	}

}
