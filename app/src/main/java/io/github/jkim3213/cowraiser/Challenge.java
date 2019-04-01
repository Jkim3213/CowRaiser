package io.github.jkim3213.cowraiser;

import android.graphics.drawable.Drawable;

public class Challenge {
    private String name;
    private String description;
    private int carbonlbs;
    private int ecodollars;
    private int imageId;

    public Challenge(String name, String description, int carbonlbs, int ecodollars, int imageId) {
        this.name = name;
        this.description = description;
        this.carbonlbs = carbonlbs;
        this.ecodollars = ecodollars;
        this.imageId = imageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCarbonlbs(int carbonlbs) {
        this.carbonlbs = carbonlbs;
    }

    public void setEcodollars(int ecodollars) {
        this.ecodollars = ecodollars;
    }

    public void setImage(Drawable image) {this.imageId = imageId;}

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getCarbonlbs() {
        return this.carbonlbs;
    }

    public int getEcodollars() {
        return this.ecodollars;
    }

    public int getImage() { return imageId; }
}