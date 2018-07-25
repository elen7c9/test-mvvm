package com.dz.elen.domain.usecases;

import com.dz.elen.domain.entity.Search;
import com.dz.elen.domain.entity.User;
import com.dz.elen.domain.executors.PostExecutionThread;
import com.dz.elen.domain.repositories.UserRepository;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class SearchUserUseCase extends BaseUseCase {

    private UserRepository userRepository;

    @Inject
    public SearchUserUseCase(UserRepository userRepository,
                             PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Observable<List<User>> search(Search search) {
        return userRepository
                .search(search)
                .subscribeOn(executionThread)
                .observeOn(postExecutionThread);
    }
}
