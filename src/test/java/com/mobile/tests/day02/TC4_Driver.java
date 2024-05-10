package com.mobile.tests.day02;

import com.mobile.utilities.App;
import com.mobile.utilities.Device;
import com.mobile.utilities.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TC4_Driver {
    AppiumDriver<MobileElement> driver;
    Device device=Device.PIXEL2;
    App app=App.CALCULATOR;

    By l_digit1=By.id("com.google.android.calculator:id/digit_1");
    By l_digit2=By.id("com.google.android.calculator:id/digit_2");
    By l_digit3=By.id("com.google.android.calculator:id/digit_3");
    By l_digit4=By.id("com.google.android.calculator:id/digit_4");
    By l_digit5=By.id("com.google.android.calculator:id/digit_5");
    By l_digit6=By.id("com.google.android.calculator:id/digit_6");
    By l_digit7=By.id("com.google.android.calculator:id/digit_7");
    By l_digit8=By.id("com.google.android.calculator:id/digit_8");
    By l_digit9=By.id("com.google.android.calculator:id/digit_9");
    By l_digit0=By.id("com.google.android.calculator:id/digit_0");
    By l_plusBtn=By.id("com.google.android.calculator:id/op_add");
    By l_minus= By.id("com.google.android.calculator:id/op_sub");
    By l_multiply= By.id("com.google.android.calculator:id/op_mul");
    By l_divide= By.id("com.google.android.calculator:id/op_div");
    By l_equalsBtn=By.id("com.google.android.calculator:id/eq");
    By l_result= By.id("com.google.android.calculator:id/result_final");



    @Before
    public void setUp(){
        Driver.runAppium();
        driver=Driver.getDriver(device,app);
    }

    @After
    public void tearDown() {
        driver.closeApp();
        Driver.stopAppium();
    }

    @Test
    public void t4_runAppium_getDriver() {

//        Driver.runAppium();
//        driver=Driver.getDriver(device,app);

        MobileElement digit2 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        MobileElement digit3 = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        MobileElement plusBtn= driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        MobileElement equalBtn=driver.findElement(By.id("com.google.android.calculator:id/eq"));

        digit2.click();
        plusBtn.click();
        digit3.click();
        equalBtn.click();
        MobileElement result=driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        String actualResult= result.getText();
        Assert.assertEquals("5",actualResult);
//        driver.closeApp();

//        Driver.stopAppium();
    }

    @Test
    public void t5_click_multiply() {
        click(l_digit7);
        click(l_digit7);
        click(l_multiply);
        click(l_digit8);
        click(l_digit8);
        click(l_equalsBtn);
        Assert.assertEquals("6776",getText(l_result));
    }

    void click(By locator){
        Driver.getDriver().findElement(locator).click();
    }
    String getText(By locator){
      return Driver.getDriver().findElement(locator).getText();
    }
}
