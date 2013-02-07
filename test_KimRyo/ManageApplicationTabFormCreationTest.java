package test;

//We depend on Selenium jars (both webdriver and standalone server)
//and JUnit (3.8 here, but 4.x is completely okay as well).
//Configure the build path setting to suit your environment.

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.Assert;
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



public class ManageApplicationTabFormCreationTest {

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		//Instantiate Selenium webdriver
		//WebDriver driver = new HtmlUnitDriver();
		WebDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","lib/chromedriver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();

		//Point the webdriver to the API URI
        //driver.get("http://localhost:8080/CharityWare/charityAdmin.jsp");
        driver.get("http://localhost:8080/CharityWare/CharityAdminServlet");
        //System.out.println(driver.getPageSource());

        //WebElement but = driver.findElement(By.id("formSubmission"));
        WebElement tmp = driver.findElement(By.id("myforms"));
        WebElement but = tmp.findElement(By.xpath("button[4]"));
        but.click();

        String newFormName = "Test Form";
        WebElement formName = driver.findElement(By.id("formname"));
        formName.sendKeys(newFormName);

        String newFieldName = "Test Textbox (alpha)";
        String newFieldType = "Textbox - Alphanumeric";
        WebElement fieldName = driver.findElement(By.id("fieldname"));
        WebElement typeOptions = driver.findElement(By.id("typeoptions"));
        fieldName.sendKeys(newFieldName);
        Select typeOption = new Select(typeOptions);
        typeOption.selectByVisibleText(newFieldType);

//        WebElement row = driver.findElement(By.id("row"));
//        row.click();

        WebElement tmp1 = driver.findElement(By.id("fieldselect"));
        //WebElement but2 = tmp1.findElement(By.xpath("button[1]"));
        WebElement but2 = driver.findElement(By.id("addrow"));
        but2.click();
        System.out.println("but2: " + but2.getText());

        WebElement create = driver.findElement(By.id("btnSubmitForm"));
        create.click();

//        Select s = new Select(option0);
//        System.out.println(s.getAllSelectedOptions());
//        s.selectByIndex(0);

        WebElement newForm = driver.findElement(By.id("myformslist"));
        Select newFormOption = new Select(newForm);
        List<WebElement> ops = newFormOption.getOptions();

       	Assert.assertTrue(ops.get(ops.size() - 1).getText().equals(newFormName));

        newFormOption.selectByIndex(ops.size() - 1);
        WebElement myform = driver.findElement(By.id("myforms"));
        WebElement viewBut = myform.findElement(By.xpath("button[1]"));
        viewBut.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<WebElement>() {

			@Override
			public WebElement apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return arg0.findElement(By.className("gridtable"));
			}

		});

        WebElement table = driver.findElement(By.className("gridtable"));
        WebElement name = table.findElement(By.xpath("tr[2]/td[1]"));
        WebElement type = table.findElement(By.xpath("tr[2]/td[2]"));

       	Assert.assertTrue(name.getText().equals(newFieldName));
       	Assert.assertTrue(type.getText().equals(newFieldType));


		//driver.close();
	}

}
