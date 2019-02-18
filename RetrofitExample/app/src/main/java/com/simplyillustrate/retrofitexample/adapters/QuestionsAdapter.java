package com.simplyillustrate.retrofitexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simplyillustrate.retrofitexample.R;
import com.simplyillustrate.retrofitexample.model.Question;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder> {

    private Context mContext;
    private ArrayList<Question> questionsList;

    public QuestionsAdapter(Context context, ArrayList<Question> questionsList) {
        this.mContext = context;
        this.questionsList = questionsList;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item, parent, false);

        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {

        holder.title.setText(questionsList.get(position).getDifficulty());
    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }


    public class QuestionViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
        }
    }
}
