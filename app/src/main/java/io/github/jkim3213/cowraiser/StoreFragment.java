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

    static final StoreItem[] composts = {new StoreItem("Compost Bin", R.drawable.compost1, 20, 1, "c"),
            new StoreItem("Big Compost Bin", R.drawable.compost2, 200, 2, "c")};
    static final StoreItem[] solarPanels = {new StoreItem("Basic Solar Panel", R.drawable.solar1, 20, 1, "s"),
            new StoreItem("High Efficiency Solar Panel", R.drawable.solar2, 200, 2, "s")};
    static final StoreItem[] vegetableGardens = {new StoreItem("Small Potato Garden", R.drawable.potato1, 20, 1, "g"),
            new StoreItem("BEEG Potato Garden", R.drawable.potato2, 200, 2, "g")};
    static final StoreItem[] beeHive = {new StoreItem("Bee Hive", R.drawable.bees1, 20, 1, "b"),
            new StoreItem("2-Story Bee Hive", R.drawable.bees2, 200, 2, "b")};
    static final StoreItem[] fruitTree = {new StoreItem("Orange Tree", R.drawable.tree1, 20, 1, "t"),
            new StoreItem("XXL Orange Tree", R.drawable.tree2, 200, 2, "t")};
    static final StoreItem[][] storeItems = {composts, solarPanels, vegetableGardens, beeHive, fruitTree};

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
