package io.github.jkim3213.cowraiser;

public class JournalEntry {

    private String challengeName;
    private String time;
    private String entryText;
    private int dollarGained;
    private int pointGained;

    public JournalEntry(String challengeName, String time, String entryText, int dollarGained, int pointGained) {
        this.challengeName = challengeName;
        this.time = time;
        this.entryText = entryText;
        this.dollarGained = dollarGained;
        this.pointGained = pointGained;
    }

    public JournalEntry() {
        this.challengeName = "";
        this.time = "";
        this.entryText = "";
        this.dollarGained = 0;
        this.pointGained = 0;
    }

    public void setChallengeName(String challengeTitle) {
        this.challengeName = challengeTitle;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setEntryText(String entryText) {
        this.entryText = entryText;
    }

    public void setDollarGained(int dollarGained) {
        this.dollarGained = dollarGained;
    }

    public void setPointGained(int pointGained) {
        this.pointGained = pointGained;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public String getTime() {
        return time;
    }

    public String getEntryText() {
        return entryText;
    }

    public int getDollarGained() {
        return dollarGained;
    }

    public int getPointGained() {
        return pointGained;
    }
}
