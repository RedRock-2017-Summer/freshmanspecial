package com.mredrock.freshmanspecial.Adapter;


import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by Anriku on 2017/8/10.
 */

public class ImageViewPagerAdapter extends PagerAdapter {

    private List<PhotoView> photoViewList;
    private int mChildCount = 0;

    public ImageViewPagerAdapter(List<PhotoView> photoViewList) {
        this.photoViewList = photoViewList;
    }

    @Override
    public void notifyDataSetChanged() {
        mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        if (mChildCount > 0) {
            mChildCount--;
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        return photoViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(photoViewList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        PhotoView photoView = photoViewList.get(position);
        container.addView(photoView);
        return photoViewList.get(position);
    }
}
