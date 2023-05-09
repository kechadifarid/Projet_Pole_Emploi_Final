package com.example.projet_pole_emploi_final.data.webservice.requeteApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface Pole_Emploi_rqt {

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @GET("search?")
    Call<ResponseOffre> searchOffres(
            @Query("motsCles") String motsCles


    );
}




