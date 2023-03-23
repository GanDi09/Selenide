package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {

    @Test
    void shouldDeliveryTest(){
        Configuration.holdBrowserOpen = true;

        open("http://localhost:9999");
        $("span[data-test-id=city] input").setValue("Казань");
        //$("[data-test-id=date]").click();
        //$("[data-test-id=date]").sendKeys(Keys.BACK_SPACE);
        $("span[data-test-id=name] input").setValue("Роман");
        $("span[data-test-id=phone] input").setValue("+76587654678");
        $("[data-test-id=agreement]").click();
        $x("//span[contains(text(),'Забронировать')]").click();
        $("[data-test-id=notification]") .shouldBe(visible, Duration.ofSeconds(15)); ;


    }


}
