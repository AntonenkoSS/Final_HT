package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.awt.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.Keys.ENTER;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 300;
    private static final long NUMBER_PRODUCT_ON_SEARCH_PAGE = 19;

    WebDriver driver;
    HomePage homePage;
    TodayDealsPage todayDealsPage;
    CustomerServicePage customerServicePage;
    ShoppingCartPage shoppingCartPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CreateAccountAmazonPage createAccountAmazonPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks header visibility")
    public void checkHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isHeaderVisible();
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @And("User checks lastDiv visibility")
    public void checkLastDivVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isLastDivVisible();
    }

    @And("User checks cart visibility")
    public void checkCartVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isCartIconVisible();
    }

    @And("User checks that language downPage switcher is {string}")
    public void checkLanguageDown(final String language) {
        assertTrue(homePage.getLanguageButtonDownText().equalsIgnoreCase(language));
    }

    @And("User checks register button visibility")
    public void checkRegisterButtonVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isRegisterButtonVisible();
    }

    @And("User checks sign in button visibility")
    public void checkSignInButtonVisibility() {
        homePage.isSignInButtonVisible();
    }

    @When("User clicks 'Sign In' button")
    public void clickSignInButton() {
        homePage.clickHelloSignInButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks email and password fields visibility on sign in popup")
    public void checkEmailVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignInPopup());
        assertTrue(homePage.isEmailFieldVisible());
        assertTrue(homePage.isPasswordFieldVisible());
    }

    @And("User closes sign in popup")
    public void closeSignInPopup() {
        homePage.clickSignInPopupCloseButton();
    }

    @And("User opens store popup")
    public void openStorePopup() {
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickDeliverToButton();
    }

    @And("User checks that store popup visible")
    public void checkStorePopupVisibility() {
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.isDeliverToPopupVisible());
    }

    @And("User checks that current url contains {string} language")
    public void checkCurrentUrl(final String language) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(language));
    }

    @And("User checks that shopping cart title visible")
    public void checkShoppingCartTitleVisibility() {
        assertTrue(shoppingCartPage.isShoppingCartTitleVisible());
    }

    @And("User makes search by keyword {string}")
    public void enterKeywordToSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }


    @And("User opens shopping cart")
    public void openShoppingCart() {
        homePage.clickCartButton();
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getShoppingCartTitle());
    }

    @And("User opens today deals")
    public void openTodayDeals() {
        homePage.clickTodayDealsButton();
        todayDealsPage = pageFactoryManager.getTodayDealsPage();
        todayDealsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        todayDealsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, todayDealsPage.getTodayDealsTitle());
    }

    @And("User opens customer service")
    public void openCustomerService() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickCustomerServiceButton();
        customerServicePage = pageFactoryManager.getCustomerServicePage();
        customerServicePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        customerServicePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, customerServicePage.getCustomerServiceTitle());
    }

    @And("User checks title customer service fields visibility")
    public void userChecksTitleCustomerServiceFieldsVisibility() {
        customerServicePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        customerServicePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, customerServicePage.getCustomerServiceTitle());
        assertTrue(customerServicePage.isCustomerServiceTitleVisible());
    }

    @And("User checks Title fields visibility")
    public void userChecksTitleTodayDealsFieldsVisibility() {
        todayDealsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        todayDealsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, todayDealsPage.getTodayDealsTitle());
        assertTrue(todayDealsPage.isTodayDealsTitleVisible());
    }


    @When("User clicks language button")
    public void clickLanguageButton() {
        homePage.clickLanguageButton();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @When("User makes search help by keyword {string}")
    public void enterKeywordToSearchHelpFieldAndEnter(final String keyword) {
        customerServicePage.enterTextToSearchHelpField(keyword);
        customerServicePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User clicks search button")
    public void clicksSearchButton() throws InterruptedException{
       // sleep(1500); //потом что баг, вам так делать нельзя
        homePage.clickSearchButton();
    }

    @And("User opens search result")
    public void clicksProductList() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }


    @Then("User checks number of products in search page")
    public void userChecksNumberOfProductsInSearchPage() {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(searchResultsPage.getSearchResultsCount(), NUMBER_PRODUCT_ON_SEARCH_PAGE);
    }

    @When("User clicks 'Hello Sign In' button")
    public void userClicksTodayDealsButton() {
        homePage.clickHelloSignInButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that amount of answers in list are {string}")
    public void userChecksThatAmountOfAnswersInListAreAmountOfVar(final String expectedAmount) {
        customerServicePage = pageFactoryManager.getCustomerServicePage();
        customerServicePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        customerServicePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, customerServicePage.getSearchListAnswerCount());
        assertEquals(customerServicePage.getTextOfAnswerInSearchList(), expectedAmount);
    }

    @Then("User checks that has link")
    public void userChecksThatHasLinkWithUseLoginWithAmazon() {
        customerServicePage = pageFactoryManager.getCustomerServicePage();
        customerServicePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(customerServicePage.isSecondLinkVisible());
    }

    @And("User clicks first product on list")
    public void userClicksFirstProductSample() throws InterruptedException{
        sleep(500);
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickFirstOfListProductSample();
    }

    @Then("User checks that customer reviews visible")
    public void userChecksThatCustomerReviewsVisible() {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, todayDealsPage.getTodayDealsTitle());
        assertTrue(productPage.isProductPageVisible());
    }

    @Then("User checks input variable visibility customer reviews")
        public void checkCustomerReviewsVisibility() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
         searchResultsPage.isCustomerReviewsVisible();
        }

    @And("User clicks 'Add to Cart' button on product")
    public void clickAddToCart() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickAddToCartButton();
    }

    @And("User checks that add to cart popup visible")
    public void checkAddToCartPopupVisibility() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCartPopupHeader());
        assertTrue(productPage.isAddToCartPopupVisible());
    }

    @And("User checks 'Cart' button visibility")
    public void checkContinueToCartButtonVisibility() {
        productPage.isCartButtonVisible();
    }

    @And("User checks that add to cart popup header is {string}")
    public void checkAddToCartPopupHeader(final String expectedText) {
        assertEquals(productPage.getAddToCartPopupHeaderText(), expectedText);
    }

    @And("User checks input variable brand")
    public void userChecksInputVariableBrand() {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.isBrandVisible();
    }

    @And("User checks input variable price")
    public void userChecksInputVariablePrice() {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.isPriceVisible();
    }
    @And("User clicks input variable price")
    public void userClickInputVariablePrice() {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickPriceButton();
    }


    @And("User checks input variable shelf height")
    public void userChecksInputVariableShelfHeight() {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.isHeightVisible();
    }

    @And("User checks input variable shelf depth")
    public void userChecksInputVariableShelfDepth() {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.isDepthVisible();
    }

    @And("User checks input variable shelf width")
    public void userChecksInputVariableShelfWidth() {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.isProductWidthVisible();
    }

    @And("User checks input variable furniture Material")
    public void userChecksInputVariableFurnitureMaterial() {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.isFurnitureMaterialVisible();
    }

    @And("User clicks 'create your amazon account' button")
    public void userClicksCreateAmazonAccountButton() {
        createAccountAmazonPage = pageFactoryManager.getCreateAccountAmazonPage();
        createAccountAmazonPage.createAccountClick();
        createAccountAmazonPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks 'Name field' visibility")
    public void userChecksNameFieldVisibility() {
        assertTrue(createAccountAmazonPage.isYourNameFieldVisible());
    }

    @Then("User checks 'email field' visibility")
    public void userChecksEmailFieldVisibility() {
        assertTrue(createAccountAmazonPage.isEmailFieldVisible());
    }

    @And("User enters {string} in 'Name field'")
    public void userEntersNameInNameField(final String name) {
        createAccountAmazonPage.nameFieldClick();
        createAccountAmazonPage.enterNameToNameField(name);
    }

    @And("User enters {string} in 'Email field'")
    public void userEntersKeywordInEmailField(final String email) {
        createAccountAmazonPage.emailFieldClick();
        createAccountAmazonPage.enterEmailToEmailField(email);
    }

    @And("User enters {string} in 'Password field'")
    public void userEntersKeywordInPasswordField(final String password) {
        createAccountAmazonPage.passwordFieldClick();
        createAccountAmazonPage.enterPasswordToPasswordField(password);
    }

    @And("User enters {string} in 'Re-enter'")
    public void userEntersKeywordInReEnterPasswordField(final String rePassword) {
        createAccountAmazonPage.reEnterPasswordFieldClick();
        createAccountAmazonPage.reEnterPasswordToReEnterPasswordField(rePassword);
    }

    @And("User clicks 'Create your Amazon account'")
    public void userClicksCreateYourAmazonAccountButton() {
        createAccountAmazonPage.createAccountButton2Click();
    }


    @Then("User checks that captcha visibility")
    public void userChecksThatCaptchaVisibility() {
        createAccountAmazonPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, createAccountAmazonPage.getPicture());
        assertTrue(createAccountAmazonPage.captchaPictureVisibility());
    }

    @And("User checks that language is {string}")
    public void checkLanguage(final String language_1) {
        assertTrue(homePage.getLanguageText().equalsIgnoreCase(language_1));
    }

    @And("User clicks 'Language'")
    public void userClicksLanguage() {
        homePage.clickLanguageChoose();
    }

    @And("User clicks 'Language D'")
    public void userClicksLanguageD() {
        homePage.clickLanguageChooseD();
    }

    @And("User chooses {string}")
    public void userChoosesKeywordLanguage(final String language_2) {
        homePage.clickDeLanguage();
    }

    @And("User clicks 'Save changes'")
    public void userClicksSaveChanges() {
        homePage.clickSaveChanges();
    }

    @Then("User checks that language switcher is {string} in url")
    public void userChecksThatCurrentUrlContainsLanguageEspText(final String lang) {
        assertTrue(driver.getCurrentUrl().contains(lang));
    }

    @Then("User checks that answer visibility")
    public void userChecksThatAnswerVisibility() {
        createAccountAmazonPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, createAccountAmazonPage.getMessage());
        assertTrue(createAccountAmazonPage.messageIsVisible());
    }

    @And("User clicks 'Deliver To' link")
    public void userClicksDeliverToLink() {
        homePage.clickDeliverToButton();
    }

    @And("User clicks 'Country choice' menu")
    public void userEntersCountryChoiceMenu() throws InterruptedException {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT * 4);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT * 5, homePage.isChooseLocationPopupVisible());
        homePage.clickCountryButton();
    }

    @And("User chooses {string} country")
    public void userChoosesDeliveryCountry(final String delivery) {
        homePage.chooseCountry(delivery);
        homePage.clickDoneButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that 'Deliver To' contains {string}")
    public void userChecksThatDeliverToContainsDelivery (final String Delivery) throws InterruptedException {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        sleep(1500);
        assertTrue(homePage.isDeliverToContainsCountry(Delivery));
    }

    @And("User clicks sign up in system")
    public void userClicksSignUpInSystem() {
        createAccountAmazonPage = pageFactoryManager.getCreateAccountAmazonPage();
        createAccountAmazonPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        createAccountAmazonPage.clicksSignUpButton();

    }

    @And("User clicks 'Sell products on Amazon' button")
    public void userClicksSellProductsOnAmazonButton() {
 //       homePage = pageFactoryManager.getHomePage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickSellProductOnAmazon();
    }

    @And("User clicks cart icon")
    public void userClicksCartIcon() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clicksCartIcon();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Then("User checks that current url contains {string}")
    public void userChecksThatCurrentUrlContainsKeyword(final String keyword){
        assertTrue(driver.getCurrentUrl().contains(keyword));
    }
}
