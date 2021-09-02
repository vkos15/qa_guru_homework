package ru.vkost;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }
    @Test
    void fillFormTest(){

      //  open("https://demoqa.com/automation-practice-form");
        open("https://demoqa.com/text-box");
        $("#firstName").setValue("Valentina");
        $("#lastName").setValue("KUlikova");
        $("userEmail").setValue("jrhdgdfg@mail.ru");
        $(byName("gender")).click();


    }



}
