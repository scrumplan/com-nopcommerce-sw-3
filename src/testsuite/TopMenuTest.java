package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //click on the ‘Computers’ Tab
        clickOnElement(By.linkText("Computers"));
        verifyElement("computer tab is not matching", "Computers", By.xpath("//h1[contains(text(),'Computers')]"));
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        //click on the ‘Electronics’ Tab ,Verify the text ‘Electronics’
        clickOnElement(By.linkText("Electronics"));
        verifyElement("Electronics tab is not matching", "Electronics", By.xpath("//h1[contains(text(),'Electronics')]"));

    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        //click on the ‘Apparel’ Tab,Verify the text ‘Apparel
        clickOnElement(By.linkText("Apparel"));
        verifyElement("Apparel tab is not matching", "Apparel", By.xpath("//h1[contains(text(),'Apparel')]"));

    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        //click on the ‘Digital downloads’ Tab Verify the text ‘Digital downloads’
        clickOnElement(By.linkText("Digital downloads"));
        verifyElement("Digital Downloads tab is not matching", "Digital downloads", By.xpath("//h1[contains(text(),'Digital downloads')]"));

    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        //* click on the ‘Books’ Tab ,Verify the text ‘Books’
        clickOnElement(By.linkText("Books"));
        verifyElement("Books tab is not matching", "Books", By.xpath("//h1[contains(text(),'Books')]"));

    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        //click on the ‘Jewelry’ Tab, Verify the text ‘Jewelry’
        clickOnElement(By.linkText("Jewelry"));
        verifyElement("Jewelry tab is not matching", "Jewelry", By.xpath("//h1[contains(text(),'Jewelry')]"));

    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        //* click on the ‘Gift Cards’ Tab,Verify the text ‘Gift Cards’
        clickOnElement(By.linkText("Gift Cards"));
        verifyElement("Gift card tab is not matching", "Gift Cards", By.xpath("//h1[contains(text(),'Gift Cards')]"));


    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
