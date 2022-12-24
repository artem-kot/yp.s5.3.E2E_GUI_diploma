package site.stellarburgers.nomoreparties.pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {


    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    protected SelenideElement loginPageInputFieldsTitle;

    @FindBy(how = How.XPATH, using = "//label[text()='Email']/following-sibling::input")
    protected SelenideElement loginPageInputFieldEmail;

    @FindBy(how = How.XPATH, using = "//label[text()='Пароль']/following-sibling::input")
    protected SelenideElement loginPageInputFieldPassword;

    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    protected SelenideElement loginPageLoginButton;

    @FindBy(how = How.XPATH, using = "//a[text()='Зарегистрироваться']")
    protected SelenideElement loginPageRegisterLink;

    @FindBy(how = How.XPATH, using = "//a[text()='Восстановить пароль']")
    protected SelenideElement loginPageResetPasswordLink;

    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    protected SelenideElement loginPageInvalidPasswordErrorMessage;

    public HeaderPage header() {
        return page(HeaderPage.class);
    }

    private LoginPage fillEmail(String email) {
        loginPageInputFieldEmail.clear();
        loginPageInputFieldEmail.sendKeys(email);
        return page(LoginPage.class);
    }

    private LoginPage fillPassword(String password) {
        loginPageInputFieldPassword.clear();
        loginPageInputFieldPassword.sendKeys(password);
        return page(LoginPage.class);
    }

    @Step("Login with valid credentials")
    public ConstructorPage validLogin(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        loginPageLoginButton.click();
        return page(ConstructorPage.class);
    }

    @Step("Attempt to login with invalid credentials")
    public LoginPage invalidLogin(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        loginPageLoginButton.click();
        return page(LoginPage.class);
    }

    public String getLoginErrorMessage() {
        loginPageInvalidPasswordErrorMessage.shouldBe(Condition.visible);
        return loginPageInvalidPasswordErrorMessage.getText();
    }

    @Step("Navigate to register page")
    public RegisterPage goToRegister() {
        loginPageRegisterLink.click();
        return page(RegisterPage.class);
    }

    @Step("Navigate to reset password page")
    public ResetPasswordPage goToResetPassword() {
        loginPageResetPasswordLink.click();
        return page(ResetPasswordPage.class);
    }

    public String getLoginPageTitle() {
        return loginPageInputFieldsTitle.getText();
    }
}
