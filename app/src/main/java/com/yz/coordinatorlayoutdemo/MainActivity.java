package com.yz.coordinatorlayoutdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageShow;
    private TextView mTextShow;
    private TabLayout mTabLayShow;
    private MyViewPager mViewShow;
    private CoordinatorLayout mCooLay;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        list = new ArrayList<>();
        list.add(new ShowFragment());
        //list.add(new TextShowFragment());
        list.add(new ShowFragment());
        //list.add(new TextShowFragment());
        mViewShow.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    private void initView() {
        mImageShow = (ImageView) findViewById(R.id.image_show);
        mTextShow = (TextView) findViewById(R.id.text_show);
        mTabLayShow = (TabLayout) findViewById(R.id.tab_lay_show);
        mViewShow = findViewById(R.id.view_show);
        mCooLay = (CoordinatorLayout) findViewById(R.id.coo_lay);
    }
}
