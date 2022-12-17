package site.stellarburgers.nomoreparties.header;

import site.stellarburgers.nomoreparties.constructor.ConstructorPageSteps;
import site.stellarburgers.nomoreparties.feed.FeedPageSteps;
import site.stellarburgers.nomoreparties.login.LoginPageSteps;

import static com.codeborne.selenide.Selenide.page;

public class HeaderPageSteps extends HeaderPage{

    public ConstructorPageSteps goToConstructor(){
        headerConstructorButton.click();
        return page(ConstructorPageSteps.class);
    }

    public FeedPageSteps goToFeed(){
        headerFeedButton.click();
        return page(FeedPageSteps.class);
    }

    public LoginPageSteps goToLogin(){
        headerLoginButton.click();
        return page(LoginPageSteps.class);
    }

    public ConstructorPageSteps goToLogo(){
        headerLogoImage.click();
        return page(ConstructorPageSteps.class);
    }
}
