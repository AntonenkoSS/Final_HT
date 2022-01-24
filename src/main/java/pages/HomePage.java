package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//header[@class='nav-opt-sprite nav-flex nav-locale-us nav-lang-en nav-ssl nav-unrec nav-progressive-attribute']")    //!
    private WebElement header;                                                  //!

    @FindBy(xpath = "//div[@class='navFooterLine navFooterLinkLine navFooterDescLine']")                  //!
    private WebElement lastDiv;                                                 //!

    @FindBy(xpath = "//a[@href='/gp/cart/view.html?ref_=nav_cart']")   //!
    private WebElement cartIcon;                                                //!

    @FindBy(xpath = ".//a[contains(@class, 'nav-a nav-a-2 icp-link-style-2')]")  //!  ???
    private WebElement languageButton;//!

    @FindBy(xpath = ".//span[@class='icp-color-base']")  //!  ???
    private WebElement languageButtonDown;//!

    @FindBy(xpath = "//a[@id='icp-nav-flyout']")  //!  ???
    private WebElement languageText;//!

    @FindBy(xpath = "//i[@class='a-icon a-icon-radio']")
    private List<WebElement> languageFields;

    @FindBy(xpath = "//input[@aria-labelledby='icp-btn-save-announce']")
    private WebElement saveChanges;


    @FindBy(xpath = "//a[@data-nav-role='signin'][@data-nav-ref='nav_ya_signin']")                                 //!
    private WebElement signInButton;                                                 //!

    @FindBy(xpath = "//div[contains(@class,'nav_pop_new_cust')]/a[@class='nav-a']")   //!
    private WebElement registerButton;                                                //!

    @FindBy(xpath = "//form[@name='register']")                                       //!
    private WebElement signInPopup;                                                   //!

    @FindBy(xpath = "//input[@name='customerName']")                                  //!
    private WebElement nameField;                                                     //!

    @FindBy(xpath = ".//input[@name='email']")                                          //!
    private WebElement emailField;                                                       //!

    @FindBy(xpath = ".//input[@name='password'][contains(@placeholder, '6 characters')]")  //!
    private WebElement passwordField;                                                      //!

    @FindBy(xpath = ".//input[@name='passwordCheck'][contains(@class, 'auth-required-field auth-require-fields-match')]")
    private WebElement rePasswordField;                                                                         //!

    @FindBy(xpath = "//span[@class='a-button a-button-normal a-button-span12 a-button-primary'][@id='a-autoid-0']")  //!
    private WebElement signInPopupCloseButton;                                                                      //!

    @FindBy(xpath = "//a[@class='nav-a nav-a-2 a-popover-trigger a-declarative nav-progressive-attribute']")    //!
    private WebElement deliverToButton;                   //!

    @FindBy(xpath = "//div[@class='a-popover-wrapper']")     //!
    private WebElement deliverToPopup;                       //!

    @FindBy(xpath = "//input[@id='twotabsearchtextbox'][contains(@class, 'nav-input')]")     //!
    private WebElement searchField;                                                          //!

    @FindBy(xpath = "//input[@id='nav-search-submit-button'][@value='Go']")                  //!
    private WebElement searchButton;                                                         //!

    @FindBy(xpath = "//a[@href='https://services.amazon.com/sell.html?ld=AZFSSOA&ref_=footer_soa']")
    private WebElement sellProductOnAmazon;

    @FindBy(xpath = "//a[@href='/gp/goldbox?ref_=nav_cs_gb'][contains(text(),'Deals')]")          //!
    private WebElement todayDealsButton;

    @FindBy(xpath = "//a[@href='/gp/help/customer/display.html?nodeId=508510&ref_=nav_cs_customerservice']")          //!
    private WebElement customerServiceButton;

    @FindBy(xpath = "//span[@class='a-button-text a-declarative']")          //!
    private WebElement countryButton;

    @FindBy(xpath = "//a[@tabindex='-1']")
    private List<WebElement> countriesChoice;

    @FindBy(xpath = "//button[@name='glowDoneButton'][@class='a-button-text']")          //!
    private WebElement doneButton;

    @FindBy(xpath = "//div[@class='a-popover-wrapper']//header/h4[@class='a-popover-header-content']")
    private WebElement chooseLocationToDeliveryPopup;

    @FindBy(xpath = "//span[@class='a-declarative'][@data-csa-c-func-deps='aui-da-a-modal']")
    private WebElement CompareButton;





    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {driver.get(url);}

    public boolean isHeaderVisible() {
        return header.isDisplayed();
    }

    public boolean isLastDivVisible() {
        return lastDiv.isDisplayed();
    }

    public boolean isCartIconVisible() {
        return cartIcon.isDisplayed();
    }

    public void clickLanguageChoose() {
        languageButton.click();
    }
    public void clickLanguageChooseD() {
        languageButton.click();
    }


//    public String getLanguageButtonText() {
//        return languageButton.getText();
//    }


    public String getLanguageButtonDownText() {
        return languageButtonDown.getText();
    }

    public String getLanguageText() {
        return languageText.getText();
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public void clickHelloSignInButton() {
        signInButton.click();
    }

    public void clickTodayDealsButton() {
        todayDealsButton.click();
    }

    public void clickCustomerServiceButton(){
        customerServiceButton.click();
    }

//    public WebElement getLastDiv() {
//        return lastDiv;
//    }

    public WebElement getHeader() {
        return header;
    }

//    public WebElement getSearchField() {
//        return searchField;
//    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isRegisterButtonVisible() {
        return registerButton.isDisplayed();
    }

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return passwordField.isDisplayed();
    }

//    public boolean isRePasswordFieldVisible() {
//        return rePasswordField.isDisplayed();
//    }

    public WebElement getSignInPopup() {
        return signInPopup;
    }

    public void clickSignInPopupCloseButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", signInPopupCloseButton);
    }

    public void clickDeliverToButton() {
        deliverToButton.click();
    }

    public boolean isDeliverToPopupVisible() {
        return deliverToPopup.isDisplayed();
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }



    public void clickCartButton() {
        cartIcon.click();
    }

    public void clickLanguageButton() {
        languageButton.click();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickEspLanguage() {
        languageFields.get(1).click();
    }

    public void clickDeLanguage() {
        languageFields.get(3).click();
    }

    public void clickSaveChanges() {
        saveChanges.click();
    }

    public void clickCountryButton() {
        countryButton.click();
    }

    public void chooseCountry(final String delivery) {
        for (WebElement s : countriesChoice) {
            String countryChosen = s.getText();
            if (countryChosen.contains(delivery)) {
                s.click();
            }
        }
    }

    public void clickDoneButton() {
        doneButton.click();
    }

    public boolean isDeliverToContainsCountry(final String country) {
        String isCountry = deliverToButton.getText();
        return isCountry.contains(country);
    }

    public WebElement isChooseLocationPopupVisible() throws InterruptedException {
        Thread.sleep(1500);
        return chooseLocationToDeliveryPopup;
    }

    public void clicksCartIcon() {
        cartIcon.click();
    }

    public void clicksCompareButton() {
       CompareButton.click();
    }

    public void clickSellProductOnAmazon() {
        sellProductOnAmazon.click();
    }




}
