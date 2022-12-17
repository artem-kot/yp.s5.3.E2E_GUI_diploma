package site.stellarburgers.nomoreparties.header;

import io.qameta.allure.Step;
import site.stellarburgers.nomoreparties.constructor.ConstructorPageSteps;
import site.stellarburgers.nomoreparties.feed.FeedPageSteps;
import site.stellarburgers.nomoreparties.login.LoginPageSteps;
import site.stellarburgers.nomoreparties.profile.ProfilePage;
import site.stellarburgers.nomoreparties.profile.ProfilePageSteps;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.page;

public class HeaderPageSteps extends HeaderPage{

    @Step("Navigate to main page")
    public ConstructorPageSteps goToConstructor(){
        try{
            Thread.sleep(500); //sleep is added to deal with NFR issue at the test stand.
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        headerConstructorButton.click();
        return page(ConstructorPageSteps.class);
    }

    @Step("Navigate to feed page")
    public FeedPageSteps goToFeed(){
        headerFeedButton.click();
        return page(FeedPageSteps.class);
    }

    @Step("Navigate to login page")
    public LoginPageSteps goToLogin(){
        headerLoginButton.click();
        return page(LoginPageSteps.class);
    }

    @Step("Navigate to profile page")
    public ProfilePageSteps goToProfile(){
        headerLoginButton.click();
        return page(ProfilePageSteps.class);
    }

    public ConstructorPageSteps goToLogo(){
        try{
            Thread.sleep(500); //sleep is added to deal with NFR issue at the test stand.
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        headerLogoImage.click();
        return page(ConstructorPageSteps.class);
    }
}
