package firstauto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class GuviSignupLogin {

	public static void main(String[] args) {
		  // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Launch the website
            driver.get("https://www.guvi.in/");

            // ---------------- SIGNUP PROCESS ----------------

            // Locate and click on the "Signup" button
            WebElement signupButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[5]/div[1]/div[2]/a[1]")); 
            signupButton.click();

            // Fill the Signup form fields with dummy details
            driver.findElement(By.id("name")).sendKeys("Dhinesh");
            driver.findElement(By.id("email")).sendKeys("tharmikadhinesh@gmail.com");
            driver.findElement(By.id("password")).sendKeys("Tharmika@1919");
            driver.findElement(By.id("mobileNumber")).sendKeys("9843904022");
            // Click on "Signup" button to submit the form
            WebElement submitSignup = driver.findElement(By.id("signup-btn"));           
            submitSignup.click();

            // Verify that the signup was successful by checking the page title or URL
            String signupPageTitle = driver.getTitle();
            System.out.println("Page title after Signup: " + signupPageTitle);
            driver.navigate().back();

            // ---------------- LOGIN PROCESS ----------------

            // Locate and click on the "Login" button
            
            WebElement loginButton = driver.findElement(By.xpath("//a[@id='login-btn']"));
            loginButton.click();

            // Fill the Login form fields with the same dummy credentials
            driver.findElement(By.id("email")).sendKeys("tharmikadhinesh@gmail.com");
            driver.findElement(By.id("password")).sendKeys("Tharmika@1919");

            // Click on "Login" button to submit the form
            WebElement submitLogin = driver.findElement(By.xpath("//a[@id='login-btn']"));
            submitLogin.click();

            // Verify that login was successful by checking the page title or URL
            String loginPageTitle = driver.getTitle();
            System.out.println("Page title after Login: " + loginPageTitle);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
	}

}
