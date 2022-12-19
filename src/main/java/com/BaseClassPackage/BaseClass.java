package com.BaseClassPackage;

import UtilsPackage.Utils;
import UtilsPackage.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public static Properties prop;

    public static EventFiringWebDriver e_driver;

    public static WebEventListener eventListener;


    public BaseClass(){
        try {
            prop = new Properties();
            FileInputStream in = new FileInputStream(
                    "/Users/deepa/Documents/prep/java/TestNG/NewAutomation/src/main/java/ConfigPackage/Config.Properties");
            prop.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        e_driver=new EventFiringWebDriver(driver);  //create an object for EventFiringWEbDriver
        eventListener = new WebEventListener(); //create object of EventListenerHandler to register it with EventFiringWebDriver
        e_driver.register(eventListener);
        driver = e_driver;



        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
}
}
