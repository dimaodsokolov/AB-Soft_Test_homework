package home.test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

public class CreateNewComputerPage {
    private final WebDriver driver;
    private  boolean crash = false;

    public CreateNewComputerPage(WebDriver driver) {
        this.driver = driver;
    }

    //@FindBy (css = ".btn.primary")
    //@FindBy (tagName="form")
    private WebElement createComputer;

    public void fillName(String name){
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void fillIntroducedDate() {
        WebElement introduceField = driver.findElement(By.id("introduced"));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date dateInstance = new Date();
        cal.setTime(dateInstance);
        cal.add(Calendar.YEAR, -30);
        Date dateBefore10years = cal.getTime();

        introduceField.sendKeys(dateFormat.format(dateBefore10years));
    }
    public void fillDiscontinuedDate() {
        WebElement DiscontinuedField = driver.findElement(By.id("Discontinued"));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date dateInstance = new Date();
        cal.setTime(dateInstance);

        Date date = cal.getTime();

        DiscontinuedField.sendKeys(dateFormat.format(date));
    }

    public void selectCompany (String company){
        WebElement companyDropDown = driver.findElement(By.id("company"));
        Select value = new Select(companyDropDown);
        value.selectByValue(company);
    }

    public MainPage clickCreateComputer() {

        try {
            driver.findElement(new By.ByCssSelector(".btn.primary")).click();

        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("NoSuchElementException");
        } catch (NullPointerException np){
            System.out.println("NullPointer");
        }

        return new MainPage(driver);

    }

    public void fillCreateForm(Computer computer){
    fillName(computer.getCompName());
    fillIntroducedDate();
    fillDiscontinuedDate();
    selectCompany(computer.getCompany());


    }


}
