package site.stellarburgers.nomoreparties.constructor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import site.stellarburgers.nomoreparties.header.HeaderPageSteps;
import site.stellarburgers.nomoreparties.login.LoginPageSteps;

import static com.codeborne.selenide.Selenide.page;

public class ConstructorPageSteps extends ConstructorPage{

    public HeaderPageSteps header(){
        return page(HeaderPageSteps.class);
    }

    public ConstructorPageSteps waitUntilPageIsLoaded(){
        mainPageIngredientsDisplayBuns.shouldBe(Condition.interactable);
        return page(ConstructorPageSteps.class);
    }

    public LoginPageSteps goToLogin(){
        mainPageLoginButton.click();
        return page(LoginPageSteps.class);
    }

    public ConstructorPageSteps scrollIngredientsDisplayToToppings(){
        mainPageIngredientsDisplayToppings.click();
        mainPageIngredientsDisplayToppingsChapterTitle.shouldBe(Condition.visible);
        return page(ConstructorPageSteps.class);
    }

    public ConstructorPageSteps scrollIngredientsDisplayToSauces(){
        mainPageIngredientsDisplaySouces.click();
        mainPageIngredientsDisplaySoucesChapterTitle.shouldBe(Condition.visible);
        return page(ConstructorPageSteps.class);
    }

    public ConstructorPageSteps scrollIngredientsDisplayToBuns(){
        mainPageIngredientsDisplayBuns.click();
        mainPageIngredientsDisplayBunsChapterTitle.shouldBe(Condition.visible);
        return page(ConstructorPageSteps.class);
    }

}
