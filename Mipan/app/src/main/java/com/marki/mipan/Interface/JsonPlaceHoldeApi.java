package com.marki.mipan.Interface;




import com.marki.mipan.ModelRest.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface JsonPlaceHoldeApi {

    @Headers({"Accept:application/json","user-key:e60f408eef4803dcd1cc7e8a7f725b9f"}) //Access to api with user-key

            @GET("search")
    Call <Model> getPosts(
            @Query("count") int count,
            @Query("lat") double lat,
            @Query("lon") double lon,
            @Query("radius") double radius,
            @Query("sort") String   sort,
            @Query("order") String order


    );
}
