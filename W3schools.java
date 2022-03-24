package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class W3schools {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm
Click Try It Button
Click OK/Cancel in the alert
Confirm the action is performed correctly by verifying the text !!
 *Hint*
Switch to the frame
Then click Try It with xpath
Switch to the alert
Then perform accept / dismiss
Get the text using id 
Verify the text based on the action

 */
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
	driver.switchTo().frame(frame1);
	driver.findElement(By.xpath("//button[text()='Try it']")).click();
	Alert alert = driver.switchTo().alert();
	String alrtmsg = alert.getText();
	System.out.println(alrtmsg);
	alert.accept();
	String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
	System.out.println("output text is:"+text);
	

	
	
	
	driver.close();
	
	}

}
