
package com.example.kking.league.champion.championmodel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Champion {

    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("lore")
    @Expose
    private String lore;
    @SerializedName("partype")
    @Expose
    private String partype;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("blurb")
    @Expose
    private String blurb;
    @SerializedName("allytips")
    @Expose
    private List<String> allytips = null;
    @SerializedName("passive")
    @Expose
    private Passive passive;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("recommended")
    @Expose
    private List<Recommended> recommended = null;
    @SerializedName("skins")
    @Expose
    private List<Skin> skins = null;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("enemytips")
    @Expose
    private List<String> enemytips = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("spells")
    @Expose
    private List<Spell> spells = null;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("info")
    @Expose
    private Info info;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public String getPartype() {
        return partype;
    }

    public void setPartype(String partype) {
        this.partype = partype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public List<String> getAllytips() {
        return allytips;
    }

    public void setAllytips(List<String> allytips) {
        this.allytips = allytips;
    }

    public Passive getPassive() {
        return passive;
    }

    public void setPassive(Passive passive) {
        this.passive = passive;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Recommended> getRecommended() {
        return recommended;
    }

    public void setRecommended(List<Recommended> recommended) {
        this.recommended = recommended;
    }

    public List<Skin> getSkins() {
        return skins;
    }

    public void setSkins(List<Skin> skins) {
        this.skins = skins;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<String> getEnemytips() {
        return enemytips;
    }

    public void setEnemytips(List<String> enemytips) {
        this.enemytips = enemytips;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}
