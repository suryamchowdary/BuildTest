package com.suryam.Buildtest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Way2SmsTest {
 public static WebDriver driver;
 
 
/*@After
 public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

     //Convert web driver object to TakeScreenshot
     TakesScreenshot scrShot =((TakesScreenshot)webdriver);
     //Call getScreenshotAs method to create image file
             File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

         //Move image file to new destination

             File DestFile=new File(fileWithPath);

             //Copy file at destination

             FileUtils.copyFile(SrcFile, DestFile);

 }*/
 
  @Test
  public void Login() {
	  driver.manage().deleteAllCookies();
	  driver.get("http://www.way2sms.com");
		driver.findElement(By.id("mobileNo")).sendKeys("7893417170");
		driver.findElement(By.id("password")).sendKeys("suryam0078");
		driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div[2]/button")).click();
		driver.close();
  }

 /* @Test
  public void Send_Sms() {
	  driver.manage().deleteAllCookies();
	  driver.get("http://www.way2sms.com");
		driver.findElement(By.id("mobileNo")).sendKeys("7893417170");
		driver.findElement(By.id("password")).sendKeys("suryam0078");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div[2]")).click();
    
  }*/

  @BeforeTest
  public WebDriver driver_intitialization() {
   
	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	ChromeDriverService service = ChromeDriverService.createDefaultService();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("test-type");
	options.addArguments("--start-maximized");
	options.addArguments("--disable-extensions");
	options.setExperimentalOption("useAutomationExtension", false);
	return driver = new ChromeDriver(service, options);
  }

 
}
