package week4.day1.assignments;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon
 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get(" https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]")).click();
		
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> newWindow1=new LinkedList<String>(windowHandles1);
		driver.switchTo().window(newWindow1.get(1));
		
		String price = driver.findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium apexPriceToPay']")).getText();
		System.out.println("price: "+price);
		String review = driver.findElement(By.xpath("//span[@id='acrCustomerReviewText'][1]")).getText();
		System.out.println("number of customer rating:"+review);
		
		   driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		   Thread.sleep(3000);
		   String cartPrice = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		   System.out.println("cartPrice:"+cartPrice);
		   if(price.equals(cartPrice))
		   {
			   System.out.println("price matched");
			   
		   }
		   else
		   {
			   System.out.println("price not matched");
		   }
		
		driver.quit();
	}
	

}
 
