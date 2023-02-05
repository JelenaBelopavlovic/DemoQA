package DemoQAProject.DemoQATests;

import DemoQAProject.DemoQABaseTest.DemoBaseTest;
import DemoQAProject.DemoQAPages.DemoSidebarPage;
import DemoQAProject.DemoQAPages.DemoHomePage;
import DemoQAProject.DemoQAPages.DemoTextBoxPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

    // Obrisati thread.sleep i diver.close na kraju metoda

public class DemoTextBoxTests extends DemoBaseTest {

    @BeforeMethod
    public void setUpPage() {

        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);

        demoHomePage = new DemoHomePage();
        demoSidebarPage = new DemoSidebarPage();
        demoTextBoxPage = new DemoTextBoxPage();

    }

    public void logInToTextBox() throws InterruptedException {

        Thread.sleep(2000);
        demoSidebarPage.clickOnItems("Text Box");

        Thread.sleep(2000);
        Assert.assertTrue(demoTextBoxPage.TitleTextBox.isDisplayed());

        String expectedURL = "https://demoqa.com/text-box";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    public void assertFalseEnteredEmail() {
        boolean enteredEmail = false;
        try {
            enteredEmail = demoTextBoxPage.EnteredEmail.isDisplayed();

        } catch (Exception e) {


        }
        Assert.assertFalse(enteredEmail);
    }

    public void assertFalseEnteredCurrentAddress() {
        boolean enteredCurrentAddress = false;
        try {
            enteredCurrentAddress = demoTextBoxPage.EnteredCurrentAddress.isDisplayed();

        } catch (Exception e) {


        }
        Assert.assertFalse(enteredCurrentAddress);
    }

    public void assertFalseEnteredPermanentAddress() {
        boolean enteredPermanentAddress = false;
        try {
            enteredPermanentAddress = demoTextBoxPage.EnteredPermanentAddress.isDisplayed();

        } catch (Exception e) {


        }
        Assert.assertFalse(enteredPermanentAddress);
    }

    @Test (priority = 10)
    public void dataEnteredInAllTextBoxesAreSaved() throws InterruptedException {

        logInToElements();
        logInToTextBox();

        String validFullName = excelReader.getStringData("TextBox", 1, 0);
        demoTextBoxPage.enterFullName(validFullName);

        Thread.sleep(2000);

        String validEmail = excelReader.getStringData("TextBox", 1, 1);
        demoTextBoxPage.enterEmail(validEmail);

        String validCurrentAddress = excelReader.getStringData("TextBox", 1, 2);
        demoTextBoxPage.enterCurrentAddress(validCurrentAddress);
        scrollWindow250();

        String validPermanentAddress = excelReader.getStringData("TextBox", 1, 3);
        demoTextBoxPage.enterPermanentAddress(validPermanentAddress);

        demoTextBoxPage.clickOnSubmitButton();
        scrollWindow250();

        Assert.assertTrue(demoTextBoxPage.EnteredFullName.isDisplayed());
        Assert.assertTrue(demoTextBoxPage.EnteredEmail.isDisplayed());
        Assert.assertTrue(demoTextBoxPage.EnteredCurrentAddress.isDisplayed());
        Assert.assertTrue(demoTextBoxPage.EnteredPermanentAddress.isDisplayed());

        // Assert.assertEquals(demoTextBoxPage.getEnteredFullNameText(), validFullName);

        // Uspela sam da asertujem da su sva cetiri podatka ispisana, ali ne i da potvrdim da su jednaka
        // podacima iz excela.. tj. nece da dohvati tekst koji je ispisan

        Thread.sleep(2000);
        driver.quit();

    }

    @Test (priority = 20) // Da li bi ovde trebalo testirati svaki put drugo polje?
    public void dataEnteredInOneTextBoxAreSaved() throws InterruptedException {

        logInToElements();
        logInToTextBox();

        String validFullName = excelReader.getStringData("TextBox", 1, 0);
        demoTextBoxPage.enterFullName(validFullName);
        scrollWindow350();

        Thread.sleep(2000);
        demoTextBoxPage.clickOnSubmitButton();
        scrollWindow250();

        Assert.assertTrue(demoTextBoxPage.EnteredFullName.isDisplayed());
        assertFalseEnteredEmail();
        assertFalseEnteredCurrentAddress();
        assertFalseEnteredPermanentAddress();

        Thread.sleep(2000);
        driver.quit();

    }

    @Test (priority = 30)
    public void dataEnteredInTwoTextBoxesAreSaved() throws InterruptedException {

        logInToElements();
        logInToTextBox();

        String validFullName = excelReader.getStringData("TextBox", 1, 0);
        demoTextBoxPage.enterFullName(validFullName);
        String validEmail = excelReader.getStringData("TextBox", 1, 1);
        demoTextBoxPage.enterEmail(validEmail);

        scrollWindow350();
        Thread.sleep(2000);
        demoTextBoxPage.clickOnSubmitButton();
        scrollWindow250();

        Assert.assertTrue(demoTextBoxPage.EnteredFullName.isDisplayed());
        Assert.assertTrue(demoTextBoxPage.EnteredEmail.isDisplayed());
        assertFalseEnteredCurrentAddress();
        assertFalseEnteredPermanentAddress();

        Thread.sleep(2000);
        driver.quit();
    }

    @Test (priority = 40)
    public void dataEnteredInThreeBoxesAreSaved() throws InterruptedException {

        logInToElements();
        logInToTextBox();

        String validFullName = excelReader.getStringData("TextBox", 1, 0);
        demoTextBoxPage.enterFullName(validFullName);
        String validEmail = excelReader.getStringData("TextBox", 1, 1);
        demoTextBoxPage.enterEmail(validEmail);
        String validCurrentAddress = excelReader.getStringData("TextBox", 1, 2);
        demoTextBoxPage.enterCurrentAddress(validCurrentAddress);

        scrollWindow350();
        Thread.sleep(2000);
        demoTextBoxPage.clickOnSubmitButton();
        scrollWindow250();

        Assert.assertTrue(demoTextBoxPage.EnteredFullName.isDisplayed());
        Assert.assertTrue(demoTextBoxPage.EnteredEmail.isDisplayed());
        Assert.assertTrue(demoTextBoxPage.EnteredCurrentAddress.isDisplayed());
        assertFalseEnteredPermanentAddress();

        Thread.sleep(2000);
        driver.quit();
    }

    @AfterMethod
    public void shutDown() {

      // driver.manage().deleteAllCookies();
      // driver.close();

    }


}
