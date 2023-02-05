package DemoQAProject.DemoQATests;

import DemoQAProject.DemoQABaseTest.DemoBaseTest;
import DemoQAProject.DemoQAPages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DemoBookStoreTests extends DemoBaseTest {

        //srediti, rasporediti Web elemente i metode u BookStore Page
    @BeforeMethod
    public void setUpPage() {

        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);

        demoHomePage = new DemoHomePage();   // obrisati nepotrebne stranice
        demoSidebarPage = new DemoSidebarPage();
        demoBookStore = new DemoBookStore();
        demoLogInPage = new DemoLogInPage();
        demoProfilePage = new DemoProfilePage();

    }

    public void logInToProfile() throws InterruptedException { // da li je ok od prvog testa napraviti i pomocnu metodu?

        logInToBookStoreApplication();
        scrollWindow350();
        Thread.sleep(2000);
        demoBookStore.clickOnLogInItem();
        driver.navigate().refresh();
        demoLogInPage.enterUsername(excelReader.getStringData("Profile", 1,0));
        demoLogInPage.enterPassword(excelReader.getStringData("Profile", 1,1));
        scrollWindow250();
        Thread.sleep(2000);
        //waitForVisibility(demoBookStore.LogInButton);
        demoLogInPage.clickOnLogInButton();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 2,1));
        Assert.assertEquals(demoSidebarPage.title(), "Profile");
        demoProfilePage.assertLogOutButtonIsDisplayed();

    }


    @Test(priority = 10)
    public void userCanLogInToProfile() throws InterruptedException {

        logInToBookStoreApplication();
        scrollWindow350();
        demoBookStore.clickOnLogInItem();
        driver.navigate().refresh();
        demoLogInPage.enterUsername(excelReader.getStringData("Profile", 1,0));
        demoLogInPage.enterPassword(excelReader.getStringData("Profile", 1,1));
        scrollWindow250();
        Thread.sleep(2000);
        //waitForVisibility(demoBookStore.LogInButton);
        demoLogInPage.clickOnLogInButton();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 2,1));
        Assert.assertEquals(demoSidebarPage.title(), "Profile");
        demoProfilePage.assertLogOutButtonIsDisplayed();
    }

    @Test (priority = 20)
    public void userCanLogOutFromProfile() throws InterruptedException {

        logInToProfile();
        demoProfilePage.clickOnLogOutButton();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1,1));
        Assert.assertEquals(demoSidebarPage.title(),"Login");
        demoLogInPage.assertLogInButtonIsDisplayed();
    }

    @Test(priority = 30)
    public void userCanAddABookToProfile() throws InterruptedException {

        logInToProfile();
        scrollWindow350();
        waitForVisibility(demoProfilePage.GoToBookStoreButton);
        demoProfilePage.clickOnGoToBookStoreButton();
        waitForVisibility(demoBookStore.BookGitPocket);
        demoBookStore.clickOnBookGitPocket();
        scrollWindowHeight();
        demoBookStore.addBookToCollection();
        driver.navigate().back();
        scrollWindowHeight();
        demoBookStore.clickOnProfileItem();

        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 2,1));
        Assert.assertEquals(demoSidebarPage.title(), "Profile");
        Assert.assertTrue(demoBookStore.BookGitPocket.isDisplayed());
    }

    @Test (priority = 40)
    public void userCanDeleteABookFromProfile() throws InterruptedException {

        //logInPage();

        WebElement profile = driver.findElement(By.linkText("profile"));
        profile.click();

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("gotoStore"))));

        WebElement GoToBookStore = driver.findElement(By.id("gotoStore"));
        GoToBookStore.click();

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,250)", "");

        Thread.sleep(2000);

        WebElement book1 = driver.findElement(By.linkText("Git Pocket Guide"));
        book1.click();

        JavascriptExecutor jse3 = (JavascriptExecutor) driver;
        jse3.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        WebElement addToCollection = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToCollection.click();

        driver.navigate().back();

        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("window.scrollBy(0,250)", "");

        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Learning JavaScript Design Patterns"))));

        WebElement book2 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        book2.click();

        JavascriptExecutor jse5 = (JavascriptExecutor) driver;
        jse5.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        WebElement addToCollection2 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToCollection2.click();

        driver.navigate().back();

        Thread.sleep(2000);

       // logOut();


    }

    @AfterMethod
    public void shutDown() throws InterruptedException {

        // driver.manage().deleteAllCookies();
       // Thread.sleep(2000);
       // driver.quit();
    }


}
