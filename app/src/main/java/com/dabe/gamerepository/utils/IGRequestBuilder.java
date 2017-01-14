package com.dabe.gamerepository.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daniil Belevtsev on 14.01.2017 17:38.
 * Project: GameRepository; Skype: pandamoni1
 * Parameters example:
 * ?fields=id,name,summary,cover,first_release_date,videos&limit=5&offset=0&order=release_dates.date%3Adesc&search=battlefield
 */

public class IGRequestBuilder {

    private String fieldList;
    private String gameName;
    private int limit;
    private int offset;
    private Map<String, String> requestParams;

    private IGRequestBuilder(Builder builder) {
        fieldList = builder.fieldList;
        gameName = builder.gameName;
        limit = builder.limit;
        offset = builder.offset;
        requestParams = builder.requestParams;
    }

    public Map<String, String> getRequestParams() {
        return requestParams;
    }

    public static final class Builder {
        private String fieldList;
        private String gameName;
        private int limit;
        private int offset;
        private Map<String, String> requestParams;

        public Builder() {
        }

        public Builder addField(String val) {
            if (fieldList == null) {
                fieldList = val;
            } else {
                fieldList += "," + val;
            }
            return this;
        }

        public Builder addFieldList(String val) {
            fieldList = val;
            return this;
        }

        public Builder gameName(String val) {
            gameName = val;
            return this;
        }

        public Builder limit(int val) {
            limit = val;
            return this;
        }

        public Builder offset(int val) {
            offset = val;
            return this;
        }

        public IGRequestBuilder build() {
            requestParams = new HashMap<>();
            requestParams.put("fields", fieldList);
            requestParams.put("limit", String.valueOf(limit));
            requestParams.put("offset", String.valueOf(offset));
            requestParams.put("search", gameName);
            return new IGRequestBuilder(this);
        }
    }
}
