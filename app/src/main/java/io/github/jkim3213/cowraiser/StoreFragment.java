package io.github.jkim3213.cowraiser;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import java.util.Set;

public class StoreFragment extends Fragment {

    private static final StoreItem[] composts = {new StoreItem("Compost Bin", R.drawable.small_compost, 20, 1, "c"),
            new StoreItem("Big Compost Bin", R.drawable.big_compost, 200, 2, "c"),
            new StoreItem("XXL Compost Bin", R.drawable.assets_cow_raiser0004, 2000, 3, "c")};
    static final StoreItem[][] storeItems = {composts};

    static List<StoreItem> items = new ArrayList<>();
    static RecyclerView rv;
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        rv.setLayoutManager(linearLayoutManager);
        refreshStore();
    }

    public static void refreshStore() {
        items.clear();
        for(StoreItem[] i : storeItems) {
            String type = i[0].type;
            Integer level = UserProfile.curLevels.get(type);
            Log.i("STORE", "level " + level + " Type " + type);
            if(level == null || level == 0) {
                items.add(i[0]);
                continue;
            }
            if(level >= i.length) {
                continue;
            }
            items.add(i[level]);

        }
        StoreAdapter storeAdapter = new StoreAdapter(items);
        rv.setAdapter(storeAdapter);
    }

}
