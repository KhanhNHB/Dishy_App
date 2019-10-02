package com.example.dishy_app.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTxtNumberCount, mTxtNameRecipe;
    private Button mBtnDiv, mBtnSum;
    private ImageView mImgAvatarRecipe, mImgFavorite, mImgSave, mImgBack;
    private RoundedImageView mImgAvatarChef;
    private LinearLayout mLLChef;
    private Toolbar mToolbar;
    private NestedScrollView mNestedScrollView;

    private RecyclerView mRcvMaterial, mRcvStepMake;
    private MaterialRecipeAdapter materialRecipeAdapter;
    private StepMakeRecipeAdapter mStepMakeRecipeAdapter;
    private List<Material> mMaterials;
    private List<StepMake> mStepMakes;

    private int numberCount;

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
    }

    private void initData() {
        mBtnDiv.setOnClickListener(this);
        mBtnSum.setOnClickListener(this);
        mImgBack.setOnClickListener(this);

        Dishy dishy = (Dishy) getIntent().getSerializableExtra("DISHY");
        Picasso.Builder builder = new Picasso.Builder(RecipeActivity.this);
        builder.build().load(dishy.getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background).into(mImgAvatarRecipe);
        mTxtNameRecipe.setText(dishy.getName());

        mMaterials = new ArrayList<>();
        mMaterials.add(new Material("Thịt bò", 1000, "Gram"));
        mMaterials.add(new Material("Tỏi", 3, "Tép"));
        mMaterials.add(new Material("Cả chua", 2000, "Gram"));
        numberCount = Integer.parseInt(mTxtNumberCount.getText().toString().trim());
        updateRcvMaterial(numberCount);
        mStepMakes = new ArrayList<>();
        mStepMakes.add(new StepMake("ahahahhahahahahahahaahh\nahahahhahahahahahahaahh", true, null, null));
        mStepMakes.add(new StepMake("ahahahhahahahahahahaahh", true, null, null));
        mStepMakes.add(new StepMake("ahahahhahahahahahahaahh", true, null, null));
        mStepMakes.add(new StepMake("ahahahhahahahahahahaahh", true, null, null));
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

    private void updateRcvMaterial(int numberCount) {
        if (materialRecipeAdapter == null) {
            materialRecipeAdapter = new MaterialRecipeAdapter(RecipeActivity.this, mMaterials, 4, numberCount);
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
                updateRcvMaterial(afterDiv);
                break;
            case R.id.btn_sum:
                int numberSum = Integer.parseInt(mTxtNumberCount.getText().toString().trim());
                int afterSum = numberSum + 1;
                mTxtNumberCount.setText(String.valueOf(afterSum));
                updateRcvMaterial(afterSum);
                break;
            case R.id.img_button_back_recipe_activity:
                finish();
                break;
        }
    }
}
