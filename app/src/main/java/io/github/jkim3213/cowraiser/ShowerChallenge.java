package io.github.jkim3213.cowraiser;

import android.os.Bundle;

public class ShowerChallenge extends ChallengeActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        challengeTitle.setText(R.string.shower_title);
        challengeDesc.setText(R.string.shower_desc);
        carbonLbs = 6;
        baseEcoDollars = 12;
    }
}
