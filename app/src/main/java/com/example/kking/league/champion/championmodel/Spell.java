
package com.example.kking.league.champion.championmodel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Spell {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("sanitizedDescription")
    @Expose
    private String sanitizedDescription;
    @SerializedName("tooltip")
    @Expose
    private String tooltip;
    @SerializedName("sanitizedTooltip")
    @Expose
    private String sanitizedTooltip;
    @SerializedName("leveltip")
    @Expose
    private Leveltip leveltip;
    @SerializedName("image")
    @Expose
    private Image__ image;
    @SerializedName("resource")
    @Expose
    private String resource;
    @SerializedName("maxrank")
    @Expose
    private Integer maxrank;
    @SerializedName("cost")
    @Expose
    private List<Integer> cost = null;
    @SerializedName("costType")
    @Expose
    private String costType;
    @SerializedName("costBurn")
    @Expose
    private String costBurn;
    @SerializedName("cooldown")
    @Expose
    private List<Double> cooldown = null;
    @SerializedName("cooldownBurn")
    @Expose
    private String cooldownBurn;
    @SerializedName("effect")
    @Expose
    private List<Object> effect = null;
    @SerializedName("effectBurn")
    @Expose
    private List<String> effectBurn = null;
    @SerializedName("vars")
    @Expose
    private List<Var> vars = null;
    @SerializedName("range")
    @Expose
    private List<Integer> range = null;
    @SerializedName("rangeBurn")
    @Expose
    private String rangeBurn;
    @SerializedName("key")
    @Expose
    private String key;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSanitizedDescription() {
        return sanitizedDescription;
    }

    public void setSanitizedDescription(String sanitizedDescription) {
        this.sanitizedDescription = sanitizedDescription;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public String getSanitizedTooltip() {
        return sanitizedTooltip;
    }

    public void setSanitizedTooltip(String sanitizedTooltip) {
        this.sanitizedTooltip = sanitizedTooltip;
    }

    public Leveltip getLeveltip() {
        return leveltip;
    }

    public void setLeveltip(Leveltip leveltip) {
        this.leveltip = leveltip;
    }

    public Image__ getImage() {
        return image;
    }

    public void setImage(Image__ image) {
        this.image = image;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Integer getMaxrank() {
        return maxrank;
    }

    public void setMaxrank(Integer maxrank) {
        this.maxrank = maxrank;
    }

    public List<Integer> getCost() {
        return cost;
    }

    public void setCost(List<Integer> cost) {
        this.cost = cost;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getCostBurn() {
        return costBurn;
    }

    public void setCostBurn(String costBurn) {
        this.costBurn = costBurn;
    }

    public List<Double> getCooldown() {
        return cooldown;
    }

    public void setCooldown(List<Double> cooldown) {
        this.cooldown = cooldown;
    }

    public String getCooldownBurn() {
        return cooldownBurn;
    }

    public void setCooldownBurn(String cooldownBurn) {
        this.cooldownBurn = cooldownBurn;
    }

    public List<Object> getEffect() {
        return effect;
    }

    public void setEffect(List<Object> effect) {
        this.effect = effect;
    }

    public List<String> getEffectBurn() {
        return effectBurn;
    }

    public void setEffectBurn(List<String> effectBurn) {
        this.effectBurn = effectBurn;
    }

    public List<Var> getVars() {
        return vars;
    }

    public void setVars(List<Var> vars) {
        this.vars = vars;
    }

    public List<Integer> getRange() {
        return range;
    }

    public void setRange(List<Integer> range) {
        this.range = range;
    }

    public String getRangeBurn() {
        return rangeBurn;
    }

    public void setRangeBurn(String rangeBurn) {
        this.rangeBurn = rangeBurn;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
