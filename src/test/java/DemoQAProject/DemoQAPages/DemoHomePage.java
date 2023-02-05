package DemoQAProject.DemoQAPages;

import DemoQAProject.DemoQABaseTest.DemoBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DemoHomePage extends DemoBaseTest {

    public DemoHomePage() {

        PageFactory.initElements(driver, this);
    }

    // @FindBy(css = "tag[atribute = 'value']")
    // public WebElement element;

    @FindBy(css = "img[src = '/images/Toolsqa.jpg']")
    public WebElement Logo;
    @FindBy(css = "a [href = 'https://www.toolsqa.com/selenium-training/']") //ne mogu da pronadjem naslov..
    public WebElement TitleSelenium;

    @FindBy(className = "card-body")
    public List<WebElement> Cards;


    //----------------------------------

    public void clickOnElements() {
        for (int i = 0; i < Cards.size(); i++) {
            if (Cards.get(i).getText().equals("Elements")) {
                Cards.get(i).click();
                break;
            }
        }

    }

    public void clickOnBookStore() {
        for (int i = 0; i < Cards.size(); i++) {
            if (Cards.get(i).getText().equals("Book Store Application")) {
                Cards.get(i).click();
                break;
            }
        }

    }

    // public List<WebElement> getCards() {
    //     return driver.findElements(By.className("card-body"));
    // }


}
