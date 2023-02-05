package DemoQAProject.DemoQAPages;

import DemoQAProject.DemoQABaseTest.DemoBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DemoCheckBoxPage extends DemoBaseTest {

    public DemoCheckBoxPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "main-header")
    public WebElement TitleCheckBox;

    @FindBy (className = "rct-checkbox")
    public WebElement HomeCheckBox;

    @FindBy (id = "result")
    public WebElement SelectedBoxesNotification;

    @FindBy (css = ".rct-collapse.rct-collapse-btn")
    public WebElement HomeArrow;

    @FindBy (css = ".rct-icon.rct-icon-expand-close")
    public List<WebElement> ClosedArrow;

    @FindBy (css = ".rct-icon.rct-icon-uncheck")
    public List<WebElement> SubHomeBoxes;

    @FindBy (css = ".rct-icon.rct-icon-check")
    public List<WebElement> CheckedBoxes;

    @FindBy (css = "button[aria-label = 'Expand all']")
    public WebElement PlusSign;

    @FindBy (css = "button[aria-label = 'Collapse all']")
    public WebElement MinusSign;


    //----------------------------

    public String getTitleCheckBoxText() {

        return TitleCheckBox.getText();
    }


    public void clickOnHomeCheckBox() {

        HomeCheckBox.click();
    }

   public boolean homeCheckBoxIsSelected() {

        return HomeCheckBox.isSelected();
    }

    /* public boolean selectedBoxesNotification() {

        for(int i=0; i< SelectedBoxesNotification.size(); i++) {

            SelectedBoxesNotification.get(i);
        }

    } */

    public void clickOnHomeArrow() {
        HomeArrow.click();
    }

    public WebElement getDesktopArrow() {

        for (int i = 0; i < ClosedArrow.size(); i++) {

            ClosedArrow.get(0);
        }
        return ClosedArrow.get(0);
    }

    public WebElement getDocumentsArrow() {

        for (int i = 0; i < ClosedArrow.size(); i++) {

            ClosedArrow.get(1);
        }
        return ClosedArrow.get(1);
    }

    public WebElement getDownloadsArrow() {

        for (int i = 0; i < ClosedArrow.size(); i++) {

            ClosedArrow.get(2);
        }
        return ClosedArrow.get(2);
    }

    public WebElement getDesktopCheckBox() {
        for (int i = 0; i < SubHomeBoxes.size(); i++) {

            SubHomeBoxes.get(1);
        }
        return SubHomeBoxes.get(1);
    }

    public WebElement getDocumentsCheckBox() {
        for (int i = 0; i < SubHomeBoxes.size(); i++) {

            SubHomeBoxes.get(2);
        }
        return SubHomeBoxes.get(2);
    }

    public WebElement getDownloadsCheckBox() {
        for (int i = 0; i < SubHomeBoxes.size(); i++) {

            SubHomeBoxes.get(3);
        }
        return SubHomeBoxes.get(3);
    }

    public boolean notificationSelectedBoxes() {

        boolean notificationSelectedBoxes = false;
        try {

            notificationSelectedBoxes = SelectedBoxesNotification.isDisplayed();

        } catch (Exception e) {

        }
        return notificationSelectedBoxes;
    }

    public void clickOnPlusSign() {

        PlusSign.click();
    }

    public void clickOnMinusSign() {

        MinusSign.click();
    }

    public boolean listOfAllUncheckedBoxesIsDisplayed() {

        for(int i=0; i<16; i++) {

            SubHomeBoxes.get(i).isDisplayed();
        }
        return listOfAllUncheckedBoxesIsDisplayed();

    }



    }














