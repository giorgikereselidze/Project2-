package StepObject;

import PageObjects.HomePage;
import io.qameta.allure.Step;

public class HomePageSteps {

    HomePage homePage = new HomePage();

    @Step("Press my account button")
    public HomePageSteps PressMyAccountBtn(){
        homePage.MyAccountBtn.click();
        return this;
    }
    @Step("Press register button")
    public HomePageSteps PressRegisterBtn(){
        homePage.RegisterBtn.click();
        return this;
    }
    @Step("Hover on Laptops&Notebooks button")
    public HomePageSteps HoverLaptopsAndNotebooksBtn(){
        homePage.LaptopsAndNotebooksBtn.hover();
        return this;
    }
    @Step("Press on All Laptops and Notebook button")
    public HomePageSteps PressShowAllLaptopAndNotebookBtn(){
        homePage.ShowAllLaptopAndNotebookBtn.click();
        return this;
    }
    @Step("Hover on Desktop button")
    public HomePageSteps HoverDesktopBtn(){
        homePage.DesktopBtn.hover();
        return this;
    }
    @Step("Press show all desktop button")
    public HomePageSteps PressShowAllDesktopBtn(){
        homePage.ShowAllDesktopBtn.click();
        return this;
    }
    @Step("Press total cart button")
    public HomePageSteps PressCartTotalBtn(){
        homePage.CartTotalBtn.click();
        return this;
    }
    @Step("Press Checkout button")
    public HomePageSteps PressCheckoutBtn(){
        homePage.CheckoutBtn.click();
        return this;
    }
}
