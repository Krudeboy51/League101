
package com.example.kking.league.champion.championmodel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Var {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("coeff")
    @Expose
    private List<Double> coeff = null;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Double> getCoeff() {
        return coeff;
    }

    public void setCoeff(List<Double> coeff) {
        this.coeff = coeff;
    }

}
