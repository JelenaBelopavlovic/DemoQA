package DemoQAProject.DemoQAPages;

import DemoQAProject.DemoQABaseTest.DemoBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DemoLogInPage extends DemoBaseTest {

    public DemoLogInPage() {

        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "userName")
    public WebElement UsernameField;

    @FindBy (id = "password")
    public WebElement PasswordField;

    @FindBy (id = "login")
    public List<WebElement> LogInButton;


    //------------------------------

    public void enterUsername(String username) {

        UsernameField.clear();
        UsernameField.sendKeys(username);
    }

    public void enterPassword(String password) {

        PasswordField.clear();
        PasswordField.sendKeys(password);
    }

    public void clickOnLogInButton() {

        for(int i=0; i<LogInButton.size(); i++) {

            if(LogInButton.get(i).getText().equals("Login")) {
                LogInButton.get(i).click();
            }
        }
    }
    public void assertLogInButtonIsDisplayed() {
       for(int i=0; i<LogInButton.size(); i++) {
        if(LogInButton.get(i).getText().equals("Login")) {
            Assert.assertTrue(LogInButton.get(i).isDisplayed());
        }
      }

    }




}
