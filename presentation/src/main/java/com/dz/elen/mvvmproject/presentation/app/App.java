package com.dz.elen.mvvmproject.presentation.app;

import android.app.Application;

import com.dz.elen.mvvmproject.presentation.injection.AppComponent;
import com.dz.elen.mvvmproject.presentation.injection.AppModule;
import com.dz.elen.mvvmproject.presentation.injection.DaggerAppComponent;


public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                //FIXME Поменять на другой вариант, что бы был не устаревший
                .appModule(new AppModule(this))
                .build();

    }
}
