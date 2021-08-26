import StepObject.*;
import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;


@Listeners({SoftAsserts.class, ScreenShooter.class})
@Epic("Project 2")
@Feature("Website Testing")
public class WebsiteTest {
    public WebsiteTest() {
        assertionMode = AssertionMode.SOFT;
        startMaximized = true;
        timeout = 5000;
        holdBrowserOpen = false;
        reportsFolder = "build/reports";
        savePageSource = false;
    }

    @BeforeTest(groups = {"Regression1"})
    public void beforeTest() {
        open("http://tutorialsninja.com/demo/");
    }

    @Test(groups = {"Regression1"},priority = 1)
    @Description("Test Description : User Registration")
    @Story("Test fills registration form")
    public void userRegistration() throws SQLException {
        HomePageSteps homePageSteps = new HomePageSteps();
        RegistrationSteps registrationSteps = new RegistrationSteps();

        homePageSteps.PressMyAccountBtn();
        homePageSteps.PressRegisterBtn();

        registrationSteps.FillRegistrationForm();

        registrationSteps.scrollToPrivacyPolicy();
        registrationSteps.agreePrivacyPolicy();
        registrationSteps.ClickRegistrationFormSubmit();

    }



    @Test(groups = {"Regression1"},priority = 2)
    @Description("Test Description : Laptops And Notebooks Page test method")
    @Story("Test checks sorting Functional")
    public void LaptopsAndNotebooksTest() {
        HomePageSteps homePageSteps = new HomePageSteps();
        LaptopsAndNotebookPageSteps laptopsAndNotebookPageSteps = new LaptopsAndNotebookPageSteps();

        homePageSteps.HoverLaptopsAndNotebooksBtn();
        homePageSteps.PressShowAllLaptopAndNotebookBtn();

        laptopsAndNotebookPageSteps.SelectHighToLowSortOption();


//        Check That Sorting Works
        laptopsAndNotebookPageSteps.CheckThatSortingWorks();

    }


    @Test(dependsOnMethods = {"userRegistration"},groups = {"Regression2"},priority = 3)
    @Description("Test Description : Mp3 test")
    @Story("Test checks checkout functional")
    public void mp3Test() {
        HomePageSteps homePageSteps = new HomePageSteps();
        Mp3PlayerPageSteps mp3PlayerPageSteps = new Mp3PlayerPageSteps();
        AddToCartSteps addToCartSteps = new AddToCartSteps();


        homePageSteps.HoverDesktopBtn();
        homePageSteps.PressShowAllDesktopBtn();
        mp3PlayerPageSteps.PressMp3Btn();

        mp3PlayerPageSteps.ScrollToIpodTouchHeading();

//        Check onHover text
        mp3PlayerPageSteps.CheckOnHoverTextWorks();

        mp3PlayerPageSteps.PressIpodTouchHeading();

//        Add to cart
        addToCartSteps.PressBtnCart();
        addToCartSteps.PressTotalBtn();

//        Assertion Check
        mp3PlayerPageSteps.CheckPricingWorksSuccessfully();

    }

    @Test(dependsOnMethods = {"userRegistration","mp3Test"},retryAnalyzer = Retry.class,groups = {"Regression2"},priority = 4)
    @Description("Test Description : Fill billing information and order the item")
    @Story("Test orders the item")
    public void orderTheItem() throws SQLException {
        HomePageSteps homePageSteps = new HomePageSteps();
        CheckoutPageSteps checkoutPageSteps = new CheckoutPageSteps();

        homePageSteps.PressCartTotalBtn();
        homePageSteps.PressCheckoutBtn();

        checkoutPageSteps.fillBillingInformation();
        checkoutPageSteps.pressContinue();
        checkoutPageSteps.pressDeliveryDetailsContinueBtn();
        checkoutPageSteps.pressDeliveryMethodContinueBtn();
        checkoutPageSteps.checkTerms();
        checkoutPageSteps.pressPaymentMethodContinueBtn();


//        assertion check
        checkoutPageSteps.checkSubTotalFlatShippingTotalPrice();



        checkoutPageSteps.confirmOrder();







    }


}

