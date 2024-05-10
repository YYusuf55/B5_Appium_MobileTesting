package com.mobile.tests.day01;

import com.mobile.utilities.Device;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class T3_enumClass {
    AppiumDriver<MobileElement> driver;
    AppiumDriverLocalService service;
    Device device=Device.PIXEL2;

    @Test
    public void t_appium_enum_with_Device_and_App() throws MalformedURLException {

        service=new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                //.usingPort(1111)
                .usingAnyFreePort()
                .build();
        service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //device info
        capabilities.setCapability("appium:udid", device.udid);
        capabilities.setCapability("appium:version", device.version);
        capabilities.setCapability("appium:deviceName", device.deviceName);
        capabilities.setCapability("platformName", device.platformName);
        //app info
        //com.google.android.calculator/com.android.calculator2.Calculator
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        //driver=new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),capabilities);
        driver=new AppiumDriver<MobileElement>(service.getUrl(),capabilities);
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
