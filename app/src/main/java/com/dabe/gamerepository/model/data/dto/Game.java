package com.dabe.gamerepository.model.data.dto;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Daniil Belevtsev on 12.01.2017 0:33.
 * Project: GameRepository; Skype: pandamoni1
 */

public class Game extends TypedContent implements Parcelable {
    public static final String TYPE = "GAME";

    private String name;
    private String picUrl;
    private Service service;

    public Game(String name, String picUrl) {
        super(TYPE);
        this.name = name;
        this.picUrl = picUrl;
    }

    protected Game(Parcel in) {
        super(TYPE);
        name = in.readString();
        picUrl = in.readString();
        service = (Service) in.readValue(Service.class.getClassLoader());
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Game> CREATOR = new Parcelable.Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(picUrl);
        dest.writeValue(service);
    }
}