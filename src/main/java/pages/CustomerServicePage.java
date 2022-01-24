package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;

public class CustomerServicePage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(),'Hello. What can we help you with?')]")     //!
    private WebElement customerServiceTitle;                                          //!

    @FindBy(xpath = "//input[@class='a-input-text a-span12']")                          //!
    private WebElement searchFieldHelp;                                                 //!

    @FindBy(xpath = "//input[@class='a-input-text a-span12']")                          //!
    private WebElement searchHelpButton;                                                 //!

    @FindBy(xpath = "//p[@class='a-color-secondary'][contains(text(),'search results for')]")     //  TODO  нужно как-то взять 83 из ответа и сверить с числом установленным (пример)
    private WebElement searchListAnswer;

    @FindBy(xpath = "//a[@class='a-link-normal'][contains(text(), 'Use Login with Amazon')]")     //
    private WebElement secondLink;


    public CustomerServicePage(WebDriver driver) { //конструктор
        super(driver);
    }

    public WebElement getCustomerServiceTitle() {
        return customerServiceTitle;
    }                     //!

    public boolean isCustomerServiceTitleVisible() {
        return customerServiceTitle.isDisplayed();
    }    //!

    public boolean isSecondLinkVisible() {
        return secondLink.isDisplayed();
    }    //!

    public void enterTextToSearchHelpField(final String searchText) {   //!
        searchFieldHelp.clear();                                        //!
        searchFieldHelp.sendKeys(searchText,  Keys.ENTER);               //!
    }


    public WebElement getSearchListAnswerCount() {
        return searchListAnswer;
    }

    public String getTextOfAnswerInSearchList() {
        return searchListAnswer.getText();
    }

}
