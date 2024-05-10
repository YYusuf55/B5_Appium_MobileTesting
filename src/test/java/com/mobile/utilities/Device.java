package com.mobile.utilities;

public enum Device {
    PIXEL2("emulator-5554", "11", "Pixel_2", "Android"),
    PIXEL3("udid No", "13", "My_Phone", "Android");

    public String udid;
    public String version;
    public String deviceName;
    public String platformName;

    Device(String udid, String version, String deviceName, String platformName) {
        this.udid=udid;
        this.version=version;
        this.deviceName=deviceName;
        this.platformName=platformName;
    }
}
