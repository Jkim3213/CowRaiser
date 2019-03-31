package io.github.jkim3213.cowraiser;

import android.os.Bundle;

public class PublTransportChallenge extends ChallengeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        challengeTitle.setText(R.string.publtransport_title);
        challengeDesc.setText(R.string.publtransport_desc);
        carbonLbs = 6;
        baseEcoDollars = 12;
    }
}
