package com.simplyillustrate.retrofitexample.service;

import com.simplyillustrate.retrofitexample.model.Question;
import com.simplyillustrate.retrofitexample.model.QuestionsResponse;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface QuestionsDataService {

    // https://opentdb.com/api.php?amount=10&category=18&difficulty=medium&type=multiple
    @GET("/api.php")
    Call<QuestionsResponse> getQuestions(@QueryMap Map<String, String> queryValues);


}
