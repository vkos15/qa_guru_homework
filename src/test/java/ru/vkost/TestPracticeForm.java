package ru.vkost;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }
    @Test
    void fillFormTest(){

        open("https://demoqa.com/automation-practice-form");
       // open("https://demoqa.com/text-box");
        $("#firstName").setValue("Valentina");
        $("#lastName").setValue("KUlikova");
        $("#userEmail").setValue("jrhdgdfg@mail.ru");
       // $(byName("gender")).parent().click();
       // $("input[name='gender'] label").click();
        $("label[ for='gender-radio-1']").click();
        $("#userNumber").setValue("89823455666");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("June");
        $(".react-datepicker__year-select").selectOptionContainingText("1992");
        $(".react-datepicker__month-container").$(byText("28")).click();

        //$(".subjects-auto-complete__input").click();
        $("#subjectsInput").sendKeys("m");
        //.sendKeys("m");
       // $(".subjects-auto-complete__menu-list").$(byText("Maths")).click();
        $(".subjects-auto-complete__menu").$(byText("Maths")).click();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/photo_test.jpg"));
        $("#currentAddress").setValue("Perm");
   //     $("#submit").click();
//$x("//div[text()='Select State']").click();
        $(byText("Select State")).click();
        $("#state").click();
    //$(byText("NCR")).click();
        $("#react-select-3-option-0").click();

        sleep(10000);



    }



}
