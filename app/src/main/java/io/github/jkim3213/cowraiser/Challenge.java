package io.github.jkim3213.cowraiser;

public class Challenge {
    private String name;
    private String description;
    private int carbonlbs;
    private int ecodollars;

    public Challenge(String name, String description, int carbonlbs, int ecodollars) {
        this.name = name;
        this.description = description;
        this.carbonlbs = carbonlbs;
        this.ecodollars = ecodollars;
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
}