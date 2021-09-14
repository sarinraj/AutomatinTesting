package learn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateErrorMessage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions notifications = new ChromeOptions();
		notifications.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(notifications);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("thauhithafridi007-ynkn@force.com");
		driver.findElement(By.id("password")).sendKeys("sarinraj12345678");
		driver.findElement(By.id("Login")).click();
		
		/*
		 * WebElement Account =
		 * driver.findElement(By.xpath("//a[@title='Accounts']/child::span"));
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", Account);
		 * 
		 * driver.findElement(By.xpath("//div[text()='New']")).click();
		 */
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//input[@aria-invalid='false']")).click();
		driver.findElement(By.xpath("//input[@aria-invalid='false']")).sendKeys("Task");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		
		driver.findElement(By.xpath("//li[@class='oneActionsDropDown']")).click();
		driver.findElement(By.xpath("//a[@title='New Task']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button--neutral uiButton--brand')]/child::span")).click();
		
		WebElement ErrorReview = driver.findElement(By.xpath("//span[text()='Review the errors on this page.']"));
		WebElement RequiredFieldError = driver.findElement(By.xpath("//li[text()='These required fields must be completed: Subject']"));
		WebElement FieldError = driver.findElement(By.xpath("//div[text()='Complete this field.']"));
		
		String ActualErrorReview = ErrorReview.getText();
		String ExpectedErrorReview= "Review the errors on this page.";
		
		String ActualRequiredFieldError = RequiredFieldError.getText();
		String ExpectedRequiredFieldError = "These required fields must be completed: Subject";
		
		String ActualFieldError = FieldError.getText();
		String ExpectedFieldError= "Complete this field.";
		
		if (ActualErrorReview.equals(ExpectedErrorReview)) {
			System.out.println(ActualErrorReview+" = "+ExpectedErrorReview+" :: "+"ErrorVerified-TestCasePassed");
		}else {
			System.out.println(ActualErrorReview+" != "+ExpectedErrorReview+" :: "+"ErrorVerified-TestCaseFailed");
		}
		
		if (ActualRequiredFieldError.equals(ExpectedRequiredFieldError)) {
			System.out.println(ActualRequiredFieldError+" = "+ExpectedRequiredFieldError+" :: "+"ErrorVerified-TestCasePassed");
		}else {
			System.out.println(ActualRequiredFieldError+" != "+ExpectedRequiredFieldError+" :: "+"ErrorVerified-TestCaseFailed");
		}
		
		if (ActualFieldError.equals(ExpectedFieldError)) {
			System.out.println(ActualFieldError+ " = "+ExpectedFieldError+" :: "+"ErrorVerified-TestCasePassed");
		}else {
			System.out.println(ActualFieldError+" != "+ExpectedFieldError+" :: "+"ErrorVerified-TestCaseFailed");
		}
	}
	
}
