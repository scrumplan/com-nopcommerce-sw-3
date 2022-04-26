package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){

        //click on the ‘Register’ link, Verify the text ‘Register
        clickOnElement(By.linkText("Register"));
        verifyElement("Register tab is not matching","Register",By.xpath("//h1[contains(text(),'Register')]"));

    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        String expectedMessage ="Your registration completed";
        //click on the ‘Register’ link
        clickOnElement(By.linkText("Register"));
        //Select gender radio button
        clickOnElement(By.id("gender-female"));
        //Enter First name
        sendTextToElement(By.id("FirstName"),"Lalita");
        //Enter Last name
        sendTextToElement(By.id("LastName"),"Desai");
        //Select Day Month and Year
        selectByValueFromDropDown(By.name("DateOfBirthDay"),"5");

        selectByVisibleTextFromDropDown(By.name("DateOfBirthMonth"),"May");

        selectByValueFromDropDown(By.name("DateOfBirthYear"),"1980");

        //Enter Email address
        sendTextToElement(By.id("Email"),"Lalita1221@gmail.com");

        // Enter Password
        sendTextToElement(By.id("Password"),"Lalita123");

        //Enter Confirm password
        sendTextToElement(By.id("ConfirmPassword"),"Lalita123");

        //Click on REGISTER button
        clickOnElement(By.id("register-button"));
        verifyElement("Registered not completed","Your registration completed",By.xpath("//div[contains(text(),'Your registration completed')]"));



    }
    @After
    public void tearDown() {
        closeBrowser();

}}
