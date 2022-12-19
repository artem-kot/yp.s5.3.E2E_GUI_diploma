package site.stellarburgers.nomoreparties.pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class FeedPage {

    @FindBy(how = How.TAG_NAME, using = "h1")
    protected SelenideElement feedPageHeaderText;

    @FindBy(how = How.XPATH, using = "//li[@class='OrderHistory_listItem__2x95r mb-6']")
    protected ElementsCollection feedPageOrdersList; // only the last 50 are shown

    @FindBy(how = How.XPATH, using = "//p[text()='Готовы:']")
    protected SelenideElement feedPageReadyOrdersHeader;

    @FindBy(how = How.XPATH, using = "//li[@class='text text_type_digits-default mb-2']")
    protected ElementsCollection feedPageReadyOrdersNumbers; // only the last 5 are shown

    @FindBy(how = How.XPATH, using = "//p[text()='В работе:']")
    protected SelenideElement feedPageCookingOrdersHeader;

    @FindBy(how = How.XPATH, using = "//p[text()='Выполнено за все время:']")
    protected SelenideElement feedPageOverallCookedHeader;

    @FindBy(how = How.XPATH, using = "//p[text()='Выполнено за все время:']/following-sibling::p")
    protected SelenideElement feedPageOverallCookedValue;

    @FindBy(how = How.XPATH, using = "//p[text()='Выполнено за сегодня:']")
    protected SelenideElement feedPageTodayCookedHeader;

    @FindBy(how = How.XPATH, using = "//p[text()='Выполнено за сегодня:']/following-sibling::p")
    protected SelenideElement feedPageTodayCookedValue;

    public HeaderPage header() {
        return page(HeaderPage.class);
    }

    public HeaderPage waitUntilPageIsLoaded() {
        feedPageHeaderText.shouldBe(Condition.interactable);
        return page(HeaderPage.class);
    }

    public String getOverallOrders() {
        return feedPageOverallCookedValue.getText();
    }
}
