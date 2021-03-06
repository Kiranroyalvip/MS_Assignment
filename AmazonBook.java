package Introduction.SeleniumTesting;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;

public class AmazonBook {
      public static void main(String[] args) throws InterruptedException {
    	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
  		  WebDriver driver=new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		  driver.manage().window().maximize();
		  
		  driver.get("https://www.indiabookstore.net/");
		  driver.getTitle();
		  driver.findElement(By.xpath("//div[@id='mainSearchDiv']//input")).click();
		  driver.findElement(By.xpath("//div[@id='mainSearchDiv']//input")).sendKeys("Selenium");
		  driver.findElement(By.xpath("//span[@class='input-group-btn']")).click();
		  driver.findElement(By.xpath("//div[@id='searchpage-left-content']//div[@class='coverImage center-align-util']//img[contains(@title,'Selenium testing tools Cookbook | By: Roy De Kleijn')]")).click();
		  Thread.sleep(1000);
		  WebElement FirstISBN=driver.findElement(By.xpath("//div[@class=' col-xs-9 col-smx-10 col-sm-9 col-md-9 modal-book-content']//div[@class='isbnContainer']"));
		  String FirstISBN1=FirstISBN.getText();
		  
		  
		  driver.findElement(By.xpath("//*[@id=\"bookInfoWindow\"]/div/div/div[2]/div[2]/div[2]/div[3]/a")).click();
		  
		    //switch window;
			Set<String> ids=driver.getWindowHandles();
			java.util.Iterator<String> it=ids.iterator();
			String parentid=it.next();
			String childid=it.next();
			driver.switchTo().window(childid);
			System.out.println(driver.getTitle());
			
			WebElement SecondISBN=driver.findElement(By.xpath("//div[@id='detailBulletsWrapper_feature_div']//ul//li[5]//span[2]"));
			String SecondISBN1=SecondISBN.getText();
			
			System.out.println(FirstISBN1);
			System.out.println(SecondISBN1);
			
			int point=0;
			for(int i=0,j=0;i<SecondISBN1.length();)
			{
				if(SecondISBN1.charAt(i)=='-')
				{
					i++;
				}
				else
				{
					if(SecondISBN1.charAt(i)!=FirstISBN1.charAt(j))
					{
						point=1;
						break;
					}
					else
					{
						i++;
						j++;
					}
				}
			}
			if(point==0)
				System.out.println("ISBN Matched");
			else
				System.out.println("ISBN not Matched");
		    
			
			WebElement Availability=driver.findElement(By.id("availability"));
			String Available=Availability.getText();
			System.out.println(Available);
			
			
			WebElement Price=driver.findElement(By.xpath("//div[@class='a-column a-span8 a-text-right a-span-last']//span[@id='price']"));
			String Price1=Price.getText();
			System.out.println(Price1);
		
		  
	}
}
