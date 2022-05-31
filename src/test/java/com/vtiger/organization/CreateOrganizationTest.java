package com.vtiger.organization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtility.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateOrganizationTest {
	public static void main(String[] args) 
	{
		//PropertyFileUtility plib = new PropertyFileUtility();
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.get("http://localhost:8888");
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.xpath("//a[.='Organizations']")).click();
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("sony113");
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
        String actRes = ele.getText();
        if(actRes.contains("sony113"))
        		{
        	     System.out.println("organization is created- TC PASS");
        }else		{
   	     System.out.println("organization is not created- TC PASS");
   }
        WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        Actions act = new Actions(driver);
        act.moveToElement(ele1).perform();
        driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
    }
}
