package com.ivantee.smartsell.chest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ivantee.smartsell.R;
import com.ivantee.smartsell.customer.CustomerHandPickActivity;
import com.ivantee.smartsell.customer.CustomerInfoActivity;

public class ChestMainActivity extends AppCompatActivity {
    Intent intent = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_main);
        intent = new Intent();

        BottomNavigationView navigation = (BottomNavigationView)findViewById(R.id.navigation2);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_dynamic);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_customer:
                    intent.setClass(ChestMainActivity.this, CustomerHandPickActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_dynamic:

                    return true;
                case R.id.navigation_mine:
                    intent.setClass(ChestMainActivity.this, CustomerInfoActivity.class);
                    startActivity(intent);
                    return true;
            }

            return false;
        }
    };
}
