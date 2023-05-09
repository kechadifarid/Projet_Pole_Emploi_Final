package com.example.projet_pole_emploi_final.data.webservice.generateToken;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Access_token {
    @POST("access_token")
    Call<AccessToken> getAccessToken(@Query("realm") String realm
                                    , @Body RequestBody body);
}

