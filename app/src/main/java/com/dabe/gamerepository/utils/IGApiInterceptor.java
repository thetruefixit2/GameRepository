package com.dabe.gamerepository.utils;

import com.dabe.gamerepository.model.data.finals.IGConsts;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Daniil Belevtsev on 14.01.2017 20:26.
 * Project: GameRepository; Skype: pandamoni1
 */

public class IGApiInterceptor implements Interceptor {
    public IGApiInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request request = original.newBuilder()
                .header(IGConsts.KEY_HEADER_NAME, IGConsts.TEMP_KEY)
                .header("Accept", "application/json")
                .method(original.method(), original.body())
                .build();
        return chain.proceed(request);
    }

}
