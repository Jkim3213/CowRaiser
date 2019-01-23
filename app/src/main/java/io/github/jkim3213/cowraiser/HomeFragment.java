package io.github.jkim3213.cowraiser;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class HomeFragment extends Fragment {

    private ViewGroup haven;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;


        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(getString(R.string.vegetarian_title));
        arrayList.add(getString(R.string.light_title));
        arrayList.add(getString(R.string.altertransport_title));
        arrayList.add(getString(R.string.shower_title));
        arrayList.add(getString(R.string.rice_title));
        arrayList.add(getString(R.string.publtransport_title));


        ListView myListView = view.findViewById(R.id.myListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, arrayList);
        myListView.setAdapter(arrayAdapter);
        haven = view.findViewById(R.id.haven);



        Toast.makeText(getContext(), "Welcome to Home.", Toast.LENGTH_SHORT).show();

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = null;
                switch(position) {
                    case 0:
                        intent = new Intent(getContext(), VegetarianChallenge.class);
                        break;
                    case 1:
                        intent = new Intent(getContext(), LightChallenge.class);
                        break;
                    case 2:
                        intent = new Intent(getContext(), AltTransportChallenge.class);
                        break;
                    case 3:
                        intent = new Intent(getContext(), ShowerChallenge.class);
                        break;
                    case 4:
                        intent = new Intent(getContext(), RiceChallenge.class);
                        break;
                    case 5:
                        intent = new Intent(getContext(), PublTransportChallenge.class);
                        break;

                    default:
                        System.err.println("Broken Activity");
                }
                startActivity(intent);


            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        fillHaven();
    }

    private void fillHaven() {
        //TODO to be replaced when we have a real haven
        haven.removeAllViews();
        for(Map.Entry<String, Integer> item : UserProfile.inventory.entrySet()){
            System.out.println("uoyoyWHatthefucko");
            for(int i = 0; i < item.getValue(); i++) {
                System.out.println(item.getValue());
                TextView tv = new TextView(getContext());
                tv.setText(item.getKey());
                haven.addView(tv);
            }

        }


    }

}
