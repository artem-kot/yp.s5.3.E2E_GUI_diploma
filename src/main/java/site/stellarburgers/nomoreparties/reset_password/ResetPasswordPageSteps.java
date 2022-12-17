package site.stellarburgers.nomoreparties.reset_password;

import site.stellarburgers.nomoreparties.header.HeaderPageSteps;

import static com.codeborne.selenide.Selenide.page;

public class ResetPasswordPageSteps {

    public HeaderPageSteps header(){
        return page(HeaderPageSteps.class);
    }


}
