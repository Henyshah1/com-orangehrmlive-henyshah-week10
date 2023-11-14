package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowserTest {
    public static void main(String[] args) throws InterruptedException {


        String baseUrl = "https://opensource-demo.orangehrmlive.com/";

        //launch the Chrome Browser
        WebDriver driver = new ChromeDriver();

        //Open the URL into Browser
        driver.get(baseUrl);
        Thread.sleep(5000);
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
        Thread.sleep(4000);



        //close
        driver.quit();


    }
}
