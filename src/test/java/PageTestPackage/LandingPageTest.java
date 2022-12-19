package PageTestPackage;

import PageClassPackage.HomePage;
import PageClassPackage.LandingPage;
import PageClassPackage.LoginPage;
import com.BaseClassPackage.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseClass {
    HomePage home;
    LoginPage login;  //GOES TO COLLECT CREDENTIALS
    LandingPage land;

    //creating constructor

    public LandingPageTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        initialization();
        home= new HomePage();
        login= new LoginPage();
        land= new LandingPage();
        home.VerifyLoginBtn();
        login.loginmethod(prop.getProperty("username"),prop.getProperty("password"));


    }
    @Test
    public void TestWBL(){
        boolean wbl=land.checkWBL();
        Assert.assertTrue(wbl);

    }
    @Test
    public void Testmailid(){
        boolean mailid= land.checkmailid();
        Assert.assertTrue(mailid);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}



