package com.simplyillustrate.retrofitpostexample.model;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;

public class Question implements Parcelable {

    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("difficulty")
    @Expose
    private String difficulty;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @NonNull
    @Override
    public String toString() {
        return new StringBuilder().append("tags = " + tags + "\n").
                append(id).append("user = " + user + "\n")
                .append("title = " + title + "\n")
                .append("difficulty = " + difficulty + "\n")
                .append("createdAt = " + createdAt + "\n")
                .append("v = " + v + "\n").toString();
    }

    @SerializedName("__v")
    @Expose
    private Integer v;
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
        in.readList(this.tags, (java.lang.String.class.getClassLoader()));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.user = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.difficulty = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.v = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Question() {
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(tags);
        dest.writeValue(id);
        dest.writeValue(user);
        dest.writeValue(title);
        dest.writeValue(difficulty);
        dest.writeValue(createdAt);
        dest.writeValue(v);
    }

    public int describeContents() {
        return 0;
    }

}