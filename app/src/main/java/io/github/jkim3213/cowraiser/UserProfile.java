package io.github.jkim3213.cowraiser;


import java.util.ArrayList;
import java.util.HashMap;

public class UserProfile {
    static String UID = "";
    static int ecoDollars = 0;
    static int carbonLbs = 0;
    static HashMap<String, Integer> inventory = new HashMap<>();
    static ArrayList<JournalEntry> journalEntryList = new ArrayList<>();
    static String email = "";


    public int ecoD;
    public int carbonL;
    public HashMap<String, Integer> inv;
    public ArrayList<JournalEntry> entryList;
    public String userEmail;

    public UserProfile() {
        ecoD = ecoDollars;
        carbonL = carbonLbs;
        inv = inventory;
        entryList = journalEntryList;
        userEmail = email;
    }

    public static ArrayList<JournalEntry> getJournalEntryList() {
        return journalEntryList;
    }

    void setUser() {
        ecoDollars = ecoD;
        carbonLbs = carbonL;
        inventory = inv;
        journalEntryList = entryList;
        email = userEmail;
    }

    static void resetUser() {
        UID = "";
        ecoDollars = 0;
        carbonLbs = 0;
        inventory = new HashMap<>();
        journalEntryList = new ArrayList<>();
        email = "";
    }

    void removeJournalEntry(int i) {
        journalEntryList.remove(i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        sb.append("email: ");
        sb.append(email);
        sb.append('\n');
        sb.append("eco: ");
        sb.append(ecoDollars);
        sb.append('\n');
        sb.append("carbon: ");
        sb.append(carbonLbs);
        sb.append('\n');
        sb.append("inv: ");
        sb.append(inventory.toString());
        sb.append('\n');

        return sb.toString();
    }
}
