package site.stellarburgers.nomoreparties.login;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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

}
