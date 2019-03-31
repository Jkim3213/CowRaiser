package io.github.jkim3213.cowraiser;

import android.os.Bundle;

public class LightChallenge extends ChallengeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        challengeTitle.setText(R.string.light_title);
        challengeDesc.setText(R.string.light_desc);
        carbonLbs = 6;
        baseEcoDollars = 12;
    }
}
