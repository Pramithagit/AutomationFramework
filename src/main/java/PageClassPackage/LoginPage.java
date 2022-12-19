package PageClassPackage;

import com.BaseClassPackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    @FindBy(xpath="//*[@id=\"username\"]")
    WebElement username;
    @FindBy(xpath="//*[@id=\"password\"]")
    WebElement password;
    @FindBy(xpath="//*[@id=\"login\"]")
    WebElement loginBtn;
    @FindBy(xpath="//*[@id=\"register\"]")
    WebElement register;

    public LoginPage() {
        PageFactory.initElements(driver, this);

    }

    public String VerifyLoginTittle(){
        String title1=driver.getTitle();
        return title1;
    }

    public boolean verifyRegister(){
        boolean reg = register.isDisplayed();
        return reg;
    }

    public LandingPage loginmethod(String un,String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
        return new LandingPage();

    }
}
