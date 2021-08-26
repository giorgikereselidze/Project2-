package StepObject;

import PageObjects.AddToCart;
import io.qameta.allure.Step;

public class AddToCartSteps {
    AddToCart addToCart = new AddToCart();
    @Step("Press add to cart button")
    public AddToCartSteps PressBtnCart(){
        addToCart.BtnCart.click();
        return this;
    }
    @Step("Press total cart button")
    public AddToCartSteps PressTotalBtn(){
        addToCart.CartTotal.click();
        return this;
    }
}
