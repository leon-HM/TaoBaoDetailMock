package com.leon.taobaodetailmock.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.leon.taobaodetailmock.R;
import com.leon.taobaodetailmock.widget.DragLayout;
import com.leon.taobaodetailmock.widget.DragLayout.ShowNextPageNotifier;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "leon";
    @Bind(R.id.draglayout)
    DragLayout draglayout;

    @Bind(R.id.viewPager)
    ViewPager viewPager;

    @Bind(R.id.tabIndicator)
    TabLayout tabLayout;

    final List<Fragment> fragments = new ArrayList<>();
    private String[] titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {

        ShowNextPageNotifier nextIntf = new ShowNextPageNotifier() {
            @Override
            public void onDragNext(int pageIndex){
                Log.d(TAG, "onDragNext pageIndex:"+pageIndex);
            }
        };
        draglayout = (DragLayout) findViewById(R.id.draglayout);
        draglayout.setNextPageListener(nextIntf);

        ButterKnife.bind(this);

        fragments.clear();
        fragments.add(0, Fragment1.newInstance());
        fragments.add(1, Fragment2.newInstance());
        fragments.add(2, Fragment3.newInstance());
        fragments.add(3, Fragment4.newInstance());

        titles = getResources().getStringArray(R.array.second_page_indicator);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        viewPager.setOffscreenPageLimit(fragments.size());

        tabLayout.setupWithViewPager(viewPager);

    }

}
