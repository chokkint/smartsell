package com.ivantee.smartsell;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class CustomerHandPickActivity extends AppCompatActivity {
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_hand_pick);

        intent = new Intent();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_customer);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    intent.setClass(CustomerHandPickActivity.this, CustomerInfoActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_customer:

                    return true;
                case R.id.navigation_dynamic:

                    return true;
                case R.id.navigation_mine:

                    return true;
            }

            return false;
        }
    };
}
