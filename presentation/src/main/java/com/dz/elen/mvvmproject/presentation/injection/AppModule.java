package com.dz.elen.mvvmproject.presentation.injection;

import android.content.Context;

import com.dz.elen.data.repositories.UserRepositoryImpl;
import com.dz.elen.domain.executors.PostExecutionThread;
import com.dz.elen.domain.repositories.UserRepository;
import com.dz.elen.mvvmproject.presentation.executor.UIThread;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

    @Provides
    public static UserRepository provideUserRepository(UserRepositoryImpl userRepository) {
        return userRepository;
    }

    @Singleton
    @Provides
    public static PostExecutionThread provideUIThread(UIThread uiThread) {
        return (PostExecutionThread) uiThread;
    }
}
