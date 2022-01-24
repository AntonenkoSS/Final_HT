package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CreateAccountAmazonPage extends BasePage {


    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    private WebElement createAccount;

    @FindBy(xpath = "//input[@name='customerName']")
    private WebElement yourNameField;

    @FindBy(xpath = "//input[@name='email'][@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='ap_password_check']")
    private WebElement reEnterPasswordField;

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement createAccountButton_2;

    @FindBy(xpath = "//div[contains(text(), 'email address')]")
    private WebElement alertMessage;

    @FindBy(xpath = "//div[@class='a-row a-spacing-none cvf-overflow-hidden']")
    private WebElement picture;

    @FindBy(xpath = "//div[contains(text(), 'email address')]")
    private WebElement message;

    @FindBy(xpath = "//a[@class='a-button-text']/span[contains(text(), 'Sign up now')]")
    private WebElement signUpButton;

    public CreateAccountAmazonPage(WebDriver driver) {
        super(driver);
    }

    public void createAccountClick() {
        createAccount.click();
    }

    public void clicksSignUpButton() {
        signUpButton.click();
    }



    public boolean isYourNameFieldVisible() {
        return yourNameField.isDisplayed();
    }

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public void nameFieldClick() {
        yourNameField.click();
    }

    public void enterNameToNameField(final String name) {
        yourNameField.sendKeys(name);
    }

    public void emailFieldClick() {
        emailField.click();
    }

    public void enterEmailToEmailField(final String email) {
        emailField.sendKeys(email);
    }

    public void passwordFieldClick() {
        passwordField.click();
    }

    public void enterPasswordToPasswordField(final String password) {
        passwordField.sendKeys(password);
    }

    public void reEnterPasswordFieldClick() {
        reEnterPasswordField.click();
    }

    public void reEnterPasswordToReEnterPasswordField(final String passwordAgain) {
        reEnterPasswordField.sendKeys(passwordAgain);
    }

    public void createAccountButton2Click() {
        createAccountButton_2.click();
    }

    public boolean captchaPictureVisibility() {
        return picture.isDisplayed();
    }

    public WebElement getPicture() {
        return picture;
    }


    public boolean messageIsVisible() {
        return message.isDisplayed();
    }

    public WebElement getMessage() {
        return message;
    }

}
