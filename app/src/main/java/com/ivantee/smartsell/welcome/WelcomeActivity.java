package com.ivantee.smartsell.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ivantee.smartsell.R;
import com.ivantee.smartsell.util.SharedPreferencesUtil;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*首先启动该Activity，并判断是否是第一次启动,注意，需要添加默认值,
         * 如果是第一次启动，则先进入功能引导页*/
        boolean isFirstOpen = SharedPreferencesUtil.getBoolean(this, SharedPreferencesUtil.FIRST_OPEN, true);
        //TODO test only

        if(isFirstOpen){
            Intent intent = new Intent(this, WelcomeGuideActivity.class);
            startActivity(intent);
            /*注意，需要使用finish将该activity进行销毁，否则，在按下手机返回键时，会返回至启动页*/
            finish();
            return;
        }
        /*如果不是第一次启动app，则启动页*/
        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*2秒后进入主页*/
                enterHomeActivity();
            }
        },2000);
    }

    private void enterHomeActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        finish();
    }
    @Override
    protected void onDestroy() {
        //TODO will be Delete 回到Welcome页面
        SharedPreferencesUtil.setBoolean(this, SharedPreferencesUtil.FIRST_OPEN, true);
        super.onDestroy();
    }
}
