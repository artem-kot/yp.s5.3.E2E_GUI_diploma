package site.stellarburgers.nomoreparties;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.stellarburgers.nomoreparties.constructor.ConstructorPageSteps;
import site.stellarburgers.nomoreparties.header.HeaderPageSteps;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Testing constructor ingredients display navigation")
public class ConstructorIngredientsTest extends BaseTest {

    @Test
    @DisplayName("Test switching among ingredients on the main page")
    @Description("Navigating to main page, continuously clicking toppings, sauces and buns, validating appearance of correct ingredients on the screen.")
    public void testSwitchingIngredients() {
        assertThat(open(url, ConstructorPageSteps.class)
                .scrollIngredientsDisplayToToppings()
                .scrollIngredientsDisplayToSauces()
                .scrollIngredientsDisplayToBuns()
                .getIngredientsTitle(), equalTo(ingredientsTittleText));
    }
}
