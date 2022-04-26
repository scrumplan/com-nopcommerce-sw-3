package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        //click on the ‘Login’ link
        clickOnElement(By.linkText("Log in"));

        //This is from requirement
        String expectedMessage = "Welcome, Please Sign In!";

        //find the welcome text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        verifyElement("Login page message is not matching",expectedMessage,By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        String expectedMessage = "Log out";
        clickOnElement(By.linkText("Log in"));

        sendTextToElement(By.id("Email"),"Lalita1234+@gmail.com");
        //Enter valid password
        sendTextToElement(By.id("Password"),"Lalita123");

        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        String actualMessage = getTextFromElement(By.xpath("//a[contains(text(),'Log out')]"));
        verifyElement("Log out text is not matching",expectedMessage,By.xpath("//a[contains(text(),'Log out')]"));

    }

    @Test
    public void verifyTheErrorMessage() {
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";

        //click on the ‘Login’ link
        clickOnElement(By.linkText("Log in"));

        //Enter invalid username
        sendTextToElement(By.id("Email"),"abcd1234@gmail.com");

        //Enter invalid password
        sendTextToElement(By.id("Password"),"abcd1234");

        //Click on Login button
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));


        //Verify the error message
        String actualMessage = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]"));
        verifyElement("Error Message not displayed",expectedMessage,By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]"));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
