package com.mobile.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class utils {

    public static AppiumDriver<MobileElement> openApp(Device device,App app){
        Driver.runAppium();
        return Driver.getDriver(device,app);
    }

   public static void click(By locator){
        Driver.getDriver().findElement(locator).click();
    }
   public static String getText(By locator){
        return Driver.getDriver().findElement(locator).getText();
    }
    public static MobileElement getDigit(int digit){
        return Driver.getDriver().findElement(By.id("com.google.android.calculator:id/digit_"+digit));
    }
}
