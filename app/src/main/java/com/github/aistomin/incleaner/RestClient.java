package com.github.aistomin.incleaner;

import com.github.aistomin.incleaner.api.Constants;
import retrofit2.Retrofit;

/**
 * Created by aistomin on 06.03.18.
 */
public class RestClient {

    public static RetrofitService getRetrofitService() {
        return new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService.class);
    }
}
