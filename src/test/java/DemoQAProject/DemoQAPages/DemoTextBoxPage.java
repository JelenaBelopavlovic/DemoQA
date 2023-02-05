package DemoQAProject.DemoQAPages;

import DemoQAProject.DemoQABaseTest.DemoBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DemoTextBoxPage extends DemoBaseTest {


    public DemoTextBoxPage() {

        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "main-header")
    public WebElement TitleTextBox;

    @FindBy (id = "userName")
    public List<WebElement> FullNameField;

    @FindBy (css = "input[placeholder = 'name@example.com']")
    public WebElement EmailField;

    @FindBy (css = "textarea[placeholder = 'Current Address']")
    public WebElement CurrentAddressField;

    @FindBy (id = "permanentAddress")
    public WebElement PermanentAddressField;

    @FindBy (id = "submit")
    public WebElement SubmitButton;

    @FindBy (css = "p[id = 'name']")
    public WebElement EnteredFullName;

    @FindBy (css = "p[id = 'email']")
    public WebElement EnteredEmail;

    @FindBy (css = "p[id = 'currentAddress']")
    public WebElement EnteredCurrentAddress;

    @FindBy (css = "p[id = 'permanentAddress']")
    public WebElement EnteredPermanentAddress;


    //-----------------------------------

    public void enterFullName(String fullName) {
        for (int i = 0; i < FullNameField.size(); i++) {
            FullNameField.get(0).clear();
            FullNameField.get(0).click();
            FullNameField.get(0).sendKeys(fullName);
        }
    }

    public void enterEmail(String email){
        EmailField.clear();
        EmailField.sendKeys(email);
    }

    public void enterCurrentAddress(String email){
        CurrentAddressField.clear();
        CurrentAddressField.sendKeys(email);
    }

    public void enterPermanentAddress(String email){
        PermanentAddressField.clear();
        PermanentAddressField.sendKeys(email);
    }

    public void clickOnSubmitButton() {

        SubmitButton.click();
    }

  /* public String getEnteredFullNameText() {

      return EnteredFullName.getText();

    } */ // nece ovako da dohvati tekst


}
