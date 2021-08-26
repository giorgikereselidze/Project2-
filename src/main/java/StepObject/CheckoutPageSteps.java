package StepObject;

import DataObjects.SqlDb;
import PageObjects.CheckoutPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckoutPageSteps {
    CheckoutPage checkoutPage = new CheckoutPage();

    @Step("Fill Billing Information")
    public CheckoutPageSteps fillBillingInformation() throws SQLException {

//        Connect to db
        Connection connection = SqlDb.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id=(SELECT max(id) FROM users);");

        while (resultSet.next()) {
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String address = resultSet.getString("address");
            String city = resultSet.getString("city");
            String postCode = resultSet.getString("zip");
            String country = resultSet.getString("country");
            String state = resultSet.getString("state");

            checkoutPage.FirstName.setValue(firstName);
            checkoutPage.LastName.setValue(lastName);
            checkoutPage.Address1.setValue(address);
            checkoutPage.City.setValue(city);
            checkoutPage.PostCode.setValue(postCode);
            checkoutPage.Country.selectOption(country);
            checkoutPage.State.selectOption(state);
        }

        return this;
    }

    public CheckoutPageSteps pressContinue(){
        checkoutPage.BillingDetailsContinueBtn.click();
        return this;
    }

    public CheckoutPageSteps pressDeliveryDetailsContinueBtn(){
        checkoutPage.DeliveryDetailsContinueBtn.click();
        return this;
    }

    public CheckoutPageSteps pressDeliveryMethodContinueBtn(){
        checkoutPage.DeliveryMethodContinueBtn.click();
        return this;
    }

    public CheckoutPageSteps checkTerms(){
        checkoutPage.TermsAndConditionsCheckbox.click();
        return this;
    }

    public CheckoutPageSteps pressPaymentMethodContinueBtn(){
        checkoutPage.PaymentMethodContinueBtn.click();
        return this;
    }

    @Step("Check SubTotal Flat Shipping Rate and Total Prices is correct")
    public CheckoutPageSteps checkSubTotalFlatShippingTotalPrice(){
        String subTotalString = checkoutPage.subTotal.getText();
        String subTotalNumbersOnly = subTotalString.replaceAll("[^0-9]", "");
        int subTotalAsInt = Integer.parseInt(subTotalNumbersOnly);

        String flatShippingRate = checkoutPage.flatShippingRate.getText();
        String flatShippingNumbersOnly = flatShippingRate.replaceAll("[^0-9]", "");
        int flatShippingAsInt = Integer.parseInt(flatShippingNumbersOnly);

        String totalPrice = checkoutPage.totalPrice.getText();
        String totalPriceNumbersOnly = totalPrice.replaceAll("[^0-9]", "");
        int totalAsInt = Integer.parseInt(totalPriceNumbersOnly);

        Assert.assertEquals(subTotalAsInt+flatShippingAsInt,totalAsInt);

        return this;
    }



    @Step("Confirm Order")
    public CheckoutPageSteps confirmOrder(){
        checkoutPage.ConfirmBtn.click();
        return this;
    }





}
