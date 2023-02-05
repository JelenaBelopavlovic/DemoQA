package DemoQAProject.DemoQABaseTest;

import DemoQAProject.DemoQAPages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class DemoBaseTest {

    public static WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String homeURL;
    public DemoHomePage demoHomePage;
    public DemoSidebarPage demoSidebarPage;
    public DemoTextBoxPage demoTextBoxPage;
    public DemoCheckBoxPage demoCheckBoxPage;
    public DemoRadioButton demoRadioButton;
    public DemoBookStore demoBookStore;
    public DemoLogInPage demoLogInPage;
    public DemoProfilePage demoProfilePage;


    @BeforeClass
    public void setUp() throws IOException {

        WebDriverManager.chromedriver().setup();

        excelReader = new ExcelReader("C:\\Users\\Administrator\\Desktop\\DemoQAData.xlsx");

        homeURL = excelReader.getStringData("URL", 1, 0);

    }


    public void logInToElements() {

        Assert.assertTrue(demoHomePage.Logo.isDisplayed());
        scrollWindowHeight();

        demoHomePage.clickOnElements();

        String expectedURL = "https://demoqa.com/elements";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(demoSidebarPage.title(), "Elements");
    }


    public void logInToBookStoreApplication() {

        Assert.assertTrue(demoHomePage.Logo.isDisplayed());
        scrollWindowHeight();

        demoHomePage.clickOnBookStore();

        String expectedURL = "https://demoqa.com/books";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(demoSidebarPage.title(), "Book Store");
    }


    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollWindow250() {
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,250)", "");
    }

    public void scrollWindow350() {
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,350)", "");
    }

    public void scrollWindowHeight(){

    JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void waitForClickability(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVisibility(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }


    public void waitForVisibilityOfPage (String url){
        wdwait.until(ExpectedConditions.urlToBe("url"));
    }

    public void doubleClickWithJS(WebElement element) {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].dispatchEvent(new MouseEvent('dblclick', { bubbles: true }));", element);
     }


     //  ((JavascriptExecutor)driver).executeScript("arguments[0].doubleClick();", element); - dupli klik

    //public void doubleClickWithJS(WebElement element) {
    //   JavascriptExecutor executor = (JavascriptExecutor) driver;
    //   executor.executeScript("arguments[0].dispatchEvent(new MouseEvent('dblclick', { bubbles: true }));", element);
    //}    isto za dabl klik

   // public void insertDateOfBirth(String date) {   resnje za cisnje polja?
   //     DateOfBirthField.sendKeys(Keys.chord(Keys.CONTROL,"a"));
  //      DateOfBirthField.sendKeys(date);
  //  }

    // public void newTab () {         // dohvati novi tab
    //    ArrayList<String> listaTabova  = new ArrayList<>(driver.getWindowHandles());
    //    driver.switchTo().window(listaTabova.get(1));
    //}

    // wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("password"))));
    // scrollIntoView(demoTextBoxPage.PermanentAddressField);

    /* public void waitForClickability(List<WebElement> name) {
        wdwait.until(ExpectedConditions.elementToBeClickable(name));
    }
 */


    public boolean isDisplayed(WebElement element) {  // D.. U assertu ce biti False da je displayed
        boolean webelement = false;
        try {
            webelement = element.isDisplayed();
        } catch (Exception e) {

        }
        return webelement;
    }

   /* boolean logOut = false;
        try {
        logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
    } catch (Exception e) {

    }
        Assert.assertFalse(logOut); */


    @AfterClass
    public void tearDown() {

        // driver.quit();

    }



}
