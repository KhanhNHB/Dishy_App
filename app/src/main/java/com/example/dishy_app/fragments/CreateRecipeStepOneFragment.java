package com.example.dishy_app.fragments;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dishy_app.R;

import java.io.IOException;

public class CreateRecipeStepOneFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private static int PICK_IMAGE_REQUEST = 1311;

    private View mView;
    private ImageView mImgAvatar;
    private TextView mTxtLevelRecipe;
    private Uri mUriAvatar;
    private Toolbar mToolbar;
    private Spinner mSpnLevelRecipe;

    public static CreateRecipeStepOneFragment newInstance() {
        CreateRecipeStepOneFragment fragment = new CreateRecipeStepOneFragment();
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
        mView = inflater.inflate(R.layout.fragment_create_recipe_step_one, container, false);
        initView();
        initData();
        return mView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {

            mUriAvatar = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), mUriAvatar);
                // Log.d(TAG, String.valueOf(bitmap));
                mImgAvatar.setImageBitmap(bitmap);
                mImgAvatar.setScaleType(ImageView.ScaleType.FIT_XY);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initView() {
        mImgAvatar = mView.findViewById(R.id.img_avatar_recipe);

        mSpnLevelRecipe = mView.findViewById(R.id.sp_level_recipe);
        mTxtLevelRecipe = mView.findViewById(R.id.txt_level_recipe);
    }

    private void initData() {
        mImgAvatar.setOnClickListener(this);
        mSpnLevelRecipe.setOnItemSelectedListener(this);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.level_recip, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        mSpnLevelRecipe.setAdapter(adapter);

    }


    private void pickFromGallery() {
        //Create an Intent with action as ACTION_PICK
        Intent intent = new Intent(Intent.ACTION_PICK);
        // Sets the type as image/*. This ensures only components of type image are selected
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_avatar_recipe:
                pickFromGallery();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mTxtLevelRecipe.setText(adapterView.getItemAtPosition(i).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        mTxtLevelRecipe.setText(adapterView.getFirstVisiblePosition());
    }
}
