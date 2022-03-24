package week4.day1.assignments;

import java.time.Duration;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundFrame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
List<WebElement> f= driver.findElements(By.tagName("iframe"));
System.out.println("Total Number" +f.size());
		

		driver.close();
	}

	

}
