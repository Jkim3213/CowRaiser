package io.github.jkim3213.cowraiser;

public class Challenge {
    private String name;
    private String description;
    private int carbonblbs;
    private int ecodollars;

    public Challenge(String name, String description, int carbonlbs, int ecodollars) {
        this.name = name;
        this.description = description;
        this.carbonblbs = carbonlbs;
        this.ecodollars = ecodollars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getDescription() {
        return this.description;
    }

    public int getCarbonblbs() {
        return this.carbonblbs;
    }

    public int getEcodollars() {
        return this.ecodollars;
    }
}