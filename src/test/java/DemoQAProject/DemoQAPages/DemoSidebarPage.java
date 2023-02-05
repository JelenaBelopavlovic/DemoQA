package DemoQAProject.DemoQAPages;

import DemoQAProject.DemoQABaseTest.DemoBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DemoSidebarPage extends DemoBaseTest {

    public DemoSidebarPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "main-header")
    public WebElement Title;

    @FindBy (className = "text")
    public List<WebElement> ItemsElements;

    @FindBy (css = "span[class = 'text']")
    public WebElement CheckBoxItem;



    //------------------------------------

    public String title() {

        return Title.getText();
    }


    public void clickOnItems(String name) {
        for (int i = 0; i < ItemsElements.size(); i++) {
            if (ItemsElements.get(i).getText().equals(name)) {
                ItemsElements.get(i).click();
                break;
            }
        }
    }


}
