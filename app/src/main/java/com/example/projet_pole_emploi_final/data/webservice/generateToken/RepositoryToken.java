package com.example.projet_pole_emploi_final.data.webservice.generateToken;

import java.io.SyncFailedException;

import okhttp3.FormBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepositoryToken {
    String baseUrl = "https://entreprise.pole-emploi.fr/connexion/oauth2/";
    String grantType = "client_credentials";
    String clientId = "PAR_poleemploiprojet_0eba6c6d4bc2b153ff825ffb16d8ee09ef8f5be4161e60a882ccaf02bf9a68f4";
    String clientSecret = "7ae2c301f50919f823486c85b8f79b09142a994a22ee9f5094a3c154eaad7172";
    String scope = "api_offresdemploiv2 o2dsoffre";
 public static String token;

    public String genererToken(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Access_token api = retrofit.create(Access_token.class);




        RequestBody body = new FormBody.Builder()
                .add("grant_type", grantType)
                .add("client_id",clientId).add("client_secret",clientSecret).add("scope",scope).build()
                ;

        Call<AccessToken> call = api.getAccessToken("/partenaire", body);
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if (response.isSuccessful()) {
                    AccessToken accessToken = (AccessToken) response.body();
                   token = accessToken.getAccessToken();
                    System.out.println("token est " +token);
                } else {
                    // Traitement de l'erreur
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                // Traitement de l'erreur
            }
        });
        System.out.println("abouch");
        return token;
    }
}
