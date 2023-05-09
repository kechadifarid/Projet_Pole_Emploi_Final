package com.example.projet_pole_emploi_final.data.webservice.requeteApi;

import android.util.Log;
import com.example.projet_pole_emploi_final.data.webservice.generateToken.*;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.projet_pole_emploi_final.data.webservice.generateToken.AccessToken;
import com.example.projet_pole_emploi_final.data.webservice.generateToken.Access_token;
import com.example.projet_pole_emploi_final.data.webservice.generateToken.RepositoryToken;

import java.util.List;

public class RepositoryApi {
    String baseUrl = "https://api.pole-emploi.io/partenaire/offresdemploi/v2/offres/";
    String token ;
    String baseUrltkn = "https://entreprise.pole-emploi.fr/connexion/oauth2/";
    String grantType = "client_credentials";
    String clientId = "PAR_poleemploiprojet_0eba6c6d4bc2b153ff825ffb16d8ee09ef8f5be4161e60a882ccaf02bf9a68f4";
    String clientSecret = "7ae2c301f50919f823486c85b8f79b09142a994a22ee9f5094a3c154eaad7172";
    String scope = "api_offresdemploiv2 o2dsoffre";

    public void RequeterApi(){



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrltkn)
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

                    if(token != null){
                        OkHttpClient client = new OkHttpClient.Builder()
                                .addInterceptor(chain -> {
                                    Request request = chain.request();
                                    Request.Builder builder =request.newBuilder().header("Authorization", "Bearer "+ token);
                                    Request newRequest = builder.build();
                                    return chain.proceed(newRequest);
                                })
                                .build();


                        Retrofit retrofit2 = new Retrofit.Builder()
                                .baseUrl(baseUrl)
                                .addConverterFactory(GsonConverterFactory.create())
                                .client(client)
                                .build();
                        Pole_Emploi_rqt poleEmploiApi = retrofit2.create(Pole_Emploi_rqt.class);

                        String motsCles = "java";
                        Call<ResponseOffre> call2 = poleEmploiApi.searchOffres(motsCles);
                        call2.enqueue(new Callback<ResponseOffre>() {
                            @Override
                            public void onResponse(Call<ResponseOffre> call, Response<ResponseOffre> response) {
                                if (response.isSuccessful()) {
                                    ResponseOffre resultat = response.body();
                                    List<OffreEmploi> offresEmploi = resultat.getOffresEmploi();
                                    System.out.println("a rebbi gla3nayak"+token);
                                    System.out.println("On a reussi a récupérer les offres d'emploi !");
                                } else {
                                    System.out.println(" ihi atan da "+token);
                                    System.out.println("izaaan");
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseOffre> call, Throwable t) {
                                // Gérer les erreurs
                            }
                        });

                    }
                } else {
                    // Traitement de l'erreur
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                // Traitement de l'erreur
            }
        });









        //--------------------------------------------------------------------








    }
}
