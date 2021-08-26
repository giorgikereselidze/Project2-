package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddToCart {
    public SelenideElement
    BtnCart = $("#button-cart"),
    CartTotal = $("#cart-total"),

//        ამაზე დინამიურად ვერ დავიჭირე :(
    expectedPrice = $(By.xpath("//ul[@class=\"list-unstyled\"]/li/h2")),
    actualPrice = $(By.xpath("//table[@class='table table-striped']/tbody/tr/td[@class='text-right'][2]")),
    quantity = $(By.xpath("//table[@class='table table-striped']/tbody/tr/td[@class='text-right'][1]"));

}
