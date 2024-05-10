package com.mobile.tests.day02;

import com.mobile.utilities.App;
import com.mobile.utilities.Device;
import com.mobile.utilities.Driver;
import com.mobile.utilities.Locator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.mobile.utilities.utils.*;

public class TC5_OpenApp implements Locator {

    AppiumDriver <MobileElement>driver;
    @Before
    public void setUp(){
        driver=openApp(Device.PIXEL2, App.CALCULATOR);
    }

    @After
    public void tearDown() {
        driver.closeApp();
        Driver.stopAppium();
    }

    @Test
    public void t6_click_divide() {
        click(l_digit5);
        click(l_digit8);
        click(l_divide);
        click(l_digit2);
        click(l_equalsBtn);
        Assert.assertEquals("29",getText(l_result));
    }
    @Test
    public void t7_click_sum() {
        getDigit(5).click();
        click(l_plusBtn);
        getDigit(9).click();
        click(l_equalsBtn);
        Assert.assertEquals("14",getText(l_result));
    }

}
