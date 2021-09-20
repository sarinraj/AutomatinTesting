package learn;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class CreateNewTaskInSalesforce {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeOptions notifications = new ChromeOptions();
		notifications.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(notifications);
		System.out.println(driver.getCapabilities().asMap());
		notifications.setExperimentalOption("debuggerAddress", "localhost:51182");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("thauhithafridi007-ynkn@force.com");
		driver.findElement(By.id("password")).sendKeys("sarinraj12345678");
		driver.findElement(By.id("Login")).click();

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//input[@aria-invalid='false']")).click();
		driver.findElement(By.xpath("//input[@aria-invalid='false']")).sendKeys("Task");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();

		driver.findElement(By.xpath("//div[contains(@class,'slds-context-bar__label-action slds-p-left--none ')]/child::one-app-nav-bar-menu-button")).click();
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='New Task']")));

		// WebDriverWait wait = new WebDriverWait (driver,10);
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[text()='Subject']/following-sibling::div"))));

		driver.findElement(By.xpath("//label[text()='Subject']/following-sibling::div//child::input")).sendKeys("Testing");
		driver.findElement(By.xpath("//span[@data-aura-class='uiPicklistLabel']/following-sibling::div")).click();
		driver.findElement(By.xpath("//a[text()='High']")).click();
		driver.findElement(By.xpath("//span[text()='Status']/parent::span//following-sibling::div")).click();
		driver.findElement(By.xpath("//a[text()='Completed']")).click();

		LocalDate Today = LocalDate.now();
		driver.findElement(By.xpath("(//td[@data-datevalue='" + Today.plusDays(7) + "']/span)[2]")).click();

		WebElement dateSelection = driver.findElement(By.xpath("(//td[@data-datevalue='" + Today.plusDays(7) + "']/span)[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", dateSelection);
		// driver.findElement(By.xpath("//td[@data-aura-rendered-by='2118:0']")).click();

		driver.findElement(By.xpath("//span[text()='Save']")).click();

		String ExpectedResult = "Task Testing was created";
		String ActualResult = driver.findElement(By.xpath("//div[@data-aura-rendered-by='5159:0']")).getText();

		if (ExpectedResult.equals(ActualResult)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}

		List<WebElement> TaskVerification = driver.findElements(By.xpath("//tbody"));
		WebElement Task = driver.findElement(By.xpath("//a[text()='Testing']"));
		String TestingTask = Task.getText();

		for (int i = 0; i < TaskVerification.size(); i++) {
			System.out.println(TaskVerification.get(i).getText());
			if (TaskVerification.contains(TestingTask)) {
				System.out.println("Testcase pass");
			} else {
				System.out.println("Testcase Failed");
			}
		}

	}

}
