import home.test.Pages.Computer;
import home.test.Pages.CreateNewComputerPage;
import home.test.Pages.MainPage;
import org.junit.Before;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.openqa.selenium.By.*;


public class CreateNewComputer extends BaseTest{
private MainPage mainPage;
private CreateNewComputerPage createNewComputerPage;
private Computer computer;
    @BeforeMethod
    public  void beforeComputerAddTest() {
        chrome.navigate().to("http://computer-database.gatling.io/computers");
    }
    @Test
    public  void test (){
        mainPage = new MainPage(chrome);

        computer = new Computer();
        computer.setCompName("Super old comp");
        computer.setCompany("3");
        createNewComputerPage = mainPage.OpenNewComputerPage();
        createNewComputerPage.fillCreateForm(computer);

        mainPage=createNewComputerPage.clickCreateComputer();

        String actualResultPage;
        String expectedResultPage = "Done ! Computer " + computer.getCompName() + " has been created";
        try {
            actualResultPage = mainPage.getText();
          soft.assertTrue(actualResultPage.contains(expectedResultPage),"Computer didn't created." );
          //soft.assertTrue(actualResultPage.contains(expectedResultPage),"If test failed, !comp" );
        } catch (Exception e) {
            soft.assertTrue(false,"Functionality didn't work correctly.");
            //soft.assertTrue(false,"couldnt submit form");
        }

        //soft.assertAll();
    }
}
