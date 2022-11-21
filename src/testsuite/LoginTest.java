package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    // Locate Login button and click on it
    public void userShouldNavigateToLoginPageSuccessfully() {
        //  WebElement loginTab = driver.findElement(By.linkText("Log in"));
        // loginTab.click();

        driver.findElement(By.linkText("Log in")).click();

        String expectedMessage = "Welcome, Please Sign In!";

        WebElement actualTextMessage = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualTextMessage.getText();

        //Validate actual and expected
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        WebElement logInlink = driver.findElement(By.linkText("Log in"));
        logInlink.click();

        // find email field element
        WebElement email = driver.findElement(By.name("Email"));
        email.sendKeys("abc@gmail.com");

        // find password field element
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");

        // find log in element and click on login button
        driver.findElement(By.xpath("//button{contains(text(),'Log in")).click();


        // verify the 'Log out' text is display
        // find Logout element
        WebElement logout = driver.findElement(By.linkText("Log out"));

        //get text on logout element
        String actualText = logout.getText();
        System.out.println(actualText);
        String expectedText = "Log out";
        Assert.assertEquals("Verifying logouttest:", expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessage() {
        WebElement logInLink = driver.findElement(By.linkText("Log in"));
        logInLink.click();

        // This is from requirement
        driver.findElement(By.name("Email")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

        // Verify login unsuccsesful message
        String expectedMessagetext2 = "Login was uncussessful, Please correct the errors and try again.\n" + "No Customer account found";


        //Location what actually message it shows when you enter invalid username and password
        WebElement actualMessagetext = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualMessage2 = actualMessagetext.getText();

        Assert.assertEquals("No such message is displayed", actualMessage2, expectedMessagetext2);


    }

    @After
    public void teardown() {
        closeBrowser();
    }

}










