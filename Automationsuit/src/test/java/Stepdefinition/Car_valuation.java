package Stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;


public class Car_valuation {

    ArrayList<String> Carvalues = new ArrayList<>();


    @Given("User is on the Homepage")
    public void user_is_on_the_homepage() throws InterruptedException {
        Baseclass.Webdriverobj();
    }

    @When("User enters the Regnumber")
    public void user_enters_the_regnumber() throws InterruptedException {
        String[] regNumbers = ExtractRegFromText.extractRegistrationNumbers();

        for (int i=0;i<regNumbers.length;i++) {
            Baseclass.carobj.Enter_Reg(regNumbers[i]);
            Baseclass.carobj.Click_Confirm_Buying();
            Baseclass.carobj.Click_ValueCar_button();
            Carvalues.add(Baseclass.carobj.Get_Value_of_Car());

            for (String name : Carvalues) {
                System.out.println(name);
            }

            Baseclass.carobj.click_backbutton();
            Thread.sleep(2000);
        }

    }

    @Then("User gets the car value")
    public void user_gets_the_car_value() {

        for (String name : Carvalues) {
            System.out.println(name);
        }

    }

}
