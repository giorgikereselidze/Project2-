package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public SelenideElement
    FirstNameInput = $("#input-firstname"),
    LastNameInput =  $("#input-lastname"),
    EmailInput = $("#input-email"),
    PhoneInput = $("#input-telephone"),
    PasswordInput = $("#input-password"),
    ConfirmPasswordInput = $("#input-confirm"),
    PrivacyPolicyBtn = $(By.xpath("//*[@name='agree']")),
    SubmitRegistrationForm = $(By.xpath("//input[@type='submit']"));
}
