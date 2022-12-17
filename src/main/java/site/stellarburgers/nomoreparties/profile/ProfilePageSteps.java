package site.stellarburgers.nomoreparties.profile;

import io.qameta.allure.Step;
import site.stellarburgers.nomoreparties.header.HeaderPageSteps;
import site.stellarburgers.nomoreparties.login.LoginPageSteps;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePageSteps extends ProfilePage{

    public HeaderPageSteps header(){
        return page(HeaderPageSteps.class);
    }

    @Step("Logging out")
    public LoginPageSteps logout(){
        profilePageLogoutButton.click();
        return page(LoginPageSteps.class);
    }

    public ProfilePageSteps goToUserOrdersChapter(){
        profilePageUserOrdersLink.click();
        return page(ProfilePageSteps.class);
    }

    public ProfilePageSteps goToUserProfileChapter(){
        profilePageProfileLink.click();
        return page(ProfilePageSteps.class);
    }

    public String getActiveChapterTitle(){
        return profilePageActiveChapter.getText();
    }
}
