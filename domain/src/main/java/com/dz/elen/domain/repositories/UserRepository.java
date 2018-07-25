package com.dz.elen.domain.repositories;

import com.dz.elen.domain.entity.Search;
import com.dz.elen.domain.entity.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface UserRepository {

    Observable<List<User>> getAll();

    Completable update(User user);

    Completable delete(String id);

    Completable add(User user);

    Observable<List<User>> search(Search search);

}
