package com.simplyillustrate.retrofitpostexample;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.simplyillustrate.retrofitpostexample.model.Question;
import com.simplyillustrate.retrofitpostexample.services.APIService;
import com.simplyillustrate.retrofitpostexample.services.APIUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_title)
    TextInputEditText title;
    @BindView(R.id.tv_difficulty)
    TextInputEditText difficulty;
    @BindView(R.id.tv_tags)
    TextInputEditText tags;
    @BindView(R.id.tv_description)
    TextInputEditText description;
    @BindView(R.id.btn_submit)
    MaterialButton sbtButton;
    @BindView(R.id.tv_response)
    TextInputEditText response;

    private APIService mAPIService;
    HashMap<String, String> mapTags = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mAPIService = APIUtils.getAPIService();
        mapTags.put("Computer Science", "5c6e63642875e201dc4d7dae");
        mapTags.put("Mathematics", "5c6e63f505c62401dc334110");
        sbtButton.setOnClickListener(v -> {
            String Title = title.getText().toString().trim();
            String Difficulty = difficulty.getText().toString().trim();
            String Tags = tags.getText().toString().trim();
            String Description = description.getText().toString().trim();
            sendPost(Title, Difficulty, Tags, Description);
        });
    }

    public void sendPost(String title, String difficulty, String tags, String description) {
        String user = "5c6a86d92984710fd5e8403a";
        ArrayList<String> tagKeys = new ArrayList<>();
        tagKeys.add(mapTags.get(tags));

        mAPIService.saveQuestion(user, title, difficulty, tagKeys, description)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Question -> {
                    showResponse(Question);
                });
    }

    public void showResponse(Question question) {
        response.setText(question.toString());
    }


}

