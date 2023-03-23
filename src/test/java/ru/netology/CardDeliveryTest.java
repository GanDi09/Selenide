package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {

   private String generateDate(int addDays, String pattern){
       return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    void shouldDeliveryTest(){
        Configuration.holdBrowserOpen = true;

        open("http://localhost:9999");
        $("span[data-test-id=city] input").setValue("Казань");
        String currentDate = generateDate(5, "dd.MM.yyyy");
        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").sendKeys(currentDate);
        $("span[data-test-id=name] input").setValue("Роман");
        $("span[data-test-id=phone] input").setValue("+76587654678");
        $("[data-test-id=agreement]").click();
        $x("//span[contains(text(),'Забронировать')]").click();
        $("[data-test-id=notification]") .shouldBe(visible, Duration.ofSeconds(15)); ;


    }


}
