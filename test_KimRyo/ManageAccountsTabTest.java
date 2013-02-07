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
import ConnectionManager.EditAccounts;



public class ManageAccountsTabTest {

	@Test
	public void test() {
		//Instantiate Selenium webdriver
		//WebDriver driver = new HtmlUnitDriver();
		WebDriver driver = new FirefoxDriver();

		//Point the webdriver to the API URI
        driver.get("http://localhost:8080/CharityWare/uclAdmin.jsp");
        //System.out.println(driver.getPageSource());

        WebElement tab = driver.findElement(By.id("tab_2"));
        tab.click();

        WebElement manageAccounts = driver.findElement(By.id("content_2"));
        System.out.println("first: "+manageAccounts);

        WebElement manageAccountsTable = manageAccounts.findElement(By.xpath("form/table/tbody"));
//        WebElement tmp = manageAccounts.findElement(By.xpath("form/table/tbody/tr[2]/td[5]"));
//        System.out.println("tmp: "+tmp.getText());

        WebElement charityName = manageAccountsTable.findElement(By.xpath("tr[2]/td[2]"));
        WebElement charityEmail = manageAccountsTable.findElement(By.xpath("tr[2]/td[3]"));
        WebElement purpose = manageAccountsTable.findElement(By.xpath("tr[2]/td[4]"));

        List<Charity> charityFromXML;
		try {
			charityFromXML = EditAccounts.httpGet("http://localhost:8080/CharityWare/REST/charity/charities");
			String charityNameFromXML = charityFromXML.get(0).getCharityName();
			String charityEmailFromXML = charityFromXML.get(0).getEmail();

			System.out.println(charityName.getText());
			System.out.println(charityFromXML.get(0).getCharityName());

			Assert.assertTrue("charity name match", charityName.getText().equals(charityNameFromXML));
			Assert.assertTrue("charity email match", charityEmail.getText().equals(charityEmailFromXML));

			if(charityFromXML.get(0).getCharityDescription() != null){
				String purposeFromXML = charityFromXML.get(0).getCharityDescription().trim();
				Assert.assertTrue("puropse match", purpose.getText().trim().equals(purposeFromXML));
			}
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
