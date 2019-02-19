package com.simplyillustrate.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.simplyillustrate.retrofitexample.adapters.QuestionDetails;
import com.simplyillustrate.retrofitexample.adapters.QuestionsAdapter;
import com.simplyillustrate.retrofitexample.model.Question;
import com.simplyillustrate.retrofitexample.model.QuestionsResponse;
import com.simplyillustrate.retrofitexample.service.QuestionsDataService;
import com.simplyillustrate.retrofitexample.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements QuestionsAdapter.ListItemClickListener {

    private ArrayList<Question> questions;
    private RecyclerView questionsList;
    private QuestionsAdapter questionsAdapter;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        questions = new ArrayList<>();
        getQuestions();
    }

    public void initViews() {
        questionsList = findViewById(R.id.rv_questions);
        questionsList.setItemAnimator(new DefaultItemAnimator());
        questionsList.setAdapter(questionsAdapter);
        questionsList.setLayoutManager(new LinearLayoutManager(this));
    }

    void getQuestions() {
        // https://opentdb.com/api.php?amount=10&category=18&difficulty=medium&type=multiple
        HashMap<String, String> queryData = new HashMap<>();
        queryData.put("amount", "10");
        queryData.put("category", "18");
        queryData.put("difficulty", "medium");
        queryData.put("type", "multiple");

        QuestionsDataService questionsDataService = RetrofitInstance.getQuestionService();
        Call<QuestionsResponse> call = questionsDataService.getQuestions(queryData);
        call.enqueue(new Callback<QuestionsResponse>() {
            @Override
            public void onResponse(Call<QuestionsResponse> call, Response<QuestionsResponse> response) {
                QuestionsResponse questionsResponse = response.body();
                if (questionsResponse != null && questionsResponse.getResults() != null) {
                    questions = (ArrayList<Question>) questionsResponse.getResults();
                    Log.i(MainActivity.class.toString(), questions.toString());
                    questionsList.setAdapter(new QuestionsAdapter(questions, MainActivity.this));
                }

            }

            @Override
            public void onFailure(Call<QuestionsResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Intent intent = new Intent(this, QuestionDetails.class);
        intent.putExtra("question",questions.get(clickedItemIndex));
        startActivity(intent);
    }
}
