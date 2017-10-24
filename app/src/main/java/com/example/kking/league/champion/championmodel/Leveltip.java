
package com.example.kking.league.champion.championmodel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Leveltip {

    @SerializedName("label")
    @Expose
    private List<String> label = null;
    @SerializedName("effect")
    @Expose
    private List<String> effect = null;

    public List<String> getLabel() {
        return label;
    }

    public void setLabel(List<String> label) {
        this.label = label;
    }

    public List<String> getEffect() {
        return effect;
    }

    public void setEffect(List<String> effect) {
        this.effect = effect;
    }

}
