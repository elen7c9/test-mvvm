package com.dz.elen.domain.usecases;

import com.dz.elen.domain.entity.User;
import com.dz.elen.domain.executors.PostExecutionThread;
import com.dz.elen.domain.repositories.UserRepository;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetListUserUseCase extends BaseUseCase {

    private UserRepository userRepository;

    @Inject
    public GetListUserUseCase(UserRepository userRepository,
                              PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Observable<List<User>> getUsers() {
        return userRepository
                .getAll()
                .subscribeOn(executionThread)
                .observeOn(postExecutionThread);
    }
}
