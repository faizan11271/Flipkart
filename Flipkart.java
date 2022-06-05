package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Flipkart {

	WebDriver d;
	@BeforeMethod
	public void setup()
	{
		//launch the browser
		System.setProperty("webdriver.gecko.driver","C:\\Users\\FAIZAN\\Downloads\\geckodriver-v0.30.0-win32\\geckodriver.exe");
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	  @Test
	  public void test() throws InterruptedException
	  {
		  //load web page
		 d.get("https://www.flipkart.com/");
		// cancel the login page
		d.findElement(By.xpath("//div/div/button")).click();
		 //search the product
		 d.findElement(By.name("q")).sendKeys("iphone"+Keys.ENTER);
	     //click on first product
		 d.findElement(By.className("_2kHMtA")).click();
		 Thread.sleep(2000);
	      WebElement k=d.findElement(By.xpath("//div[@class=\"_30jeq3 _16Jk6d\"]"));
		 Thread.sleep(2000);
		 String text=k.getText();
		 System.out.println("price of mobile="+text);
		//click add to cart button
		d.findElement(By.xpath("//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")).click();
		Thread.sleep(2000);
		//click to + button
		 d.findElement(By.xpath("//button[2]")).click();
		 Thread.sleep(2000);
		 //print the final price
		 WebElement k1=d.findElement(By.xpath("//span[@class=\"_2-ut7f _1WpvJ7\"]"));
		 String text1=k1.getText();
		 System.out.println("after 1 mobile add in the cart the final price is="+text);
		 
	  }
		
		
	  
	  
	  @AfterMethod
	  public void teardown()
	  {
		  //close the page
		 d.quit();
	  }

}


