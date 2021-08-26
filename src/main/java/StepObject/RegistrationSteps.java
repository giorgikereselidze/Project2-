package StepObject;

import DataObjects.SqlDb;
import PageObjects.RegistrationPage;
import io.qameta.allure.Step;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class RegistrationSteps {

    RegistrationPage registrationPage = new RegistrationPage();

    @Step("Fill registration form")
    public RegistrationSteps FillRegistrationForm() throws SQLException {

        //        Connect to db
        Connection connection = SqlDb.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id=(SELECT max(id) FROM users);");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String fName = resultSet.getString("firstName");
            String lName = resultSet.getString("lastName");
            String mail = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            String password = resultSet.getString("password");


//            Generate random string
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            int length = 7;
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(alphabet.length());
                char randomChar = alphabet.charAt(index);
                sb.append(randomChar);
            }
            String randomString = sb.toString();

            registrationPage.FirstNameInput.setValue(fName);
            registrationPage.LastNameInput.setValue(lName);
            registrationPage.EmailInput.setValue(randomString+mail);
            registrationPage.PhoneInput.setValue(phone);
            registrationPage.PasswordInput.setValue(password);
            registrationPage.ConfirmPasswordInput.setValue(password);
        }

        return this;
    }
    @Step("Scroll to PrivacyPolicy")
    public RegistrationSteps scrollToPrivacyPolicy(){
        registrationPage.PrivacyPolicyBtn.scrollTo();
        return this;
    }
    @Step("Agree PrivacyPolicy")
    public RegistrationSteps agreePrivacyPolicy(){
        registrationPage.PrivacyPolicyBtn.click();
        return this;
    }
    @Step("Click Registration form submit button")
    public RegistrationSteps ClickRegistrationFormSubmit(){
        registrationPage.SubmitRegistrationForm.click();
        return this;
    }
}
