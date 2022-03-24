package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleFrameExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input")).sendKeys("Learn iframe");
		WebElement frame3 = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.id("a")).click();
		driver.switchTo().defaultContent();//go to webpage
		
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame2);
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='animals']"));
		Select check=new Select(dropdown);
		check.selectByVisibleText("Baby Cat");
		Thread.sleep(2000);
		String title=driver.getTitle();
		System.out.println(title);
		driver.switchTo().defaultContent();
		driver.close();
		
		
		

	}

}
