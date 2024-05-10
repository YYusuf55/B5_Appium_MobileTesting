package com.mobile.tests.day02;

import com.mobile.utilities.App;
import com.mobile.utilities.Device;
import com.mobile.utilities.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.List;

import static com.mobile.utilities.utils.openApp;

public class TC6_AmazonApp {
    AppiumDriver<MobileElement> driver;
    @Before
    public void setUp(){
        driver=openApp(Device.PIXEL2, App.AMAZON);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.closeApp();
        Driver.stopAppium();
    }

    @Test
    public void T8_amazonSearch() {
         /*
        Open the Amazon App
        Click skip sign in
        Search apple watch series
        click apple watch series 9
         */

        List<MobileElement> dontRemind = driver.findElements(By.id("com.amazon.mShop.android.shopping:id/checkBox"));

        if(dontRemind.size()>0){
            driver.findElement(By.id("com.amazon.mShop.android.shopping:id/checkBox")).click();
        }

        //*[text()='Skip sign in'] --> Selenium UI syntax
        //*[@text='Skip sign in']  --> Appium syntax

        MobileElement skipSignInBtn = driver.findElement(By.xpath("//*[@text='Skip sign in']"));
        skipSignInBtn.click();

        MobileElement searchBox = driver.findElement(By.xpath("//*[@text='Search Amazon']"));
        searchBox.click();

        try{
            searchBox.sendKeys("apple watch series"+ Keys.ENTER);
        }catch (StaleElementReferenceException s){
            searchBox=driver.findElement(By.xpath("//*[@text='Search Amazon']"));
            searchBox.sendKeys("apple watch series" + Keys.ENTER);
        }


    }
}
