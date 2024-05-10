package com.mobile.tests.day01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class T1_Calculator {
    AppiumDriver<MobileElement> driver;

    @Test
    public void t_calculator_accessingApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //device info
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:version", "11");
        capabilities.setCapability("appium:deviceName", "Pixel_2");
        capabilities.setCapability("platformName", "Android");
        //app info
        //com.google.android.calculator/com.android.calculator2.Calculator
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver=new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
       // driver=new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        driver.closeApp();
    }
}
