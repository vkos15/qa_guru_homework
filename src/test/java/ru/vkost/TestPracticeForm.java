package ru.vkost;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void practiceFormTest() {

        open("https://demoqa.com/automation-practice-form");
        String firstName = "Valentina";
        String address = "Perm";
        String lastName = "Kulikova";
        String email = "jrhdgdfg@mail.ru";
        String phoneNumber = "89823455666";

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        // $(byName("gender")).parent().click();
        $("label[ for='gender-radio-1']").click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("June");
        $(".react-datepicker__year-select").selectOptionContainingText("1992");
        $(".react-datepicker__month-container").$(byText("28")).click();

        //$(".subjects-auto-complete__input").click();
        $("#subjectsInput").sendKeys("m");
        // $(".subjects-auto-complete__menu-list").$(byText("Maths")).click();
        $(".subjects-auto-complete__menu").$(byText("Maths")).click();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/photo_test.jpg"));
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText("NCR")).click();
        $("#react-select-4-input").setValue("Moscow");
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        //$("tr").$(byText("Label")).click();
        $(".table-responsive tbody tr td:nth-child(1)").shouldHave(text("Student Name"));
        $(".table-responsive tbody tr td:nth-child(2)").shouldHave(text("Valentina KUlikova"));


    }


}
