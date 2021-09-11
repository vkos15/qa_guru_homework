package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {

    private SelenideElement formTitle = $(".practice-form-wrapper");
    private final String FORM_TITLE = "Student Registration Form";
    private final String FORM_TITLE_AFTER_SUBMIT = "Thanks for submitting the form";
    private SelenideElement firstName = $("#firstName");
    private SelenideElement lastName = $("#lastName");
    private SelenideElement email = $("#userEmail");
    private SelenideElement gender_male = $("label[ for='gender-radio-1']");
    private SelenideElement gender_female = $("label[ for='gender-radio-2']");
    private SelenideElement gender_other = $("label[ for='gender-radio-3']");
    private SelenideElement phone_number = $("#userNumber");

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstName.setValue(value);
        return this; //вернули снова страницу
    }

    public RegistrationPage typeLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String email) {
        this.email.setValue(email);
        return this;
    }

    public RegistrationPage chooseGender(String usergender) {

        $("#genterWrapper").$(byText(usergender)).click();
        return this;


    }

    public void typePhoneNumber(String phoneNumber) {
        phone_number.setValue(phoneNumber);

    }

    public void selectSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();

    }

    public void selectHobbyes(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();

    }

    public void uploadYourPhoto(String fileName) {
        $("#uploadPicture").uploadFromClasspath(fileName);

    }

    public void typeAddress(String address) {
        $("#currentAddress").setValue(address);

    }

    public RegistrationPage selectState(String state) {
        $("#state").scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;

    }

    public void selectCity(String city) {
        $("#city").scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText(city)).click();

    }

    public void submitForm() {
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    }

    public RegistrationPage checkFieldInForm(String nameOfField, String valueOfField) {
        $x("//td[text()=" + "'" + nameOfField + "'" + "]/following-sibling::td").shouldHave(text(valueOfField));
        return this;
    }


}
