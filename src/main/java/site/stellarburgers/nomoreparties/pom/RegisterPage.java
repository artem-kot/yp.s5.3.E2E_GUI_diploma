package site.stellarburgers.nomoreparties.pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {

    @FindBy(how = How.XPATH, using = "//h2[text()='Регистрация']")
    protected SelenideElement registerPageInputFieldsTitle;

    @FindBy(how = How.XPATH, using = "//label[text()='Имя']/following-sibling::input")
    protected SelenideElement registerPageInputFieldName;

    @FindBy(how = How.XPATH, using = "//label[text()='Email']/following-sibling::input")
    protected SelenideElement registerPageInputFieldEmail;

    @FindBy(how = How.XPATH, using = "//label[text()='Пароль']/following-sibling::input")
    protected SelenideElement registerPageInputFieldPassword;

    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    protected SelenideElement registerPageRegisterButton;

    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    protected SelenideElement registerPageLoginLink;

    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    protected SelenideElement registerPageInvalidPasswordErrorMessage;

    public HeaderPage header() {
        return page(HeaderPage.class);
    }

    private RegisterPage fillName(String name) {
        registerPageInputFieldName.clear();
        registerPageInputFieldName.sendKeys(name);
        return page(RegisterPage.class);
    }

    private RegisterPage fillEmail(String email) {
        registerPageInputFieldEmail.clear();
        registerPageInputFieldEmail.sendKeys(email);
        return page(RegisterPage.class);
    }

    private RegisterPage fillPassword(String password) {
        registerPageInputFieldPassword.clear();
        registerPageInputFieldPassword.sendKeys(password);
        return page(RegisterPage.class);
    }

    @Step("Registering with valid credentials")
    public LoginPage validRegistration(String name, String email, String password) {
        fillName(name)
                .fillEmail(email)
                .fillPassword(password)
                .registerPageRegisterButton.click();
        return page(LoginPage.class);
    }

    @Step("Attempting to register with invalid credentials")
    public RegisterPage invalidRegistration(String name, String email, String password) {
        fillName(name)
                .fillEmail(email)
                .fillPassword(password)
                .registerPageRegisterButton.click();
        return page(RegisterPage.class);
    }

    public String getRegisterErrorMessage() {
        registerPageInvalidPasswordErrorMessage.shouldBe(Condition.visible);
        return registerPageInvalidPasswordErrorMessage.getText();
    }

    @Step("Navigate to login page")
    public LoginPage goToLogin() {
        registerPageLoginLink.click();
        return page(LoginPage.class);
    }
}
