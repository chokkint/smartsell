package com.ivantee.smartsell.customer;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ivantee.smartsell.R;
import com.ivantee.smartsell.chest.ChestMainActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class CustomerInfoActivity extends AppCompatActivity {
    Intent intent = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);
        intent = new Intent();

        BottomNavigationView navigation = (BottomNavigationView)findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_mine);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_customer:

                    intent.setClass(CustomerInfoActivity.this, CustomerHandPickActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_dynamic:
                    intent.setClass(CustomerInfoActivity.this, ChestMainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_mine:

                    return true;
            }

            return false;
        }
    };

}
