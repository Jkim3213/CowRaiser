package io.github.jkim3213.cowraiser;

import java.util.HashMap;

public class UserProfile {
    static String UID = "";
    static int ecoDollars = 0;
    static int carbonLbs = 0;
    static HashMap<String, Integer> inventory = new HashMap<>();
    static String email = "";

    public int ecoD;
    public int carbonL;
    public HashMap<String, Integer> inv;
    public String userEmail;

    public UserProfile() {
        ecoD = ecoDollars;
        carbonL = carbonLbs;
        inv = inventory;
        userEmail = email;
    }

    void setUser() {
        ecoDollars = ecoD;
        carbonLbs = carbonL;
        inventory = inv;
        email = userEmail;
    }

    static void resetUser() {
        UID = "";
        ecoDollars = 0;
        carbonLbs = 0;
        inventory = new HashMap<>();
        email = "";
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
