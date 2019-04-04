package io.github.jkim3213.cowraiser;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class HomeFragment extends Fragment {

    private View view;
    private GifImageView compostGif;
    private GifImageView solarGif;
    private GifImageView gardenGif;
    private GifImageView dryingGif;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        compostGif = view.findViewById(R.id.compost);
        //TODO add other item elements
        //TODO BUG is happening where event listener is slower than make page. So profile starts at null on startup.
        //TODO I think just use the event listener to call setupgrades somehow
        //setUpgrades();
    }

    @Override
    public void onResume() {
        super.onResume();
        setUpgrades();
    }

    private void setUpgrades() {
        //TODO add other levels
        Integer compostLevel = UserProfile.curLevels.get("c");
        if(compostLevel == null || compostLevel <= 0) {
            if(compostLevel == null) {
                Log.d("HAVEN", "Compost Level: " + compostLevel);
            }
            compostGif.setImageResource(R.drawable.breakdancing_together);
        } else {
            if(compostLevel <= StoreFragment.composts.length) {
                compostGif.setImageResource(StoreFragment.composts[compostLevel - 1].imageId);
            }

        }


    }
}



