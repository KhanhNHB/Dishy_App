package com.example.dishy_app.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dishy_app.R;
import com.example.dishy_app.adaptes.FragementStepCreateRecipeAdapter;


import java.io.IOException;

public class CreateRecipeActivity extends AppCompatActivity  {
    private Toolbar mToolbar;
    private ViewPager mViewPager ;
    private FragementStepCreateRecipeAdapter mFragementStepCreateRecipeAdapter;

    private LinearLayout mLLStepOne, mLLStepWto, mLLStepThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);
        initView();
        initData();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void initView(){
        mToolbar = findViewById(R.id.tb_create_recipe);
        mViewPager =  findViewById(R.id.vp_create_recipe);
        mLLStepOne = findViewById(R.id.ll_dot_step_1);
        mLLStepWto = findViewById(R.id.ll_dot_step_2);
        mLLStepThree = findViewById(R.id.ll_dot_step_3);
    }

    private void initData(){
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateRecipeActivity.this.finish();
            }
        });

        mFragementStepCreateRecipeAdapter =  new FragementStepCreateRecipeAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mFragementStepCreateRecipeAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==0){
                    setPageStepOne();
                }else if (position==1){
                    setPageStepWto();
                }else if (position==2){
                    setPageStepThree();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setPageStepOne(){
        mLLStepOne.setBackgroundResource(R.drawable.custom_step_over);
        mLLStepWto.setBackgroundResource(R.drawable.custom_step_over_no_selected);
        mLLStepThree.setBackgroundResource(R.drawable.custom_step_over_no_selected);
    }

    private void setPageStepWto(){
        mLLStepOne.setBackgroundResource(R.drawable.custom_step_over_no_selected);
        mLLStepWto.setBackgroundResource(R.drawable.custom_step_over);
        mLLStepThree.setBackgroundResource(R.drawable.custom_step_over_no_selected);
    }

    private void setPageStepThree(){
        mLLStepOne.setBackgroundResource(R.drawable.custom_step_over_no_selected);
        mLLStepWto.setBackgroundResource(R.drawable.custom_step_over_no_selected);
        mLLStepThree.setBackgroundResource(R.drawable.custom_step_over);
    }

}
