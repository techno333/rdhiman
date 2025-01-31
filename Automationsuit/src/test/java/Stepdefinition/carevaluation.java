package Stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class carevaluation extends Baseclass {




    @Given("User launch Chrome browser")
    public void user_launch_chrome_browser() throws InterruptedException {
        Baseclass.Webdriverobj();


    }

    @Given("User entered valid URL:{string}")
    public void user_entered_valid_url(String URL) {
        driver.get(URL);
    }

    @When("User searched for the cars by entering valid registration number")
    public void user_searched_for_the_cars_by_entering_valid_registration_number() {

        //Baseclass.carobj.Enter_Reg();
    }

    @Then("User can see valuation of cars")
    public void user_can_see_valuation_of_cars() {


    }
}