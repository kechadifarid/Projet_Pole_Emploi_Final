package com.example.projet_pole_emploi_final;

import com.example.projet_pole_emploi_final.data.webservice.generateToken.*;
import com.example.projet_pole_emploi_final.data.webservice.requeteApi.*;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;


import android.os.Bundle;


import okhttp3.FormBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupérer la vue SearchView
        SearchView searchView = findViewById(R.id.search_view);

// Configurer l'icône personnalisée
        int n =1;
        searchView.setIconifiedByDefault(false);
        searchView.setIconified(false);
        searchView.setQueryHint("Recherche");
        //searchView.setSearchIcon(R.drawable.ic_search);

// Configurer les écouteurs de changement de texte et de soumission de la recherche
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Code pour traiter la recherche soumise
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Code pour traiter le changement de texte dans la barre de recherche
                return false;
            }
        });

        //  RepositoryToken repositoryToken = new RepositoryToken();
        //repositoryToken.genererToken();
        RepositoryApi repositoryApi = new RepositoryApi();
        repositoryApi.RequeterApi();


    }
}