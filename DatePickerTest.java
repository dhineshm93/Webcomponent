package firstauto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DatePickerTest {	
	
	public static void main(String[] args) {
      
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            // Step 1: Navigate to the datepicker URL
            driver.get("https://jqueryui.com/datepicker/");
         // Step 2: Switch to the iframe that contains the datepicker
            driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
         // Step 3: Open the datepicker
            WebElement dateInput = driver.findElement(By.id("datepicker"));
            dateInput.click();
         // Step 4: Select the next month
            WebElement nextButton = driver.findElement(By.cssSelector(".ui-datepicker-next"));
            nextButton.click();
         // Step 5: Select the date "22"
            WebElement targetDate = driver.findElement(By.xpath("//a[text()='22']"));
            targetDate.click();
            // Step 6: Print the selected date
            System.out.println("Selected Date: " + dateInput.getAttribute("value"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 7: Close the browser and quit WebDriver
            driver.quit();
        }

	}

}
