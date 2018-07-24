package com.dz.elen.mvvmproject.presentation.presentation.screeens.user.list;

import android.databinding.ObservableField;
import android.util.Log;

import com.dz.elen.domain.entity.User;
import com.dz.elen.domain.usecases.GetListUserUseCase;
import com.dz.elen.mvvmproject.presentation.app.App;
import com.dz.elen.mvvmproject.presentation.presentation.base.BaseViewModel;

import java.util.List;


import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;




public class UserListViewModel extends BaseViewModel {

//    public UserListAdapter adapter  = new UserListAdapter();

    @Inject
    public GetListUserUseCase listUserUseCase;

    public ObservableField<String> myText = new ObservableField("Super duper");

    @Override
    protected void runInject() {
        App.getAppComponent().runInject(this);
    }

    public UserListViewModel() {

        listUserUseCase
                .getUsers()
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getCompositeDisposable().add(d);
                    }

                    @Override
                    public void onNext(List<User> users) {
                        myText.set("New value " + users.size());
//                        adapter.setData(users);
                        Log.e("AAA", "user name = " + users.get(0).getFirsname());
                    }

                    @Override
                    public void onError(Throwable e) {
                        router.showError(e);
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}


