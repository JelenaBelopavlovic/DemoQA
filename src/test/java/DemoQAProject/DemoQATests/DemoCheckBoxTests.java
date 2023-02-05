package DemoQAProject.DemoQATests;

import DemoQAProject.DemoQABaseTest.DemoBaseTest;
import DemoQAProject.DemoQAPages.DemoCheckBoxPage;
import DemoQAProject.DemoQAPages.DemoHomePage;
import DemoQAProject.DemoQAPages.DemoSidebarPage;
import DemoQAProject.DemoQAPages.DemoTextBoxPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoCheckBoxTests extends DemoBaseTest {


    @BeforeMethod
    public void setUpPage() {

        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);

        demoHomePage = new DemoHomePage();
        demoSidebarPage = new DemoSidebarPage();
        demoTextBoxPage = new DemoTextBoxPage();
        demoCheckBoxPage = new DemoCheckBoxPage();

    }


    public void logInToCheckBox() throws InterruptedException {

       // waitForClickability(demoSidebarPage.clickOnItems("Check Box")); trazi mi da metod u Side bar
                                                                         // ne bude void nego Web element

        Thread.sleep(4000);
        scrollWindow250();
        demoSidebarPage.clickOnItems("Check Box");

        waitForVisibility(demoCheckBoxPage.TitleCheckBox);
        /* Assert.assertTrue(demoCheckBoxPage.TitleCheckBox.isDisplayed()); */

        Assert.assertEquals(demoCheckBoxPage.getTitleCheckBoxText(), "Check Box");

        String expectedURL = "https://demoqa.com/checkbox";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }



    @Test (priority = 10)
    public void homeCheckBoxCanBeMarkedAndUnmarked() throws InterruptedException {

        logInToElements();
        logInToCheckBox();

        driver.navigate().refresh();
        waitForVisibility(demoCheckBoxPage.HomeCheckBox);

        if (demoCheckBoxPage.homeCheckBoxIsSelected() == false) {
            demoCheckBoxPage.clickOnHomeCheckBox();
        }

        Assert.assertTrue(demoCheckBoxPage.SelectedBoxesNotification.isDisplayed());

        demoCheckBoxPage.clickOnHomeCheckBox();
        Assert.assertFalse(demoCheckBoxPage.notificationSelectedBoxes());

        Thread.sleep(2000);
        driver.quit();
    }

    @Test (priority = 20)
    public void homeArrowOpensNewArrowsAndCheckBoxes() throws InterruptedException {

        logInToElements();
        logInToCheckBox();

        driver.navigate().refresh();
        waitForVisibility(demoCheckBoxPage.HomeArrow);
        demoCheckBoxPage.clickOnHomeArrow();

        Thread.sleep(2000);
        Assert.assertTrue(demoCheckBoxPage.getDesktopArrow().isDisplayed());
        Assert.assertTrue(demoCheckBoxPage.getDocumentsArrow().isDisplayed());
        Assert.assertTrue(demoCheckBoxPage.getDownloadsArrow().isDisplayed());

        Assert.assertTrue(demoCheckBoxPage.getDesktopCheckBox().isDisplayed());
        Assert.assertTrue(demoCheckBoxPage.getDocumentsCheckBox().isDisplayed());
        Assert.assertTrue(demoCheckBoxPage.getDownloadsCheckBox().isDisplayed());

        Thread.sleep(2000);
        driver.quit();

    }

    @Test (priority = 30)
    public void desktopCheckBoxCanBeMarkedAndUnmarked() throws InterruptedException {

        logInToElements();
        logInToCheckBox();

        driver.navigate().refresh();
        waitForClickability(demoCheckBoxPage.HomeArrow);
        demoCheckBoxPage.clickOnHomeArrow();

        waitForClickability(demoCheckBoxPage.getDesktopCheckBox());
        demoCheckBoxPage.getDesktopCheckBox().click();
        Thread.sleep(2000);

       // Assert.assertTrue(demoCheckBoxPage.SubHomeBoxes.get(1).isSelected()); izbacuje false
        Assert.assertTrue(demoCheckBoxPage.SelectedBoxesNotification.isDisplayed());
        Thread.sleep(2000);

        demoCheckBoxPage.CheckedBoxes.get(0).click();
        Thread.sleep(2000);

        Assert.assertFalse(demoCheckBoxPage.notificationSelectedBoxes());
        Thread.sleep(2000);
        driver.quit();

    }

    @Test (priority = 40)
    public void documentsCheckBoxCanBeMarkedAndUnmarked() throws InterruptedException {

        logInToElements();
        logInToCheckBox();

        driver.navigate().refresh();
        demoCheckBoxPage.clickOnHomeArrow();
        Thread.sleep(2000);

        demoCheckBoxPage.SubHomeBoxes.get(2).click();
        Thread.sleep(2000);

        Assert.assertTrue(demoCheckBoxPage.SelectedBoxesNotification.isDisplayed());
        Thread.sleep(2000);

        demoCheckBoxPage.CheckedBoxes.get(0).click();

        Assert.assertFalse(demoCheckBoxPage.notificationSelectedBoxes());
        Thread.sleep(2000);
        driver.quit();
    }

    @Test (priority = 50)
    public void downloadsCheckBoxCanBeMarkedAndUnmarked() throws InterruptedException {

        logInToElements();
        logInToCheckBox();

        driver.navigate().refresh();
        demoCheckBoxPage.clickOnHomeArrow();
        Thread.sleep(2000);

        demoCheckBoxPage.SubHomeBoxes.get(3).click();
        Thread.sleep(2000);

        Assert.assertTrue(demoCheckBoxPage.SelectedBoxesNotification.isDisplayed());
        Thread.sleep(2000);

        demoCheckBoxPage.CheckedBoxes.get(0).click();

        Assert.assertFalse(demoCheckBoxPage.notificationSelectedBoxes());
        Thread.sleep(2000);
        driver.quit();

    }

    @Test (priority = 60)
    public void plusSignOpensAllBoxesAndMinusSignClosesThem() throws InterruptedException {

        logInToElements();
        logInToCheckBox();

        driver.navigate().refresh();

        demoCheckBoxPage.clickOnPlusSign();
        scrollWindow350();
        Thread.sleep(2000);

        for(int i=0; i<16; i++) {

            Assert.assertTrue(demoCheckBoxPage.SubHomeBoxes.get(i).isDisplayed());
        }

        demoCheckBoxPage.clickOnMinusSign();
        Assert.assertTrue(demoCheckBoxPage.ClosedArrow.get(0).isDisplayed());

        Thread.sleep(2000);
        driver.quit();

    }

    @AfterMethod
    public void shutDown() {

        // driver.manage().deleteAllCookies();
        // driver.close();

    }


}
