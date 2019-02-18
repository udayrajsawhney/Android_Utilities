package com.simplyillustrate.retrofitexample.model;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question implements Parcelable {

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("difficulty")
    @Expose
    private String difficulty;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("correct_answer")
    @Expose
    private String correctAnswer;
    @SerializedName("incorrect_answers")
    @Expose
    private List<String> incorrectAnswers = new ArrayList<>();
    public final static Parcelable.Creator<Question> CREATOR = new Creator<Question>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        public Question[] newArray(int size) {
            return (new Question[size]);
        }

    };

    protected Question(Parcel in) {
        this.category = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.difficulty = ((String) in.readValue((String.class.getClassLoader())));
        this.question = ((String) in.readValue((String.class.getClassLoader())));
        this.correctAnswer = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.incorrectAnswers, (java.lang.String.class.getClassLoader()));
    }

    public Question() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(List<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(category);
        dest.writeValue(type);
        dest.writeValue(difficulty);
        dest.writeValue(question);
        dest.writeValue(correctAnswer);
        dest.writeList(incorrectAnswers);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {

        return question;
    }
}