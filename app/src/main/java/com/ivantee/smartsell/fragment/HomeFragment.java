/*
 * Tencent is pleased to support the open source community by making QMUI_Android available.
 *
 * Copyright (C) 2017-2018 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the MIT License (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://opensource.org/licenses/MIT
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivantee.smartsell.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.ivantee.smartsell.R;
import com.ivantee.smartsell.base.BaseFragment;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.tab.QMUITabSegment;
import com.qmuiteam.qmui.widget.tab.QMUITab;
import com.qmuiteam.qmui.widget.tab.QMUITabBuilder;

import java.util.HashMap;

import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author cginechen
 * @date 2016-10-19
 */

public class HomeFragment extends BaseFragment {
    private final static String TAG = HomeFragment.class.getSimpleName();

    @BindView(R.id.pager)
    ViewPager mViewPager;
    @BindView(R.id.tabs)
    QMUITabSegment mTabSegment;
    private HashMap<Pager, HomeController> mPages;
    private PagerAdapter mPagerAdapter = new PagerAdapter() {

        private int mChildCount = 0;

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public int getCount() {
            return mPages.size();
        }

        @Override
        public Object instantiateItem(final ViewGroup container, int position) {
            HomeController page = mPages.get(Pager.getPagerFromPositon(position));
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            container.removeView(page);
            container.addView(page, params);
            return page;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getItemPosition(Object object) {
            if (mChildCount == 0) {
                return POSITION_NONE;
            }
            return super.getItemPosition(object);
        }

        @Override
        public void notifyDataSetChanged() {
            mChildCount = getCount();
            super.notifyDataSetChanged();
        }
    };


    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, layout);
        initTabs();
        initPagers();
        return layout;
    }

    private void initTabs() {
        int normalColor = QMUIResHelper.getAttrColor(getContext(), R.attr.qmui_config_color_gray_6);
        int selectColor = QMUIResHelper.getAttrColor(getContext(), R.attr.qmui_config_color_blue);
        QMUITabBuilder builder = mTabSegment.tabBuilder();
        builder.setColor(normalColor, selectColor)
                .setSelectedIconScale(1.6f)
                .setTextSize(QMUIDisplayHelper.sp2px(getContext(), 13), QMUIDisplayHelper.sp2px(getContext(), 15))
                .setDynamicChangeIconColor(false);
        QMUITab home = builder
                .setNormalDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_home_black_24dp))
                .setSelectedDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_home_black_24dp))
                .setText(getString(R.string.title_home))
                .build();
        QMUITab handPick = builder
                .setNormalDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_dashboard_black_24dp))
                .setSelectedDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_dashboard_black_24dp))
                .setText(getString(R.string.title_customerHandPick))
                .build();
        QMUITab customerInfo = builder
                .setNormalDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_remove_red_eye_black_24dp))
                .setSelectedDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_remove_red_eye_black_24dp))
                .setText(getString(R.string.title_customer))
                .build();

        QMUITab mine = builder
                .setNormalDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_subject_black_24dp))
                .setSelectedDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_subject_black_24dp))
                .setText(getString(R.string.title_mine))
                .build();

        mTabSegment.addTab(home)
                .addTab(handPick)
                .addTab(customerInfo)
                .addTab(mine);
    }

    private void initPagers() {

        HomeController.HomeControlListener listener = new HomeController.HomeControlListener() {
            @Override
            public void startFragment(BaseFragment fragment) {
                HomeFragment.this.startFragment(fragment);
            }
        };

        mPages = new HashMap<>();

        /*HomeController homeComponentsController = new HomeComponentsController(getActivity());
        homeComponentsController.setHomeControlListener(listener);
        mPages.put(Pager.COMPONENT, homeComponentsController);

        HomeController homeUtilController = new HomeUtilController(getActivity());
        homeUtilController.setHomeControlListener(listener);
        mPages.put(Pager.UTIL, homeUtilController);
*/
        HomeController mineController = new MineController(getActivity());
        mineController.setHomeControlListener(listener);
        //mPages.put(Pager.HOME, mineController);
       // mPages.put(Pager.HANDPICK, mineController);
        HomeController handPickController = new CustomerHandPickController(getActivity());
        handPickController.setHomeControlListener(listener);

        mPages.put(Pager.HOME, mineController);
        mPages.put(Pager.HANDPICK, handPickController);
        mPages.put(Pager.CUSTOMERINFO, mineController);
        mPages.put(Pager.MINE, mineController);

        mViewPager.setAdapter(mPagerAdapter);
        mTabSegment.setupWithViewPager(mViewPager, false);
    }

    enum Pager {
        HOME, HANDPICK, CUSTOMERINFO, MINE;

        public static Pager getPagerFromPositon(int position) {
            switch (position) {
                case 0:
                    return HOME;
                case 1:
                    return HANDPICK;
                case 2:
                    return CUSTOMERINFO;
                case 3:
                    return MINE;
                default:
                    return MINE;
            }
        }
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }
}