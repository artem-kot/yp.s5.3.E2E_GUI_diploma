package site.stellarburgers.nomoreparties.register;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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
}
