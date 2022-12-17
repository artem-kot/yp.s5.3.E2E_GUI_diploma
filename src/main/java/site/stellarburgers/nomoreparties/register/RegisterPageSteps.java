package site.stellarburgers.nomoreparties.register;

import site.stellarburgers.nomoreparties.header.HeaderPageSteps;

import static com.codeborne.selenide.Selenide.page;

public class RegisterPageSteps {

    public HeaderPageSteps header(){
        return page(HeaderPageSteps.class);
    }

}
