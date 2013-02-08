package test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

import ConnectionManager.ApproveCharityRequests;
import ConnectionManager.Charity;
import ConnectionManager.EditAccounts;

/*
 * This test case is for the form control in the CharityAdminServlet page.
 * This tests the created form is stored in "my forms".
 * In addition, this tests the stored form is viewd with the correct row(s).
 */
public class ManageApplicationTabNoNameFormCreationTest {
	WebDriver driver;

	@Before
	public void setUp(){
		//driver = new HtmlUnitDriver();

		//driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver","lib/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void test() {
        driver.get("http://localhost:8080/CharityWare/CharityAdminServlet");

        // click "Add new Form" button
        WebElement myforms = driver.findElement(By.id("myforms"));
        WebElement but = myforms.findElement(By.xpath("button[4]"));
        but.click();

        String newFormName = "";

        // click "Create this form!" button
        WebElement create = driver.findElement(By.id("btnSubmitForm"));
        create.click();

        // get latest my form from pulldown menu
        WebElement newForm = driver.findElement(By.id("myformslist"));
        Select newFormOption = new Select(newForm);
        List<WebElement> ops = newFormOption.getOptions();

        // check created form is in the pulldown menu
       	Assert.assertFalse(ops.get(ops.size() - 1).getText().equals(newFormName));
	}

	@After
	public void close(){
		driver.close();
	}
}
