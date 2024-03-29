package com.example.dishy_app.adaptes;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.dishy_app.fragments.CreateRecipeStepOneFragment;
import com.example.dishy_app.fragments.CreateRecipeStepThreeFragment;
import com.example.dishy_app.fragments.CreateRecipeStepTwoFragment;


public class FragementStepCreateRecipeAdapter extends FragmentStatePagerAdapter {
    private static int NUMBER_PAGE = 3;

    public FragementStepCreateRecipeAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return CreateRecipeStepOneFragment.newInstance();
            case 1:
                return CreateRecipeStepTwoFragment.newInstance();
            case 2:
                return CreateRecipeStepThreeFragment.newInstance();
            default:
                return CreateRecipeStepOneFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return NUMBER_PAGE;
    }
}
