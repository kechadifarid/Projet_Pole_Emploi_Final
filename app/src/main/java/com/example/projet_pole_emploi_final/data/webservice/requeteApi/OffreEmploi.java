package com.example.projet_pole_emploi_final.data.webservice.requeteApi;

import com.google.gson.annotations.SerializedName;

public class OffreEmploi {
    @SerializedName("intitule")
    private String intitule;

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
}
