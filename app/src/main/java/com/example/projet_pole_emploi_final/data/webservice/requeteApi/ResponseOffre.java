package com.example.projet_pole_emploi_final.data.webservice.requeteApi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseOffre {

    @SerializedName("resultats")
    private List<OffreEmploi> offresEmploi;

    public List<OffreEmploi> getOffresEmploi() {
        return offresEmploi;
    }

    public void setOffresEmploi(List<OffreEmploi> offresEmploi) {
        this.offresEmploi = offresEmploi;
    }
}
