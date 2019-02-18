package com.simplyillustrate.retrofitexample.model;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionsResponse implements Parcelable {

    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("results")
    @Expose
    private List<Question> results = new ArrayList<>();
    public final static Parcelable.Creator<QuestionsResponse> CREATOR = new Creator<QuestionsResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public QuestionsResponse createFromParcel(Parcel in) {
            return new QuestionsResponse(in);
        }

        public QuestionsResponse[] newArray(int size) {
            return (new QuestionsResponse[size]);
        }

    };

    protected QuestionsResponse(Parcel in) {
        this.responseCode = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.results, (com.simplyillustrate.retrofitexample.model.Question.class.getClassLoader()));
    }

    public QuestionsResponse() {
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public List<Question> getResults() {
        return results;
    }

    public void setResults(List<Question> results) {
        this.results = results;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(responseCode);
        dest.writeList(results);
    }

    public int describeContents() {
        return 0;
    }

}
