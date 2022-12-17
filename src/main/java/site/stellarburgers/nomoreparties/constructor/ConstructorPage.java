package site.stellarburgers.nomoreparties.constructor;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConstructorPage {

//    Main page constructor part

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

//    Main page burger preview

    @FindBy(how = How.XPATH, using = "//div[@class='BurgerConstructor_basket__totalContainer__2Z-ho mr-10']/p")
    protected SelenideElement mainPageBurgerPreviewPrice;

    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    protected SelenideElement mainPageLoginButton;
}
