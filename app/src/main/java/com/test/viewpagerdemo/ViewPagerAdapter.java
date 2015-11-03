package com.test.viewpagerdemo;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoumao on 15/10/29.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private List<View> mListViews;
    private ArrayList<String> titleContainer = new ArrayList<String>();


    public ViewPagerAdapter(List<View> mListViews,ArrayList<String> titleContainer){
        this.mListViews = mListViews;
        this.titleContainer = titleContainer;
    }
    //viewpager中的组件数量
    @Override
    public int getCount() {
        return mListViews.size();
    }
    //滑动切换的时候销毁当前的组件
    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {
        ((ViewPager) container).removeView(mListViews.get(position));
    }
    //每次滑动的时候生成的组件
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager) container).addView(mListViews.get(position));
        return mListViews.get(position);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleContainer.get(position);
    }
  }
