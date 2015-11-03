package com.test.viewpagerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ViewPager awesomePager;

    PagerTabStrip tabStrip = null;
    ArrayList<View> mListViews = new ArrayList<View>();
    ArrayList<String> titleContainer = new ArrayList<String>();
    public String TAG = "tag";

    private ViewPagerAdapter viewPagerAdapter;

    private LayoutInflater mInflater;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tabStrip = (PagerTabStrip) this.findViewById(R.id.tabstrip);
        //取消tab下面的长横线
        tabStrip.setDrawFullUnderline(false);
        //设置tab的背景色
        tabStrip.setBackgroundColor(this.getResources().getColor(R.color.white));
        //设置当前tab页签的下划线颜色
        tabStrip.setTabIndicatorColor(this.getResources().getColor(R.color.red));
        tabStrip.setTextSpacing(200);

        //页签项
        titleContainer.add("网易新闻");
        titleContainer.add("网易体育");
        titleContainer.add("网易财经");

        mInflater = getLayoutInflater();
        mListViews.add(mInflater.inflate(R.layout.layout1, null));
        mListViews.add(mInflater.inflate(R.layout.layout2, null));
        mListViews.add(mInflater.inflate(R.layout.layout3, null));

        viewPagerAdapter = new ViewPagerAdapter(mListViews,titleContainer);
        awesomePager = (ViewPager) findViewById(R.id.awesomepager);
        awesomePager.setAdapter(viewPagerAdapter);


        awesomePager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int arg0) {
                Log.d(TAG, "--------changed:" + arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                Log.d(TAG, "-------scrolled arg0:" + arg0);
                Log.d(TAG, "-------scrolled arg1:" + arg1);
                Log.d(TAG, "-------scrolled arg2:" + arg2);
            }

            @Override
            public void onPageSelected(int arg0) {
                Log.d(TAG, "------selected:" + arg0);
            }
        });

    }

}