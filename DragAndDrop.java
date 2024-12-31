package firstauto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class DragAndDrop {

	public static void main(String[] args) {
		// Initialize the WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            // Step 1: Navigate to the jQueryUI droppable URL
            driver.get("https://jqueryui.com/droppable/");

            // Step 2: Switch to the iframe that contains the drag-and-drop elements
            driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

            // Step 3: Locate the source and target elements
            WebElement sourceElement = driver.findElement(By.id("draggable"));
            WebElement targetElement = driver.findElement(By.id("droppable"));

            // Step 4: Perform the drag-and-drop action
            Actions actions = new Actions(driver);
            actions.dragAndDrop(sourceElement, targetElement).perform();

            // Step 5: Verify the drop operation
            String droppedText = targetElement.getText();
            if (droppedText.equals("Dropped!")) {
                System.out.println("Drag and Drop operation was successful.");
            } else {
                System.out.println("Drag and Drop operation failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the browser and quit WebDriver
            driver.quit();
        }

	}

}
