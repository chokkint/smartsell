package com.ivantee.smartsell.customer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ivantee.smartsell.R;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.HotCity;
import com.zaaach.citypicker.model.LocateState;
import com.zaaach.citypicker.model.LocatedCity;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class AddCustomer extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private List<HotCity> hotCities;
    private int anim;
    private int theme;
    private boolean enable;
    TextView city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        ImageView returnBack = (ImageView) findViewById(R.id.addReturnBack);
        returnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AddCustomer.this, CustomerHandPickActivity.class);
                startActivity(intent);
            }
        });
        city = findViewById(R.id.city);

        LinearLayout cityLayout = findViewById(R.id.cityLinner);
        cityLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CityPicker.from(AddCustomer.this)
                        .enableAnimation(enable)
                        .setAnimationStyle(anim)
                        .setLocatedCity(null)
                        .setHotCities(hotCities)
                        .setOnPickListener(new OnPickListener() {
                            @Override
                            public void onPick(int position, City data) {
                                city.setText(String.format("%s>%s", data.getProvince(),data.getName()));
                            }

                            @Override
                            public void onCancel() {
                                Toast.makeText(getApplicationContext(), "取消选择", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLocate() {
                                //开始定位，这里模拟一下定位
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        CityPicker.from(AddCustomer.this).locateComplete(new LocatedCity("深圳", "广东", "101280601"), LocateState.SUCCESS);
                                    }
                                }, 3000);
                            }
                        })
                        .show();
            }
        });
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

}
