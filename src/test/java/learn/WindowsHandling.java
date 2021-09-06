package learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeOptions Notification = new ChromeOptions();
		Notification.addArguments("--disable-notification");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://dev107375.service-now.com/");
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//label[text()='User name']/following-sibling::input")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Testing@123");
		driver.findElement(By.id("sysverb_login")).click();

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[contains(@class,'pro-dev')]")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		System.out.println("\n");
		System.out.println(windowHandles);
		List<String> listWindowsHandles = new ArrayList<String>();
		listWindowsHandles.addAll(windowHandles);

		System.out.println("\n");
		for (int i = 0; i < listWindowsHandles.size(); i++) {
			System.out.println(listWindowsHandles.get(i));
			// System.out.println(windowHandle.equals(listWindowsHandles.get(i)));
			if (windowHandle.equals(listWindowsHandles.get(i))) {

			} else {
				driver.switchTo().window(listWindowsHandles.get(i));
				driver.close();
			}
		}
		
		System.out.println("\n");
		String TitleExpected = "ServiceNow";
		String TitleActual = driver.switchTo().window(windowHandle).getTitle();
		//System.out.println(TitleActual);
		if (TitleActual.equals(TitleExpected)) {
			System.out.println("Test case passed");
		} else {
			System.out.println("Test case failed");
		}
	}
}
