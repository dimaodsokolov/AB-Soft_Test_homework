package home.test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {
    private  WebDriver driver;


    @FindBy (id = "add")
    private WebElement addButton;

    @FindBy (className ="alert-message")
    private WebElement alertMessage;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateNewComputerPage OpenNewComputerPage(){
        addButton.click();
        return new CreateNewComputerPage(driver);
    }

    public String getText(){
    return alertMessage.getText();
    }

}


