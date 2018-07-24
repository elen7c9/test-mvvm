package com.dz.elen.mvvmproject.presentation.injection;

import com.dz.elen.mvvmproject.presentation.presentation.screeens.user.list.UserListViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    void runInject(UserListViewModel listViewModel);
}