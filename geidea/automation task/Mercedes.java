package geidea;

import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Mercedes {
	WebDriver driver = null;

	@BeforeMethod
	public void beforeTest() throws InterruptedException {
		File div = new File("C:\\Users\\lam20\\Downloads\\chromedriver_win32");
		System.setProperty("webdriver.chrome.driver", div.getAbsolutePath());// property for chrome browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");// get the URL
		driver.manage().window().maximize();// maximize the browser
		WebElement search = driver.findElement(By.name("q"));// inspect element by name
		search.sendKeys("Mercedes A Class");
		search.submit();
		Thread.sleep(5000);// waiting 
	}

	@Test
	public void testCase1() {

		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'engine')]"));//web elememt to find if engine word found in search results 
		if (element.getText().contains("engine")) {//if the engine word found return the page number that this result was displayed in.
			System.out.println("the search results contains 'engine'");
			WebElement page = driver.findElement(By.xpath("//table[@class=\"AaVjTc\"]/tbody/tr/td[2]"));//webelement for page 
			System.out.println("page number that contain engine is :" + page.getText());//return the page number by Text
		} else {
			System.out.println("the search results not contains 'engine'");//if engine not found 
		}
	}

	@AfterMethod
	public void AfterTest() {

		driver.quit();//terminate the webDriver 

	}

}
