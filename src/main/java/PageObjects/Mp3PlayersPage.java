package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class Mp3PlayersPage {
    public SelenideElement
    Mp3Btn = $(By.xpath("//a[contains(text(),'MP3 Players') and @class='list-group-item']")),
    IpodTouchImg = $(by("title", "iPod Touch")),
    IpodTouchHeading = $(withText("iPod Touch"));


}
