package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {

    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        //System.setProperty("webdriver.chrome.driver" ,"chromedriver.exe");
        // Open the url into the browser
        driver.get(baseUrl);
        Thread.sleep(4000);

        // Maximise the browser
        driver.manage().window().maximize();

        // we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //Get the tittle of the page
        String title = driver.getTitle();
        System.out.println(title);
        //Get Current url
        System.out.println("The current url : " + driver.getCurrentUrl());

        //Get page Source
        System.out.println(driver.getPageSource());


        // Get Click on  forgot password link? link.
        WebElement forgotYourPassword = driver.findElement(By.className("orangehrm-login-forgot"));
        forgotYourPassword.click();
        Thread.sleep(5000);


        //Get current URL
        System.out.println("The current url : " + driver.getCurrentUrl());

        //navigate backward
        driver.navigate().back();
        System.out.println("Get current Url " + driver.getCurrentUrl());

        //refresh
        driver.navigate().refresh();
        Thread.sleep(5000);

        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");
        Thread.sleep(5000);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");
        Thread.sleep(5000);

        // Click on Login Button.
        WebElement login = driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']"));
        login.click();
        Thread.sleep(5000);
        //close
        driver.quit();

    }
}
