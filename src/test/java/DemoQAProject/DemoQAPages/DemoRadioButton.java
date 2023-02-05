package DemoQAProject.DemoQAPages;

import DemoQAProject.DemoQABaseTest.DemoBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoRadioButton extends DemoBaseTest {

    public DemoRadioButton() {

        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "main-header")
    public WebElement TitleRadioButton;

    @FindBy (css = "label[for = 'yesRadio']")
    public WebElement YesButton;

    @FindBy (css = "label[for = 'impressiveRadio']")
    public WebElement ImressiveButton;

    @FindBy (css = "input[id = 'noRadio']")
    public WebElement NoButton;

    @FindBy (css = "span[class='text-success']")
    public WebElement NotificationSuccess;


    //----------------------------------

    public String titleRadioButton() {

        return TitleRadioButton.getText();
    }

    public void clickOnYesButton() {

        YesButton.click();

    }

    public void clickOnImpressiveButton() {

        ImressiveButton.click();

    }

    public String successNotificationGetText() {

        return NotificationSuccess.getText();

    }

    public boolean successNotification() {

        boolean successNotification = false;
        try{
            successNotification = NotificationSuccess.isDisplayed();

        } catch (Exception e) {


        }
        return successNotification;

    }



}
