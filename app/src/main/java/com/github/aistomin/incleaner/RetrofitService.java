package com.github.aistomin.incleaner;

import com.github.aistomin.incleaner.api.InstagramResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by aistomin on 06.03.18.
 */
public interface RetrofitService {

    @GET("v1/tags/{tag_name}/media/recent")
    Call<InstagramResponse> getTagPhotos(@Path("tag_name") String tag_name,
                                         @Query("access_token") String access_token);
}