package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public SelenideElement
    MyAccountBtn = $(By.xpath("//span[text()='My Account']")),
    RegisterBtn = $(By.xpath("//a[text()='Register']")),
    LaptopsAndNotebooksBtn = $(By.xpath("//a[text()='Laptops & Notebooks']")),
    ShowAllLaptopAndNotebookBtn = $(By.xpath("//a[text()='Show All Laptops & Notebooks']")),
    DesktopBtn = $(By.xpath("//a[text()='Desktops']")),
    ShowAllDesktopBtn = $(By.xpath("//a[text()='Show All Desktops']")),
    CartTotalBtn = $("#cart-total"),
    CheckoutBtn = $(by("title", "Checkout"));
}
