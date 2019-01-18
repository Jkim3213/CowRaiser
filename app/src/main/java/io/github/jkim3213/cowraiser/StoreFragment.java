package io.github.jkim3213.cowraiser;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreFragment extends Fragment {

    static final String[] itemNamesArr = {"Maple Tree", "Apple Tree", "Pine Tree"};
    static final int[] itemImagesId = {R.drawable.co2, R.drawable.co2, R.drawable.co2};
    static final int[] itemCost = {5, 3, 7};
    RecyclerView rv;
    TextView ecodollars;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_store, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = view.findViewById(R.id.storeItems);
        ecodollars = view.findViewById(R.id.ecoDollars);
        ecodollars.setText(getString(R.string.num_ecodollars, UserProfile.ecoDollars));
        //populate
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        rv.setLayoutManager(linearLayoutManager);
        //get images and names from database...


        List<StoreItem> items = new ArrayList<>();
        for(int i = 0; i < itemImagesId.length; i++) {
            items.add(new StoreItem(itemNamesArr[i], itemImagesId[i], itemCost[i]));
        }

        StoreAdapter storeAdapter = new StoreAdapter(items);
        rv.setAdapter(storeAdapter);
    }
}
