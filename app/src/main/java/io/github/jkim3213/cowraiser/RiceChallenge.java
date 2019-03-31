package io.github.jkim3213.cowraiser;

import android.os.Bundle;

public class RiceChallenge extends ChallengeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        challengeTitle.setText(R.string.rice_title);
        challengeDesc.setText(R.string.rice_desc);
        carbonLbs = 6;
        baseEcoDollars = 99;
    }
}
