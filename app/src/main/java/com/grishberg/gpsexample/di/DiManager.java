package com.grishberg.gpsexample.di;

/**
 * Created by grishberg on 08.10.17.
 */

public class DiManager {
    private static AppComponent appComponent;

    private DiManager() throws NoSuchMethodException {
        throw new NoSuchMethodException();
    }

    public static void initComponents(final AppComponent component) {
        appComponent = component;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}