package com.dz.elen.data.repositories;

import com.dz.elen.data.entity.UserResponse;
import com.dz.elen.data.net.RestService;
import com.dz.elen.domain.entity.Gender;
import com.dz.elen.domain.entity.User;
import com.dz.elen.domain.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class UserRepositoryImpl implements UserRepository {

    private RestService restService;

    @Inject
    public UserRepositoryImpl(RestService restService) {
        this.restService = restService;
    }

    @Override
    public Observable<List<User>> getAll() {
        return restService
                .getAllUsers()
                .map(new Function<List<UserResponse>, List<User>>() {
                    @Override
                    public List<User> apply(List<UserResponse> userResponses) throws Exception {

                                               final List<User> list = new ArrayList<>();
                        for(UserResponse user: userResponses) {
                            list.add(new User(user.getFirstname(),
                                    user.getSurname(), Gender.M,
                                    user.getImageUrl()));
                        }

                        return list;
                    }
                });
    }

    @Override
    public Completable update(User user) {
        return Completable.never();
    }

    @Override
    public Completable delete(String id) {
        return Completable.never();
    }

    @Override
    public Completable add(User user) {
        return Completable.never();
    }
}
