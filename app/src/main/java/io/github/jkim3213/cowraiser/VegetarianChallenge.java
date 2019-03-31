package io.github.jkim3213.cowraiser;

import android.os.Bundle;

public class VegetarianChallenge extends ChallengeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        challengeTitle.setText(R.string.vegetarian_title);
        challengeDesc.setText(R.string.vegetarian_desc);
        carbonLbs = 6;
        baseEcoDollars = 12;
    }
}
