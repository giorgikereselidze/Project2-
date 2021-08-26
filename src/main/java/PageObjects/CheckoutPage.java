package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    public SelenideElement

//    Billing

    FirstName =  $("#input-payment-firstname"),
    LastName = $("#input-payment-lastname"),
    Address1 = $("#input-payment-address-1"),
    City = $("#input-payment-city"),
    PostCode = $("#input-payment-postcode"),
    Country = $("#input-payment-country"),
    State = $("#input-payment-zone"),
    BillingDetailsContinueBtn = $("#button-payment-address"),

//    Delivery Details

    DeliveryDetailsContinueBtn = $("#button-shipping-address"),

//    Delivery Method

    DeliveryMethodContinueBtn = $("#button-shipping-method"),

//    Payment Method

    PaymentMethodContinueBtn = $("#button-payment-method"),
    TermsAndConditionsCheckbox = $(by("name","agree")),

//    Assertion

//    ამაზე დინამიურადაც ვერ დავიჭირე :/
    subTotal = $(By.xpath("//table[@class='table table-bordered table-hover']/tfoot/tr/td[@class='text-right'][2]")),
    flatShippingRate = $(By.xpath("//table[@class='table table-bordered table-hover']/tfoot/tr[2]/td[@class='text-right'][2]")),
    totalPrice = $(By.xpath("//table[@class='table table-bordered table-hover']/tfoot/tr[3]/td[@class='text-right'][2]")),

//    Confirm Order

    ConfirmBtn = $("#button-confirm");
}
