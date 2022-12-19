package site.stellarburgers.nomoreparties.pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ConstructorPage {

    @FindBy(how = How.TAG_NAME, using = "h1")
    protected SelenideElement mainPageHeaderText;

    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    protected SelenideElement mainPageIngredientsDisplayBuns;

    @FindBy(how = How.XPATH, using = "//h2[text()='Булки']")
    protected SelenideElement mainPageIngredientsDisplayBunsChapterTitle;

    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']")
    protected SelenideElement mainPageIngredientsDisplaySauces;

    @FindBy(how = How.XPATH, using = "//h2[text()='Соусы']")
    protected SelenideElement mainPageIngredientsDisplaySaucesChapterTitle;

    @FindBy(how = How.XPATH, using = "//span[text()='Начинки']")
    protected SelenideElement mainPageIngredientsDisplayToppings;

    @FindBy(how = How.XPATH, using = "//h2[text()='Начинки']")
    protected SelenideElement mainPageIngredientsDisplayToppingsChapterTitle;

    @FindBy(how = How.CLASS_NAME, using = "BurgerIngredients_ingredients__menuContainer__Xu3Mo")
    protected SelenideElement mainPageIngredientsDisplayMenu;

    @FindBy(how = How.XPATH, using = "//a[@class='BurgerIngredient_ingredient__1TVf6 ml-4 mr-4 mb-8']")
    protected ElementsCollection mainPageIngredientsList;

    @FindBy(how = How.CLASS_NAME, using = "BurgerConstructor_basket__list__l9dp_")
    protected SelenideElement mainPageBurgerPreview;

    @FindBy(how = How.XPATH, using = "//div[@class='BurgerConstructor_basket__totalContainer__2Z-ho mr-10']/p")
    protected SelenideElement mainPageBurgerPreviewPrice;

    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    protected SelenideElement mainPageLoginButton;


    public HeaderPage header() {
        return page(HeaderPage.class);
    }

    public ConstructorPage waitUntilPageIsLoaded() {
        mainPageIngredientsDisplayBuns.shouldBe(Condition.interactable);
        return page(ConstructorPage.class);
    }

    @Step("Navigate to login page")
    public LoginPage goToLogin() {
        mainPageLoginButton.click();
        return page(LoginPage.class);
    }

    public ConstructorPage scrollIngredientsDisplayToToppings() {
        mainPageIngredientsDisplayToppings.click();
        mainPageIngredientsDisplayToppingsChapterTitle.shouldBe(Condition.visible);
        return page(ConstructorPage.class);
    }

    public ConstructorPage scrollIngredientsDisplayToSauces() {
        mainPageIngredientsDisplaySauces.click();
        mainPageIngredientsDisplaySaucesChapterTitle.shouldBe(Condition.visible);
        return page(ConstructorPage.class);
    }

    public ConstructorPage scrollIngredientsDisplayToBuns() {
        mainPageIngredientsDisplayBuns.click();
        mainPageIngredientsDisplayBunsChapterTitle.shouldBe(Condition.visible);
        return page(ConstructorPage.class);
    }

    public String getIngredientsTitle() {
        return mainPageHeaderText.getText();
    }
}
