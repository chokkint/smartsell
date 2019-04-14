package com.ivantee.smartsell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ivantee.smartsell.base.BaseFragment;
import com.ivantee.smartsell.base.BaseFragmentActivity;
import com.ivantee.smartsell.customer.CustomerHandPickActivity;
import com.ivantee.smartsell.customer.CustomerReport;
import com.ivantee.smartsell.fragment.HomeFragment;

public class HomeActivity extends BaseFragmentActivity {

    private static final String KEY_FRAGMENT = "key_fragment";
    private static final String KEY_URL = "key_url";
    private static final String KEY_TITLE = "key_title";
    private static final int VALUE_FRAGMENT_HOME = 0;
    private static final int VALUE_FRAGMENT_NOTCH_HELPER = 1;
    private static final int VALUE_FRAGMENT_ARCH_TEST = 2;
    private static final int VALUE_FRAGMENT_WEB_EXPLORER_TEST = 3;
    private static final int VALUE_FRAGMENT_SURFACE_TEST = 4;
    @Override
    protected int getContextViewId() {
        return R.id.qmuidemo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent();
        intent.setClass(HomeActivity.this, CustomerHandPickActivity.class);
        startActivity(intent);
//        if (savedInstanceState == null) {
//            BaseFragment fragment = getFirstFragment();
//
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .add(getContextViewId(), fragment, fragment.getClass().getSimpleName())
//                    .addToBackStack(fragment.getClass().getSimpleName())
//                    .commit();
//        }
    }

    private BaseFragment getFirstFragment() {
        Intent intent = getIntent();
        int ret = intent.getIntExtra(KEY_FRAGMENT, 0);
        BaseFragment fragment;
        /*if (ret == VALUE_FRAGMENT_NOTCH_HELPER) {
            //fragment = new QDNotchHelperFragment();
        } else if (ret == VALUE_FRAGMENT_ARCH_TEST) {
            //fragment = new QDArchTestFragment();
        } else if (ret == VALUE_FRAGMENT_WEB_EXPLORER_TEST) {
            Bundle bundle = new Bundle();
            //bundle.putString(EXTRA_URL, intent.getStringExtra(KEY_URL));
            //bundle.putString(EXTRA_TITLE, intent.getStringExtra(KEY_TITLE));
           // fragment = new QDArchWebViewTestFragment();
            //fragment.setArguments(bundle);
        } else if (ret == VALUE_FRAGMENT_SURFACE_TEST) {
            //fragment = new QDArchSurfaceTestFragment();
        } else {*/
        fragment = new HomeFragment();
        // }

        return fragment;
    }

   /* public static Intent createNotchHelperIntent(Context context) {
        Intent intent = new Intent(context, QDMainActivity.class);
        intent.putExtra(KEY_FRAGMENT, VALUE_FRAGMENT_NOTCH_HELPER);
        return intent;
    }

    public static Intent createArchTestIntent(Context context) {
        Intent intent = new Intent(context, QDMainActivity.class);
        intent.putExtra(KEY_FRAGMENT, VALUE_FRAGMENT_ARCH_TEST);
        return intent;
    }

    public static Intent createWebExplorerIntent(Context context, String url, String title) {
        Intent intent = new Intent(context, QDMainActivity.class);
        intent.putExtra(KEY_FRAGMENT, VALUE_FRAGMENT_WEB_EXPLORER_TEST);
        intent.putExtra(KEY_URL, url);
        intent.putExtra(KEY_TITLE, title);
        return intent;
    }

    public static Intent createSurfaceTestIntent(Context context) {
        Intent intent = new Intent(context, QDMainActivity.class);
        intent.putExtra(KEY_FRAGMENT, VALUE_FRAGMENT_SURFACE_TEST);
        return intent;
    }*/
}
