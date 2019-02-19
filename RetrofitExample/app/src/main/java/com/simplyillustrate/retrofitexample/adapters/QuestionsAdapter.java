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


    private ArrayList<Question> questionsList;
    final private ListItemClickListener mOnClickListener;

    public QuestionsAdapter(ArrayList<Question> questionsList, ListItemClickListener listener) {
        mOnClickListener = listener;
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

        holder.title.setText(questionsList.get(position).getQuestion());
        holder.difficulty.setText(questionsList.get(position).getDifficulty());
        holder.category.setText(questionsList.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }


    public class QuestionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        TextView difficulty;
        TextView category;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            difficulty = itemView.findViewById(R.id.tv_diff);
            category = itemView.findViewById(R.id.tv_tag);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
