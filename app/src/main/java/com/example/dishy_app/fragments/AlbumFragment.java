package com.example.dishy_app.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dishy_app.R;
import com.example.dishy_app.adaptes.FragmentAlbumAdapter;

public class AlbumFragment extends Fragment {
    private View mView;
    private TextView txt_saved_recipe, txt_my_recipe;
    private ViewPager pager_album;
    private LinearLayout ll_saved_recipe, ll_my_recipe;

    private FragmentAlbumAdapter fragmentAlbumAdapter;

    public static AlbumFragment newInstance() {
        AlbumFragment fragment = new AlbumFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_album, container, false);

        txt_saved_recipe = mView.findViewById(R.id.txt_saved_recipe);
        txt_my_recipe = mView.findViewById(R.id.txt_my_recipe);
        pager_album = mView.findViewById(R.id.pager_album);
        ll_saved_recipe = mView.findViewById(R.id.ll_saved_recipe);
        ll_my_recipe = mView.findViewById(R.id.ll_my_recipe);

        fragmentAlbumAdapter = new FragmentAlbumAdapter(getChildFragmentManager());
        pager_album.setAdapter(fragmentAlbumAdapter);
        pager_album.setCurrentItem(0);
        pager_album.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    setPageSavedRecipe();
                } else if (position == 1) {
                    setPageMyRecipe();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return mView;
    }

    private void setPageSavedRecipe() {
        ll_saved_recipe.setBackgroundResource(R.color.colorMain);
        ll_my_recipe.setBackgroundResource(R.color.colorWhite);
    }

    private void setPageMyRecipe() {
        ll_saved_recipe.setBackgroundResource(R.color.colorWhite);
        ll_my_recipe.setBackgroundResource(R.color.colorMain);
    }

}
