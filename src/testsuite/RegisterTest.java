package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

        String baseURL = "https://demo.nopcommerce.com/";

        @Before
        public void setUp() {
            openBrowser(baseURL);
        }

        @Test
        public void userShouldNavigateToRegisterPageSuccessfully() {
            //Find register tab and click on tab
            driver.findElement(By.xpath("//a[text()='Register']")).click();

            //Verify text on register page
            String expectedMessage = "Register";

            //Find computers text element and get the text
            WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[text()='Register']"));
            String actualMessage = actualTextMessageElement.getText();

            //Validate actual and expected
            Assert.assertEquals("Text not matched", expectedMessage, actualMessage);
        }

        @Test
        public void userShouldRegisterAccountSuccessfully() {
            //Find register tab and click on tab
            driver.findElement(By.xpath("//a[text()='Register']")).click();

            //Find gender radio button and select radio button
            driver.findElement(By.id("gender-female")).click();

            //Find first name and enter in field element
            driver.findElement(By.name("FirstName")).sendKeys("AB");

            //Find last name and enter in field element
            driver.findElement(By.name("LastName")).sendKeys("CD");

            //Find date of birth and enter in field element
            driver.findElement(By.name("DateOfBirthDay")).sendKeys("7");
            driver.findElement(By.name("DateOfBirthMonth")).sendKeys("February");
            driver.findElement(By.name("DateOfBirthYear")).sendKeys("1988");

            //Find email and enter in field element
            driver.findElement(By.name("Email")).sendKeys("abc@gmail.com");

            //Find password and confirm password and enter in field element
            driver.findElement(By.name("Password")).sendKeys("123456");
            driver.findElement(By.name("ConfirmPassword")).sendKeys("123456");

            //Find register button and click on tab
            driver.findElement(By.id("register-button")).click();

            //Verify text after registration
            String expectedMessage = "Your registration completed";

            //Find text message element and get the text
            WebElement actualTextMessageElement = driver.findElement(By.xpath("//div[text()='Your registration completed']"));
            String actualMessage = actualTextMessageElement.getText();

            //Validate actual and expected
            Assert.assertEquals("Message not matched", expectedMessage, actualMessage);
        }

        @After
        public void tearDown() {
            //closeBrowser();
        }

    }