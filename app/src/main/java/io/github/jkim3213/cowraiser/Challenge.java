package io.github.jkim3213.cowraiser;

public class Challenge {
    private String name;
    private String shortDescription;
    private String longDescription;
    private int carbonblbs;
    private int ecodollars;

    public Challenge(String name, String shortDescription, String longDescription, int carbonlbs, int ecodollars) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.carbonblbs = carbonlbs;
        this.ecodollars = ecodollars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public void setCarbonblbs(int carbonblbs) {
        this.carbonblbs = carbonblbs;
    }

    public void setEcodollars(int ecodollars) {
        this.ecodollars = ecodollars;
    }

    public String getName() {
        return this.name;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public String getLongDescription() {
        return this.longDescription;
    }

    public int getCarbonblbs() {
        return this.carbonblbs;
    }

    public int getEcodollars() {
        return this.ecodollars;
    }
}
