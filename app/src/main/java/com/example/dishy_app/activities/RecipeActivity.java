package com.example.dishy_app.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dishy_app.R;
import com.example.dishy_app.adaptes.MaterialRecipeAdapter;
import com.example.dishy_app.adaptes.StepMakeRecipeAdapter;
import com.example.dishy_app.models.Dishy;
import com.example.dishy_app.models.Material;
import com.example.dishy_app.models.StepMake;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTxtNumberCount, mTxtNameRecipe, mTxtNameChef, mTxtNumberFavorite, mTxtFollowing, mTxtFavorite;
    private Button mBtnDiv, mBtnSum, mBtnDoRecipe;
    private ImageView mImgAvatarRecipe, mImgFavorite, mImgSave, mImgBack,mImgChef;
    private ImageView mImgStar1, mImgStar2, mImgStar3, mImgStar4, mImgStar5;
    private RoundedImageView mImgAvatarChef;
    private LinearLayout mLLChef;
    private Toolbar mToolbar;
    private NestedScrollView mNestedScrollView;

    private RecyclerView mRcvMaterial, mRcvStepMake;
    private MaterialRecipeAdapter materialRecipeAdapter;
    private StepMakeRecipeAdapter mStepMakeRecipeAdapter;
    private List<Material> mMaterials;
    private List<StepMake> mStepMakes;
    private Boolean checkFollow = false;
    private Boolean checkLikeRecipe = false;
    private int numberCount;
    private int numberEater;
    private Dishy dishy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initView() {
        mRcvMaterial = findViewById(R.id.rcv_material_recipe_activity);
        LinearLayoutManager manager = new LinearLayoutManager(RecipeActivity.this, RecyclerView.VERTICAL, false);
        mRcvMaterial.setHasFixedSize(true);
        mRcvMaterial.setLayoutManager(manager);

        mRcvStepMake = findViewById(R.id.rcv_make_step_ra);
        LinearLayoutManager magagerStepMake = new LinearLayoutManager(RecipeActivity.this, RecyclerView.VERTICAL, false);
        mRcvStepMake.setLayoutManager(magagerStepMake);
        mRcvStepMake.setHasFixedSize(true);

        mTxtNumberCount = findViewById(R.id.txt_number_eater);
        mBtnDiv = findViewById(R.id.btn_div);
        mBtnSum = findViewById(R.id.btn_sum);
        mImgAvatarRecipe = findViewById(R.id.img_avatar_food_ra);
        mImgFavorite = findViewById(R.id.img_favorite_ra);
        mImgSave = findViewById(R.id.img_save_recipe_ra);
        mImgAvatarChef = findViewById(R.id.img_avatar_chef_ra);
        mLLChef = findViewById(R.id.ll_chef_ra);
        mTxtNameRecipe = findViewById(R.id.txt_name_recipe_ra);
        mNestedScrollView = findViewById(R.id.nsv_recipe_activity);
        mImgBack = findViewById(R.id.img_button_back_recipe_activity);
        mToolbar = findViewById(R.id.tb_ra);
        mTxtNameChef = findViewById(R.id.txt_name_chef_ra);
        mTxtNumberFavorite = findViewById(R.id.txt_number_favorite_ra);
        mTxtFollowing = findViewById(R.id.txt_following_recipe_activity);
        mTxtFavorite = findViewById(R.id.txt_number_favorite_recipe_ra);
        mImgChef = findViewById(R.id.img_avatar_chef_ra);
        mTxtNameChef = findViewById(R.id.txt_name_chef_ra);
        mImgStar1 = findViewById(R.id.img_star_recipe_1);
        mImgStar2 = findViewById(R.id.img_star_recipe_2);
        mImgStar3 = findViewById(R.id.img_star_recipe_3);
        mImgStar4 = findViewById(R.id.img_star_recipe_4);
        mImgStar5 = findViewById(R.id.img_star_recipe_5);
        mBtnDoRecipe = findViewById(R.id.btn_do_recipe);
    }

    private void initData() {
        mBtnDiv.setOnClickListener(this);
        mBtnSum.setOnClickListener(this);
        mImgBack.setOnClickListener(this);
        mTxtFollowing.setOnClickListener(this);
        mImgFavorite.setOnClickListener(this);
        mBtnDoRecipe.setOnClickListener(this);

        dishy = (Dishy) getIntent().getSerializableExtra("DISHY");

        Picasso.Builder builder = new Picasso.Builder(RecipeActivity.this);
        builder.build().load(dishy.getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background).into(mImgAvatarRecipe);

        if (dishy.getChef()!=null){
            builder.build().load(dishy.getChef().getAvatar())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background).into(mImgChef);
            mTxtNameChef.setText(dishy.getChef().getName());
            mTxtNumberFavorite.setText(String.valueOf(dishy.getChef().getNumberLiker()));
        }

        if (dishy.getStar() == 1) {
            mImgStar2.setVisibility(View.GONE);
            mImgStar3.setVisibility(View.GONE);
            mImgStar4.setVisibility(View.GONE);
            mImgStar5.setVisibility(View.GONE);
        } else if (dishy.getStar() == 2) {
            mImgStar3.setVisibility(View.GONE);
            mImgStar4.setVisibility(View.GONE);
            mImgStar5.setVisibility(View.GONE);
        } else if (dishy.getStar() == 3) {
            mImgStar4.setVisibility(View.GONE);
            mImgStar5.setVisibility(View.GONE);
        } else if (dishy.getStar() == 4) {
            mImgStar5.setVisibility(View.GONE);
        }

        mTxtFavorite.setText(String.valueOf(dishy.getNumberFavorite()));
        mTxtNameRecipe.setText(dishy.getName());

        mMaterials = new ArrayList<>();
        mMaterials = dishy.getMaterials();

        numberEater = dishy.getEater();
        mTxtNumberCount.setText(String.valueOf(numberEater));
        numberCount = Integer.parseInt(mTxtNumberCount.getText().toString().trim());

        updateRcvMaterial(numberCount, numberEater);
        mStepMakes = new ArrayList<>();
        mStepMakes = dishy.getMakes();
        updateRcvStepMake();

        mToolbar.setTitle(dishy.getName());
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mNestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > 150) {
                    mToolbar.setVisibility(View.VISIBLE);
                } else {
                    mToolbar.setVisibility(View.GONE);
                }
            }
        });

    }

    private void updateRcvMaterial(int numberCount, int numberEater) {
        if (materialRecipeAdapter == null) {
            materialRecipeAdapter = new MaterialRecipeAdapter(RecipeActivity.this, mMaterials, numberEater, numberCount);
            mRcvMaterial.setAdapter(materialRecipeAdapter);
        } else {
            materialRecipeAdapter.update(numberCount);
        }
    }

    private void updateRcvStepMake() {
        if (mStepMakeRecipeAdapter == null) {
            mStepMakeRecipeAdapter = new StepMakeRecipeAdapter(RecipeActivity.this, mStepMakes);
            mRcvStepMake.setAdapter(mStepMakeRecipeAdapter);
        } else {
            mStepMakeRecipeAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_div:
                int number = Integer.parseInt(mTxtNumberCount.getText().toString().trim());
                int afterDiv = number;
                if (afterDiv > 1) {
                    afterDiv = afterDiv - 1;
                    mTxtNumberCount.setText(String.valueOf(afterDiv));
                }
                updateRcvMaterial(afterDiv, numberEater);
                break;
            case R.id.btn_sum:
                int numberSum = Integer.parseInt(mTxtNumberCount.getText().toString().trim());
                int afterSum = numberSum + 1;
                mTxtNumberCount.setText(String.valueOf(afterSum));
                updateRcvMaterial(afterSum, numberEater);
                break;
            case R.id.img_button_back_recipe_activity:
                finish();
                break;
            case R.id.txt_following_recipe_activity:
                int numberFavorite = Integer.parseInt(mTxtNumberFavorite.getText().toString());
                if (checkFollow == true) {
                    mTxtFollowing.setBackgroundResource(R.drawable.custom_frame_input);
                    mTxtFollowing.setText("Theo dõi");
                    mTxtNumberFavorite.setText(String.valueOf(numberFavorite - 1));
                    mTxtFollowing.setTextColor(Color.parseColor("#6D6A6A"));
                    checkFollow = false;
                } else {
                    mTxtFollowing.setBackgroundResource(R.drawable.custom_followed);
                    mTxtFollowing.setText("Đã theo dõi");
                    mTxtNumberFavorite.setText(String.valueOf(numberFavorite + 1));
                    mTxtFollowing.setTextColor(Color.parseColor("#ffffff"));
                    checkFollow = true;
                }
                break;
            case R.id.img_favorite_ra:
                int numberFavoriteRecipe = Integer.parseInt(mTxtFavorite.getText().toString());
                if (checkLikeRecipe == true) {
                    mImgFavorite.setImageResource(R.drawable.ic_favorite_border);
                    mTxtFavorite.setText(String.valueOf(numberFavoriteRecipe - 1));
                    checkLikeRecipe = false;
                } else {
                    mImgFavorite.setImageResource(R.drawable.ic_favorite);
                    mTxtFavorite.setText(String.valueOf(numberFavoriteRecipe + 1));
                    checkLikeRecipe = true;
                }
                break;
            case R.id.btn_do_recipe:
                Intent intent  =new Intent(RecipeActivity.this,DoRecipeActivity.class);
                intent.putExtra("NAME",dishy.getName());
                intent.putExtra("STEP", (Serializable) dishy.getMakes());
                startActivity(intent);
                break;
        }
    }
}
