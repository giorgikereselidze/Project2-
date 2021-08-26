package StepObject;

import PageObjects.AddToCart;
import PageObjects.Mp3PlayersPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.regex.Pattern;

public class Mp3PlayerPageSteps {
    Mp3PlayersPage mp3PlayersPage = new Mp3PlayersPage();

    @Step("Press Mp3 button")
    public Mp3PlayerPageSteps PressMp3Btn(){
        mp3PlayersPage.Mp3Btn.click();
        return this;
    }
    @Step("Hover on ipod touch image")
    public Mp3PlayerPageSteps HoverIpodTouchImg(){
        mp3PlayersPage.IpodTouchImg.hover();
        return this;
    }
    @Step("Check that text is visible on mp3 image hover")
    public Mp3PlayerPageSteps CheckOnHoverTextWorks(){
        mp3PlayersPage.IpodTouchImg.shouldHave(Condition.attribute("Title","iPod Touch"));
        return this;
    }
    @Step("Scroll to ipod touch heading text")
    public Mp3PlayerPageSteps ScrollToIpodTouchHeading(){
        mp3PlayersPage.IpodTouchHeading.scrollTo();
        return this;
    }
    @Step("Press ipod touch heading text")
    public Mp3PlayerPageSteps PressIpodTouchHeading(){
        mp3PlayersPage.IpodTouchHeading.click();
        return this;
    }

    AddToCart addToCart = new AddToCart();

    public Mp3PlayerPageSteps CheckPricingWorksSuccessfully(){

        //        Quantity Split
        String quantityToSplit = addToCart.quantity.getText();
        String[] strings = quantityToSplit.split("(?<=\\D)(?=\\d)");
        String quantityNum = strings[1];
//        System.out.println(quantityNum);

//        Expected Price Split
        String expectedPriceSplit = addToCart.expectedPrice.getText();
        String[] parts = expectedPriceSplit.split(Pattern.quote("."));
        String part1 = parts[0];

        String[] part = part1.split("(?<=\\D)(?=\\d)");
        String price = part[1];
//        System.out.println(price);

//      Actual Price Split
        String actualPriceSplit = addToCart.actualPrice.getText();
        String[] partss = actualPriceSplit.split(Pattern.quote("."));
        String parts1 = partss[0];

        String[] parts2 = parts1.split("(?<=\\D)(?=\\d)");
        String price2 = parts2[1];
//        System.out.println(price2);

        int finalPrice1 = Integer.parseInt(price);
        int finalPrice2 = Integer.parseInt(price2);
        int finalQuantity = Integer.parseInt(quantityNum);

        Assert.assertEquals(finalPrice1, finalPrice2 * finalQuantity);


        return this;
    }

}
