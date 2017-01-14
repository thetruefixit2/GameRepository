package com.dabe.gamerepository.model.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Daniil Belevtsev on 14.01.2017 17:21.
 * Project: GameRepository; Skype: pandamoni1
 */

public class Cover {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("cloudinary_id")
    @Expose
    private String cloudinaryId;
    @SerializedName("width")
    @Expose
    private long width;
    @SerializedName("height")
    @Expose
    private long height;

    public String getUrl() {
        return url;
    }

    public String getCloudinaryId() {
        return cloudinaryId;
    }

    public long getWidth() {
        return width;
    }

    public long getHeight() {
        return height;
    }


}
