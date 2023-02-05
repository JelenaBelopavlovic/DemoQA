package DemoQAProject.DemoQAPages;

import DemoQAProject.DemoQABaseTest.DemoBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class DemoBookStore extends DemoBaseTest {

    public DemoBookStore() {
        PageFactory.initElements(driver, this);
    }


    @FindBy (id = "item-0")
    public List<WebElement> LogInItem;

    @FindBy (id = "item-3")
    public List<WebElement> ProfileItem;

    @FindBy (linkText = "Git Pocket Guide")
    public WebElement BookGitPocket;

    @FindBy (css = ".text-right.fullButton")
    public WebElement AddToCollectionButton;


    //---------------------------


    public void clickOnLogInItem() {
        for(int i=0; i<LogInItem.size(); i++) {

            LogInItem.get(5).click();
        }
    }

    public void clickOnProfileItem() {
        for(int i=0; i<ProfileItem.size(); i++) {
            if(ProfileItem.get(i).getText().equals("Profile")) {
            ProfileItem.get(i).click();
            }
        }

    }

    public void clickOnBookGitPocket() {

        BookGitPocket.click();
    }

    public void addBookToCollection() {

        AddToCollectionButton.click();
    }


}
