package week4.day1.assignments;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		
		// * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		// * 2. Enter UserName and Password Using Id Locator
		// * 3. Click on Login Button using Class Locator
		//* 4. Click on CRM/SFA Link
		//* 5. Click on contacts Button
		//* 6. Click on Merge Contacts using Xpath Locator
		//* 7. Click on Widget of From Contact
	// * 8. Click on First Resulting Contact
	 //* 9. Click on Widget of To Contact
		// * 10. Click on Second Resulting Contact
		 //* 11. Click on Merge button using Xpath Locator
		 //* 12. Accept the Alert
		 //* 13. Verify the title of the page
		 
WebDriverManager.chromedriver().setup();
ChromeDriver driver= new ChromeDriver();
driver.get("http://leaftaps.com/opentaps/control/login");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
driver.findElement(By.id("username")).sendKeys("demoSalesManager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
driver.findElement(By.className("decorativeSubmit")).click();
driver.findElement(By.linkText("CRM/SFA")).click();
driver.findElement(By.xpath("//a[text()='Contacts']")).click();
driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
driver.findElement(By.xpath("//td[@class='titleCell']//following::a[1]")).click();
//1st window
Set<String> windowhandles1 = driver.getWindowHandles();
	List<String> newWindow1=new LinkedList<String>(windowhandles1);
	driver.switchTo().window(newWindow1.get(1));
	driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
	
	driver.switchTo().window(newWindow1.get(0));
	driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']//following::a")).click();
	
	//2nd window
	Set<String> windowhandles2 = driver.getWindowHandles();
	List<String> newWindow2=new LinkedList<String>(windowhandles2);
	driver.switchTo().window(newWindow2.get(1));
	driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
	driver.switchTo().window(newWindow1.get(0));
	//parent page
	driver.findElement(By.xpath("//a[text()='Merge']")).click();
	Alert alert = driver.switchTo().alert();
	alert.accept();
	Thread.sleep(2000);
	String title = driver.getTitle();
	System.out.println(title);
	driver.quit();
	}

}
