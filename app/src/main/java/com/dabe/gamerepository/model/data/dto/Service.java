package com.dabe.gamerepository.model.data.dto;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Daniil Belevtsev on 14.01.2017 3:58.
 * Project: GameRepository; Skype: pandamoni1
 */

public class Service extends TypedContent implements Parcelable {
    public static final String TYPE = "Service";

    private String name;
    private String url;

    public Service(String name, String url) {
        super(TYPE);
        this.name = name;
        this.url = url;
    }

    protected Service(Parcel in) {
        super(TYPE);
        name = in.readString();
        url = in.readString();
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Service> CREATOR = new Parcelable.Creator<Service>() {
        @Override
        public Service createFromParcel(Parcel in) {
            return new Service(in);
        }

        @Override
        public Service[] newArray(int size) {
            return new Service[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
    }
}