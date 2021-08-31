package learn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewAccountSalesforce {

	public static void main(String[] args) throws InterruptedException {
	
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions notifications = new ChromeOptions();
		notifications.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(notifications);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("thauhithafridi007-ynkn@force.com");
		driver.findElement(By.id("password")).sendKeys("sarinraj12345678");
		driver.findElement(By.id("Login")).click();
		
		JavascriptExecutor JS=(JavascriptExecutor) driver;
		JS.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='Accounts']")));
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//span[text()='Account Name']/parent::label/following-sibling::div//input")).click();
		driver.findElement(By.xpath("//span[text()='Account Name']/parent::label/following-sibling::div//input")).sendKeys("Testingtime");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()='Account Name']/parent::label/following-sibling::div//input")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//a[@role='option']")).click();
		
		driver.findElement(By.xpath("//span[contains(@class,'label inputLabel')]/following-sibling::div")).click();
		driver.findElement(By.xpath("//a[text()='Analyst']")).click();
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		System.out.println(driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText());
		
		String ExpectedVerificationMessage = "Account \"TestingTime AG\" was created.";
		String ActualVerificationMessage = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		
		if (ActualVerificationMessage.contains(ExpectedVerificationMessage)) {
			System.out.println("Test completed");
		}else {
			System.out.println("Test not completed");
		}
		
		/*
		 * Select AccountType = new Select (driver.findElement(By.
		 * xpath("//span[contains(@class,'label inputLabel')]/following-sibling::div")))
		 * ; AccountType.
		 */
	}

}
//div[@data-aura-rendered-by='26:2509;a']