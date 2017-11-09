package com.grishberg.gpsexample.di;

import com.grishberg.gpsexample.di.modules.AppModule;
import com.grishberg.gpsexample.di.modules.LocationModule;
import com.grishberg.gpsexample.di.modules.RepositoryModule;
import com.grishberg.gpsexample.di.modules.RestModule;
import com.grishberg.gpsexample.presentation.presenter.MapPresenter;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by grishberg on 08.10.17.
 */
@Singleton
@Component(modules = {
        RestModule.class,
        AppModule.class,
        RepositoryModule.class,
        LocationModule.class
})
public interface AppComponent {
    void inject(@NotNull MapPresenter mapPresenter);
}