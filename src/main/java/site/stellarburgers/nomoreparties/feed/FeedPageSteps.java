package site.stellarburgers.nomoreparties.feed;

import com.codeborne.selenide.Condition;
import site.stellarburgers.nomoreparties.header.HeaderPageSteps;

import static com.codeborne.selenide.Selenide.page;

public class FeedPageSteps extends FeedPage{

    public HeaderPageSteps header(){
        return page(HeaderPageSteps.class);
    }

    public HeaderPageSteps waitUntilPageIsLoaded(){
        feedPageHeaderText.shouldBe(Condition.interactable);
        return page(HeaderPageSteps.class);
    }

    public String getOverallOrders(){
        return feedPageOverallCookedValue.getText();
    }
}
