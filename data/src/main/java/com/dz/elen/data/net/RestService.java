package com.dz.elen.data.net;

import com.dz.elen.data.entity.DeleteResponse;
import com.dz.elen.data.entity.HttpError;
import com.dz.elen.data.entity.UserRequest;
import com.dz.elen.data.entity.UserResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class RestService {

    private RestApi restApi;
    private Gson gson;
    private ErrorParserTransformer errorParserTransformer;

    @Inject
    public RestService() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttp = new OkHttpClient
                .Builder()
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        gson = new GsonBuilder()
                .create();

        this.restApi = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.backendless.com/70E26EEB-3ACD-601D-FF12-541F239F8800/FDBEBFDC-2C3B-E045-FF00-D718E4134700/")
                .client(okHttp)
                .build()
                .create(RestApi.class);

        errorParserTransformer = new ErrorParserTransformer(gson);
    }

    public Observable<List<UserResponse>> getAllUsers() {
        return restApi
                .getAllUsers()
                .compose(errorParserTransformer.<List<UserResponse>, HttpError>parseHttpError());
    }

    public Observable<UserResponse> getUser(String id) {
        return restApi
                .getUser(id)
                .compose(errorParserTransformer.<UserResponse, HttpError>parseHttpError());
    }

    public Observable<UserResponse> updateUser(UserRequest user){
        return restApi
                .updateUser(user)
                .compose(errorParserTransformer.<UserResponse, HttpError>parseHttpError());
    }

    public Observable<DeleteResponse> deleteUser(String id){
        return restApi
                .deleteUser(id)
                .compose(errorParserTransformer.<DeleteResponse, HttpError>parseHttpError());
    }

    public Observable<List<UserResponse>> search(String name,
                                                 String surname,
                                                 String sortDir,
                                                 String selectedSortBy) {
        return restApi
                .searchUsers(name, surname, sortDir, selectedSortBy)
                .compose(errorParserTransformer.<List<UserResponse>, HttpError>parseHttpError());
    }
}
