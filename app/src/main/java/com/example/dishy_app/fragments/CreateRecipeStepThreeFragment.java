package com.example.dishy_app.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dishy_app.R;


public class CreateRecipeStepThreeFragment extends Fragment {

    public static CreateRecipeStepThreeFragment newInstance() {
        CreateRecipeStepThreeFragment fragment = new CreateRecipeStepThreeFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_recipe_step_three, container, false);
    }

}
