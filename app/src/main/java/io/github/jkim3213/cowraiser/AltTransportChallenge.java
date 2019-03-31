package io.github.jkim3213.cowraiser;

import android.os.Bundle;

public class AltTransportChallenge extends ChallengeActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        challengeTitle.setText(R.string.altertransport_title);
        challengeDesc.setText(R.string.altertransport_desc);
        carbonLbs = 6;
        baseEcoDollars = 12;
    }
}
