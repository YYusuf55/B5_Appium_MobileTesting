package com.mobile.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Driver {

   private static AppiumDriver<MobileElement> driver;
   static AppiumDriverLocalService service;

   public static void runAppium(){
       service=new AppiumServiceBuilder()
               .withIPAddress("127.0.0.1")
               //.usingPort(1111)
               .usingAnyFreePort()
               .build();
       service.start();
   }

   public static void stopAppium(){
       service.stop();
   }

    public static AppiumDriver<MobileElement> getDriver(Device device,App app){
        driver=new AppiumDriver<MobileElement>(service.getUrl(),setCaps(device,app));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    private static DesiredCapabilities setCaps(Device device,App app){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //device info
        capabilities.setCapability("appium:udid", device.udid);
        capabilities.setCapability("appium:version", device.version);
        capabilities.setCapability("appium:deviceName", device.deviceName);
        capabilities.setCapability("platformName", device.platformName);
        //app info
        //com.google.android.calculator/com.android.calculator2.Calculator
        capabilities.setCapability("appPackage", app.appPackage);
        capabilities.setCapability("appActivity", app.appActivity);

        return capabilities;
    }

    public static AppiumDriver<MobileElement> getDriver() {
       return driver;
    }
}
