package PageClassPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath="//*[@id=\"logo\"]")
    WebElement wbqa;
    @FindBy(xpath="//*[@id=\"headerfblogin\"]")
    WebElement freestudent;
    @FindBy(xpath="//*[@id=\"wblhead\"]")
    WebElement wbl;
    @FindBy(xpath="//*[@id=\"loginButton\"]")
    WebElement loginBtn;

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String VerifyTitle(){
        String title = driver.getTitle();
        return title;

    }
    public boolean verifywbllogo(){
        boolean logo =wbqa.isDisplayed();
        return logo;

    }
    public boolean verifystudent(){
        boolean stu=freestudent.isDisplayed();
        return stu;
    }
    public LoginPage VerifyLoginBtn(){
        loginBtn.click();
        return new LoginPage(driver);

    }


}
