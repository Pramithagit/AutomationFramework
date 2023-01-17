package PageTestPackage;

import PageClassPackage.HomePage;
import com.BaseClassPackage.BasePageTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import UtilsPackage.Utils;

public class HomePageTest extends BasePageTest {
    HomePage home;

    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        initialization();
        Utils.setWebDriver(driver);
        home=new HomePage(driver);
    }
    @Test()
    public void TestTitle(){
        String actual =home.VerifyTitle();
        String expected ="QA/QE/SDET Training.";
        Assert.assertEquals(expected,actual);
    }
    @Test()
    public void VerifywblLogoTest(){
        boolean logo=home.verifywbllogo();
        Assert.assertTrue(logo);
    }
    @Test()
    public void VerifystudentTest(){
        boolean student = home.verifystudent();
        Assert.assertTrue(student);
    }
    @Test()
    public void TestLoginBtn(){
        home.VerifyLoginBtn();
    }

    @AfterMethod
    public void TearDown(){

        driver.quit();
    }
}

