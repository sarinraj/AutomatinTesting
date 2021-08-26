package learn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) {
		// System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chrome
		// driver\\chromedriver.exe");
		/*
		 * WebDriverManager.chromiumdriver().setup(); WebDriver driver = new
		 * ChromeDriver(); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * 
		 * driver.get("https://rahulshettyacademy.com/angularpractice/");
		 * 
		 * driver.findElement(By.name("name")).sendKeys("Sarin Raj");
		 * driver.findElement(By.xpath("//input[@name='email']")).sendKeys(
		 * "sarinraj50@gmail.com");
		 * driver.findElement(By.xpath("//input[@type='password']")).sendKeys(
		 * "sarinraj@123");
		 * 
		 * Select Gender = new
		 * Select(driver.findElement(By.id("exampleFormControlSelect1")));
		 * Gender.selectByVisibleText("Male");
		 * //driver.findElement(By.className("form-check-input")).click();
		 * driver.findElement(By.xpath("//input[@value='option2']")).click();
		 * driver.findElement(By.name("bday")).sendKeys("05/30/1998");
		 * driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		 */

		/*
		 * if (driver.findElement(By.className("alert alert-success alert-dismissible"))
		 * != ) { System.out.println("Test case pass");
		 * 
		 * } else { System.out.println("Test case failed"); }
		 */
		if (testing() == true) {
			System.out.println("Test case pass");
		} else {
			System.out.println("Test case failed");
		}
	}

	public static boolean testing() {
		{
			WebDriverManager.chromiumdriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			driver.get("https://rahulshettyacademy.com/angularpractice/");

			driver.findElement(By.name("name")).sendKeys("Sarin Raj");
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sarinraj50@gmail.com");
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("sarinraj@123");

			Select Gender = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
			Gender.selectByVisibleText("Male");
			// driver.findElement(By.className("form-check-input")).click();
			driver.findElement(By.xpath("//input[@value='option2']")).click();
			driver.findElement(By.name("bday")).sendKeys("05/30/1998");
			driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();

			return true;

		}
	
	}

}
