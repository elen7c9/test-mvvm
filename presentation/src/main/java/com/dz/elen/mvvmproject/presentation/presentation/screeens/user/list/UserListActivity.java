package com.dz.elen.mvvmproject.presentation.presentation.screeens.user.list;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dz.elen.mvvmproject.databinding.ActivityUserListBinding;

import com.dz.elen.mvvmproject.R;
import com.dz.elen.mvvmproject.presentation.presentation.base.BaseMvvmActivity;

public class UserListActivity extends BaseMvvmActivity<UserListViewModel,
        ActivityUserListBinding, UserListRouter> {

    @Override
    protected UserListViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(UserListViewModel.class);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_user_list;
    }

    @Override
    protected UserListRouter provideRouter() {
        return new UserListRouter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        настройка адаптера
//        binding.recycleView.setAdapter(viewModel.adapter);
//        binding.recycleView.setLayoutManage(new LinearLayoutmanager());
    }
}
