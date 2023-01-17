package PageClassPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    @FindBy(id="wblhead")
    WebElement wbl;
    @FindBy(xpath="//a[@href=\"mailto:info@whitebox-learning.com\"]")
    WebElement mailid;

    public LandingPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public boolean checkWBL(){
        return wbl.isEnabled();
    }
    public boolean checkmailid(){
        return mailid.isDisplayed();
    }
}


