package DemoQAProject.DemoQATests;

import DemoQAProject.DemoQABaseTest.DemoBaseTest;
import DemoQAProject.DemoQAPages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoRadioButtonTests extends DemoBaseTest {


    @BeforeMethod
    public void setUpPage() {

        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);

        demoHomePage = new DemoHomePage();
        demoSidebarPage = new DemoSidebarPage();
        demoRadioButton = new DemoRadioButton();

    }

    public void logInToRadioButton() throws InterruptedException {

        logInToElements();
        scrollWindow250();
        Thread.sleep(2000);
        demoSidebarPage.clickOnItems("Radio Button");

        String expectedURL = "https://demoqa.com/radio-button";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(demoRadioButton.titleRadioButton(), "Radio Button");

    }

    @Test (priority = 10)
    public void yesAndImpressiveRadioButtonsCanBeMarked() throws InterruptedException {

        logInToRadioButton();
        driver.navigate().refresh();

        waitForClickability(demoRadioButton.YesButton);
        demoRadioButton.clickOnYesButton();
        Assert.assertEquals(demoRadioButton.successNotificationGetText(), "Yes");

        waitForClickability(demoRadioButton.ImressiveButton);
        demoRadioButton.clickOnImpressiveButton();
        Assert.assertEquals(demoRadioButton.successNotificationGetText(), "Impressive");

        Thread.sleep(2000);
        driver.quit();
    }

    @Test (priority = 20)
    public void noRadioButtonsCanNotBeMarked() throws InterruptedException {

        logInToRadioButton();
        Thread.sleep(2000);

        String actualMousePointer = demoRadioButton.NoButton.getCssValue("cursor");
        Assert.assertEquals(actualMousePointer, "not-allowed");
        Assert.assertFalse(demoRadioButton.successNotification());

        Thread.sleep(2000);
        driver.quit();
    }


    @AfterMethod
    public void shutDown() {

        // driver.manage().deleteAllCookies();
        // driver.close();

    }

}
