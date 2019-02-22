package com.simplyillustrate.retrofitpostexample.services;

import com.simplyillustrate.retrofitpostexample.model.Question;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @POST("/addQuestion")
    @FormUrlEncoded
    Observable<Question> saveQuestion(@Field("user") String user,
                                      @Field("title") String title,
                                      @Field("difficulty") String difficulty,
                                      @Field("tags")ArrayList<String> tags,
                                      @Field("description") String description);
}
