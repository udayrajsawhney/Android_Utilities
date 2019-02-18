package com.simplyillustrate.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.simplyillustrate.retrofitexample.adapters.QuestionsAdapter;
import com.simplyillustrate.retrofitexample.model.Question;
import com.simplyillustrate.retrofitexample.model.QuestionsResponse;
import com.simplyillustrate.retrofitexample.service.QuestionsDataService;
import com.simplyillustrate.retrofitexample.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Question> questions;
    private RecyclerView questionsList;
    private QuestionsAdapter questionsAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initViews();
        listView = findViewById(R.id.lv_questions);
        questions = new ArrayList<>();
        getQuestions();
    }

//    public void initViews() {
//        questionsList = findViewById(R.id.rv_questions);
//        questionsList.setItemAnimator(new DefaultItemAnimator());
//        questionsList.setAdapter(questionsAdapter);
//        questionsList.setLayoutManager(new LinearLayoutManager(this));
//    }

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
                    String[] questionTitles = new String[questions.size()];
                    for (int i=0;i<questionTitles.length;i++){
                        questionTitles[i] = questions.get(i).getQuestion();
                    }
                    listView.setAdapter(new ArrayAdapter<String>(
                            getApplicationContext(),
                            android.R.layout.simple_list_item_1,
                            questionTitles
                    ));
                    //Log.i(MainActivity.class.toString(), questions.toString());
                   // questionsList.setAdapter(new QuestionsAdapter(getApplicationContext(), questions));
                    //displayQuestions();
                }

            }

            @Override
            public void onFailure(Call<QuestionsResponse> call, Throwable t) {

            }
        });

    }

    private void displayQuestions() {
        questions.forEach(i->System.out.println(i.getQuestion()));
    }

}
