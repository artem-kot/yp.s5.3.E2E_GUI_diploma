package site.stellarburgers.nomoreparties.profile;

import site.stellarburgers.nomoreparties.header.HeaderPageSteps;
import site.stellarburgers.nomoreparties.login.LoginPageSteps;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePageSteps extends ProfilePage{

    public HeaderPageSteps header(){
        return page(HeaderPageSteps.class);
    }


    public LoginPageSteps logout(){
        profilePageLogoutButton.click();
        return page(LoginPageSteps.class);
    }
}
