package site.stellarburgers.nomoreparties.header;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderPage {

//    Header buttons

    @FindBy(how = How.XPATH,using = "//p[text()='Конструктор']")
    protected SelenideElement headerConstructorButton;

    @FindBy(how = How.XPATH,using = "//p[text()='Лента Заказов']")
    protected SelenideElement headerFeedButton;

    @FindBy(how = How.XPATH,using = "//p[text()='Личный Кабинет']")
    protected SelenideElement headerLoginButton;

    @FindBy(how = How.CLASS_NAME,using = "active")
    protected SelenideElement headerLogoImage;

}
