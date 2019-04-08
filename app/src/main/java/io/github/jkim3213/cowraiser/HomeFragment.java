package io.github.jkim3213.cowraiser;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    private View view;
    private ImageView compostImageView;
    private ImageView solarImageView;
    private ImageView potatoImageView;
    private ImageView beeImageView;
    private ImageView treeImageView;
    private DatabaseReference mDatabase;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        compostImageView = view.findViewById(R.id.compost);
        solarImageView = view.findViewById(R.id.solar);
        potatoImageView = view.findViewById(R.id.potato);
        beeImageView = view.findViewById(R.id.bee);
        treeImageView = view.findViewById(R.id.tree);

    }

    @Override
    public void onResume() {
        super.onResume();
        mDatabase = FirebaseDatabase.getInstance().getReference("Users/" + UserProfile.UID);
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserProfile post = dataSnapshot.getValue(UserProfile.class);
                if(post != null) {
                    post.setUser();
                    setUpgrades();
                }

                Log.i("HavenLoad", post.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    //manage Haven item upgrade
    private void setUpgrades() {

        setUpgradeHelper("c", compostImageView, StoreFragment.composts);
        setUpgradeHelper("s", solarImageView, StoreFragment.solarPanels);
        setUpgradeHelper("g", potatoImageView, StoreFragment.vegetableGardens);
        setUpgradeHelper("b", beeImageView, StoreFragment.beeHive);
        setUpgradeHelper("t", treeImageView, StoreFragment.fruitTree);



    }

    private void setUpgradeHelper(String type, ImageView imageView, StoreItem[] items) {
        Integer level = UserProfile.curLevels.get(type);
        if(level == null || level <= 0) {
            Log.d("HAVEN", type + " level: " + level);
            imageView.setImageResource(android.R.color.transparent);
        } else {
            if(level <= items.length) {
                imageView.setImageResource(items[level - 1].imageId);
            }

        }

    }
}



