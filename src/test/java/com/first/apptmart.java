package com.first;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class apptmart {
	WebDriver driver;
	
  @Test
	public void shopping() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://qa.apptmart.com:8083"); // go to the site
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		// sign in 
		
		driver.findElement(By.xpath("//div[@class='text-value ng-star-inserted']")).click();  
		driver.findElement(By.cssSelector("input[inputmode='numeric']")).sendKeys("8983372236");
		driver.findElement(By.xpath("//span[text()='Send OTP']")).click();
		Thread.sleep(3000);
		
		//enter OTP
		
		driver.findElement(By.xpath("//input[@class='otp-input ng-untouched ng-pristine ng-valid ng-star-inserted'][1]")).click();
		WebElement el =driver.findElement(By.xpath("//input[@class='otp-input ng-untouched ng-pristine ng-valid ng-star-inserted'][1]"));
		Actions ac = new Actions (driver);
		ac.moveToElement(el).click().sendKeys("1").sendKeys("2").sendKeys("3").sendKeys("4").sendKeys("5").sendKeys("6").build().perform();
		driver.findElement(By.xpath("//button[@class='secondary']")).click();
		Thread.sleep(3000);
		
		//search fresh cow ghee 1 litre
		
		driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("FRESH COW GHEE 1 LITRE");
		driver.findElement(By.xpath("//i[@id='fa-foodie']")).click();
		
		//add fresh cow ghee 1 litre into cart and add wishlist
		
		driver.findElement(By.xpath("//span[@class='wishlist-icon ng-star-inserted']")).click();
		driver.findElement(By.xpath("//button[@class='add-cart']")).click();
		
		//added item proceed to checkout
		
		driver.findElement(By.xpath("//span[@class='circle-bg']//span[@class='icon-shopping-cart ng-star-inserted']")).click();
		driver.findElement(By.xpath("//button[@class='proceed-to-checkout-btn ng-star-inserted']")).click();
		Thread.sleep(5000);
		
		//select address and select payment method
		
		driver.findElement(By.xpath("//div[@class='proceed-btn-container ng-star-inserted']/button")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Cash on delivery')]")).click();
		
		
	}



}
