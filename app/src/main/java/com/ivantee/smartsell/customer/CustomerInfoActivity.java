package com.ivantee.smartsell.customer;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ivantee.smartsell.R;

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

                    return true;
                case R.id.navigation_mine:

                    return true;
            }

            return false;
        }
    };

}
