package com.mredrock.freshmanspecial.Utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.Adapter.ImageViewPagerAdapter;
import com.mredrock.freshmanspecial.CQUPTStrategy.Model.Dormitory;
import com.mredrock.freshmanspecial.R;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoView;

public class ImageActivity extends AppCompatActivity {

    private HackyViewPager viewPager;
    private ImageViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_2017_activity_image);

        initView();
    }

    private void initView() {
        viewPager = (HackyViewPager) findViewById(R.id.special_2017_ac_image_hvp);
        Intent intent = getIntent();
        Dormitory.DormitoryData dormitoryData = (Dormitory.DormitoryData) intent.getSerializableExtra("image_data");
        List<PhotoView> photoViews = new ArrayList<>();
        for (int i = 0; i < dormitoryData.getUrl().size(); i++) {
            PhotoView photoView = new PhotoView(this);
            Glide.with(this).load(dormitoryData.getUrl().get(i)).into(photoView);
            photoViews.add(photoView);
        }
        pagerAdapter = new ImageViewPagerAdapter(photoViews);
        viewPager.setAdapter(pagerAdapter);
    }
}
