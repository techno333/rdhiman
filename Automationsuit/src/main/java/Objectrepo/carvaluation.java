package Objectrepo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class carvaluation {
    public WebDriver driver;


    public carvaluation (WebDriver rdriver) {
        this.driver = rdriver;
        PageFactory.initElements(rdriver,this);

    }


    @FindBy(id="button-save-all")
    WebElement cookieclose;

    public void cookie_close(){
        cookieclose.click();
    }


    @FindBy(linkText = "Get a car valuation")
    WebElement getvaluecarbutton;

    public void getvalue_button(){
        getvaluecarbutton.click();
    }


   @FindBy(id="Registration")
    WebElement EnterReg;

    public void Enter_Reg(String reg){
        EnterReg.sendKeys(reg);
    }

    @FindBy(xpath = "/html/body/main/div/form/footer/div/button")
    WebElement valuecarbutton;

    public void Click_ValueCar_button(){
        valuecarbutton.click();
    }

    @FindBy(xpath = "/html/body/main/div/form/div[2]/div[2]/div/label")
    WebElement confirmsellorbuy;

    public void Click_Confirm_Buying() throws InterruptedException {

        confirmsellorbuy.click();

    }

    @FindBy(xpath = "/html/body/main/div/div[1]/div[1]/div[1]/div/p[2]")
    WebElement Getvalueofcar;

    public String Get_Value_of_Car(){
        return Getvalueofcar.getText();
    }

    @FindBy(linkText="Back")
    WebElement backbutton;

    public void click_backbutton(){
        backbutton.click();
    }



}

