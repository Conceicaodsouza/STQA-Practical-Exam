package practical;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;

public class LoginExamTest {

    WebDriver driver;

    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
    }

    @Test
    public void loginTest() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("       LOGIN AUTOMATION RESULT");
        System.out.println("========================================");

        String pagePath =
                Paths.get("exam-pages/login.html")
                     .toAbsolutePath()
                     .toUri()
                     .toString();

        driver.get(pagePath);

        // =====================================================
        // STUDENT TASK 1
        // Enter username "student"
        // =====================================================


        String enteredUsername =
                driver.findElement(By.id("username"))
                      .getAttribute("value");

        Assert.assertEquals(
                "Username validation failed",
                "student",
                enteredUsername
        );

        System.out.println("Username Entered : " + enteredUsername);
        System.out.println("Username Valid   : PASS");


        // =====================================================
        // STUDENT TASK 2
        // Enter password "1234"
        // =====================================================

        

        String enteredPassword =
                driver.findElement(By.id("password"))
                      .getAttribute("value");

        Assert.assertEquals(
                "Password validation failed",
                "1234",
                enteredPassword
        );

        System.out.println("Password Valid   : PASS");


        // =====================================================
        // STUDENT TASK 3
        // Click Login button
        // =====================================================

    


        // =====================================================
        // VALIDATION 1
        // Verify successful login using URL
        // =====================================================

        Assert.assertTrue(
                "URL validation failed",
                driver.getCurrentUrl()
                     .contains("login-success.html")
        );

        System.out.println("Login Successful : PASS");
        System.out.println("URL Validation   : PASS");


        // =====================================================
        // VALIDATION 2
        // Verify success message
        // =====================================================

        Assert.assertTrue(
                "Success message is not displayed",
                driver.findElement(By.id("successMessage"))
                     .isDisplayed()
        );

        System.out.println("Success Message  : PASS");


        // =====================================================
        // VALIDATION 3
        // Verify Logout button
        // =====================================================

        Assert.assertTrue(
                "Logout button is not displayed",
                driver.findElement(By.id("logout"))
                     .isDisplayed()
        );

        System.out.println("Logout Visible   : PASS");

        System.out.println("========================================");
        System.out.println("       TEST COMPLETED SUCCESSFULLY");
        System.out.println("========================================");
        System.out.println();
    }

    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}