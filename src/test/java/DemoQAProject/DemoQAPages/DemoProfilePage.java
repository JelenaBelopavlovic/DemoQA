package DemoQAProject.DemoQAPages;

import DemoQAProject.DemoQABaseTest.DemoBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DemoProfilePage extends DemoBaseTest {

    public DemoProfilePage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy (id = "submit")
    public List<WebElement> ProfileButtons;

    @FindBy (css = "button[id='gotoStore']")
    public WebElement GoToBookStoreButton;

    // @FindBy(css = "tag[atribute = 'value']")
    // public WebElement element;


    //----------------------------------


    public void clickOnLogOutButton() {

        for (int i = 0; i < ProfileButtons.size(); i++) {

            ProfileButtons.get(i).getText().equals("Log out");
            ProfileButtons.get(i).click();
        }
    }

    public void assertLogOutButtonIsDisplayed() {

        for (int i = 0; i < ProfileButtons.size(); i++) {
            if(ProfileButtons.get(i).getText().equals("Log out")) {
            Assert.assertTrue(ProfileButtons.get(i).isDisplayed());
            }
        }
    }


    public void clickOnProfileButton(String name) {  // u Testu proslediti - Log Out, Delete Accounr, Delete All Books

        for(int i=0; i<ProfileButtons.size(); i++) {

           if (ProfileButtons.get(i).getText().equals(name)) {
               ProfileButtons.get(i).click();
               break;
           }
        }
    }

    public void clickOnGoToBookStoreButton() {

        GoToBookStoreButton.click();
    }







}
