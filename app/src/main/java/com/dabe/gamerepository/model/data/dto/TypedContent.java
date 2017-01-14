package com.dabe.gamerepository.model.data.dto;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Daniil Belevtsev on 14.01.2017 3:55.
 * Project: GameRepository; Skype: pandamoni1
 */

public class TypedContent implements Parcelable {

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<TypedContent> CREATOR = new Parcelable.Creator<TypedContent>() {
        @Override
        public TypedContent createFromParcel(Parcel in) {
            return new TypedContent(in);
        }

        @Override
        public TypedContent[] newArray(int size) {
            return new TypedContent[size];
        }
    };
    private String type;

    public TypedContent(String type) {
        this.type = type;
    }

    protected TypedContent(Parcel in) {
        type = in.readString();
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object someObject) {
        if (this == someObject) return true;
        if (someObject == null || getClass() != someObject.getClass()) return false;

        TypedContent that = (TypedContent) someObject;

        return type.equals(that.type);

    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
    }
}