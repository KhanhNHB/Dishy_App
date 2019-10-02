package com.example.dishy_app.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dishy_app.R;
import com.example.dishy_app.activities.ChefActivity;
import com.example.dishy_app.activities.DetailActivity;
import com.example.dishy_app.activities.RecipeActivity;
import com.example.dishy_app.adaptes.DishyTodayAdapter;
import com.example.dishy_app.adaptes.TopChefAdapter;
import com.example.dishy_app.adaptes.TopDishyAdapter;
import com.example.dishy_app.models.Chef;
import com.example.dishy_app.models.Dishy;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private RecyclerView mRcvDishyToday, mRcvTopDishy, mRcvTopChef;
    private DishyTodayAdapter mDishyTodayAdapter;
    private TopDishyAdapter mTopDishyAdapter;
    private TopChefAdapter mTopChefAdapter;
    private List<Dishy> mDishyList, mTopDishy;
    private List<Chef> mChefs;
    private View mView;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
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
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        initData();
        return mView;
    }

    private void initView() {
        mRcvDishyToday = mView.findViewById(R.id.rcv_dishy_today);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        mRcvDishyToday.setLayoutManager(manager);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        mRcvTopDishy = mView.findViewById(R.id.rcv_top_recipe);
        mRcvTopDishy.setLayoutManager(layoutManager);

        LinearLayoutManager managerChef = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        mRcvTopChef = mView.findViewById(R.id.rcv_top_chef);
        mRcvTopChef.setLayoutManager(managerChef);

    }

    private void initData() {
        mDishyList = new ArrayList<>();
        mDishyList.add(new Dishy("Gà chiên nước mắm", "https://ninhkieuhotel.vn/uploads/tours/2019_07/canh-ga-chien-nuoc-mam.jpg", "20 phút"));
        mDishyList.add(new Dishy("Bún xào", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjHRH7Sp01qPkD-dBS9yDZIIpbJ8QZq--wh0SNQ9xnuwc0ugSt", "10 phút"));
        mDishyList.add(new Dishy("Lẩu thái", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhXn0VHYu8va-oMEc-E60pPIdeWZXm7edf4LRcYD7fXdf6Rf_o", "34 phút"));
        mDishyList.add(new Dishy("Cơm cuộn", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRqGelogsMrJv1R3tkdQXER63ewilYAUzG4UAO0KWIfSZpGWSn", "12 phút"));
        mDishyList.add(new Dishy("Gà chiên nước mắm", "https://ninhkieuhotel.vn/uploads/tours/2019_07/canh-ga-chien-nuoc-mam.jpg", "20 phút"));
        mDishyList.add(new Dishy("Bún xào", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjHRH7Sp01qPkD-dBS9yDZIIpbJ8QZq--wh0SNQ9xnuwc0ugSt", "10 phút"));
        mDishyList.add(new Dishy("Lẩu thái", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhXn0VHYu8va-oMEc-E60pPIdeWZXm7edf4LRcYD7fXdf6Rf_o", "34 phút"));
        mDishyList.add(new Dishy("Cơm cuộn", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRqGelogsMrJv1R3tkdQXER63ewilYAUzG4UAO0KWIfSZpGWSn", "12 phút"));
        mDishyList.add(new Dishy("Gà chiên nước mắm", "https://ninhkieuhotel.vn/uploads/tours/2019_07/canh-ga-chien-nuoc-mam.jpg", "20 phút"));
        mDishyList.add(new Dishy("Bún xào", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjHRH7Sp01qPkD-dBS9yDZIIpbJ8QZq--wh0SNQ9xnuwc0ugSt", "10 phút"));
        mDishyList.add(new Dishy("Lẩu thái", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhXn0VHYu8va-oMEc-E60pPIdeWZXm7edf4LRcYD7fXdf6Rf_o", "34 phút"));
        mDishyList.add(new Dishy("Cơm cuộn", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRqGelogsMrJv1R3tkdQXER63ewilYAUzG4UAO0KWIfSZpGWSn", "12 phút"));
        mDishyList.add(new Dishy("Gà chiên nước mắm", "https://ninhkieuhotel.vn/uploads/tours/2019_07/canh-ga-chien-nuoc-mam.jpg", "20 phút"));
        mDishyList.add(new Dishy("Bún xào", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjHRH7Sp01qPkD-dBS9yDZIIpbJ8QZq--wh0SNQ9xnuwc0ugSt", "10 phút"));
        mDishyList.add(new Dishy("Lẩu thái", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhXn0VHYu8va-oMEc-E60pPIdeWZXm7edf4LRcYD7fXdf6Rf_o", "34 phút"));
        mDishyList.add(new Dishy("Cơm cuộn", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRqGelogsMrJv1R3tkdQXER63ewilYAUzG4UAO0KWIfSZpGWSn", "12 phút"));
        updateUIRcvDishyToDay(mDishyList);

        mTopDishy = new ArrayList<>();
        mTopDishy.add(new Dishy("Bánh tráng trộn", "https://www.foodpanda.vn/wp-content/uploads/2019/03/anh9.jpg", "24 phút",5));
        mTopDishy.add(new Dishy("Lẩu gà lá giang", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEkQMisNfkjeHfRjc_6ef9gm-qoPL7arQNCz4qm5ysERfkg6bg", "20 phút",3));
        mTopDishy.add(new Dishy("Mì cay", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVypO1DvgzVKT5D8kxt1SVbSG4_coB3_bUkC526_-JB6zF-ajq", "18 phút",2));
        updateUIRcvTopDishy(mTopDishy);

        mChefs =  new ArrayList<>();
        mChefs.add(new Chef("https://scontent.fsgn5-1.fna.fbcdn.net/v/t1.0-1/p320x320/61090498_1285841494925963_1183091008456359936_n.jpg?_nc_cat=101&_nc_oc=AQkXDsimHahDSzxF7BS9NbBvgox8P-BAyPNh2DvJlOZdkZqhBm3KS206w5f7cw1PBneiFi6EtydeF5Gf1avxxUxS&_nc_ht=scontent.fsgn5-1.fna&oh=5092122e39724a586043169cf47d0696&oe=5E2FC72F","Nguyễn Thanh Nhàn",100,1000,mDishyList));
        mChefs.add(new Chef("https://scontent.fsgn5-1.fna.fbcdn.net/v/t1.0-9/70172923_530781041027944_2863099953419386880_o.jpg?_nc_cat=101&_nc_oc=AQlFYB2tkZCgQUyLzRy8IO8HK8iejP05xdDPdg9v6BQRynJ23HLIN2fRf5kdmsrDikZee4UamPU5-Kx540iCc_Nh&_nc_ht=scontent.fsgn5-1.fna&oh=fbdca8ce8e94d3f0362b0b88a6de1a60&oe=5DF68723","Diệp Thị Hiếu Phụng",100,989,mDishyList));
        mChefs.add(new Chef("https://scontent.fsgn5-2.fna.fbcdn.net/v/t1.0-1/c94.0.320.320a/p320x320/10354686_10150004552801856_220367501106153455_n.jpg?_nc_cat=1&_nc_oc=AQnkg1FO0BOUe_3tyQjvLTX0BQknJmTx2Xi46NAM5vcMHW1iain3p1l3Wtld3oXnWyHbYc7B8ePQLpI3SaicuUX2&_nc_ht=scontent.fsgn5-2.fna&oh=9ec1f59f0c8d4f8cc46af0a329d330da&oe=5DFFDC59","Nguyễn Văn Hoà",90,800,mDishyList));
        mChefs.add(new Chef("https://scontent.fsgn5-2.fna.fbcdn.net/v/t1.0-1/p320x320/42702447_309972646225392_437175461110349824_n.jpg?_nc_cat=107&_nc_oc=AQltiSM9CxF69luR0u8RtBS8zt-vjOsQhNThCzmsDSEskyPJJ0OIs5mDc53b-qc6wEzMIhuB-pKxmRBsfaIUk1SZ&_nc_ht=scontent.fsgn5-2.fna&oh=4e4e4be1e05f5f224306f01f99a9dadb&oe=5E351777","Phạm Minh Thành",80,700,mDishyList));
        mChefs.add(new Chef("https://scontent.fsgn5-6.fna.fbcdn.net/v/t1.0-0/s206x206/67623070_1513383675469863_7139297301738029056_n.jpg?_nc_cat=106&_nc_oc=AQlDpAwagXzUiYMNII1OTEUgF_hbe4JsVVXtGQrh4NdQdiCOyqobyD8Yp0kAqS7q6Kl9ywuetZvDPdqneKAU3pIa&_nc_ht=scontent.fsgn5-6.fna&oh=979a38f27a9022b4abb79921f421f9e4&oe=5E33A071","Nguyễn Phúc Hậu",70,520,mDishyList));
        mChefs.add(new Chef("https://scontent.fsgn5-3.fna.fbcdn.net/v/t1.0-1/p320x320/70205972_1445859698901960_6020314693128683520_n.jpg?_nc_cat=111&_nc_oc=AQlqW0sH4rpBiS2IPFfCEaorz-_7CDmDvZCV3YdL5u0-dyJcqxhMRJMtySaDEMPjS-uGvtyeUqP4ZJT4328aZLhU&_nc_ht=scontent.fsgn5-3.fna&oh=ea35b802e27df0b8c9f7bc852baec68f&oe=5E023271","Nguyễn Hoàng Bá Khánh",60,450,mDishyList));
        mChefs.add(new Chef("https://scontent.fsgn5-2.fna.fbcdn.net/v/t1.0-1/p320x320/53412001_630154360777669_6753580234643079168_n.jpg?_nc_cat=105&_nc_oc=AQke1iRQnNv-Oa0QHsOIrHt-ZImOFADfaBh2P6WoMF4Np-Cz0vTY6KAE_rkYdWzNoB5kekgk2Jk08fOMI55IYj1v&_nc_ht=scontent.fsgn5-2.fna&oh=43c8e8a45e0d7d2ba4c66235fa403110&oe=5E00C2A0","Nguyễn Nghĩa Mai Linh",50,430,mDishyList));
        mChefs.add(new Chef("https://scontent.fsgn5-1.fna.fbcdn.net/v/t1.0-1/p320x320/983876_369442600117243_1445371059219521621_n.jpg?_nc_cat=101&_nc_oc=AQlJTywK2U-4NaFc2ikP6TZY-Q6jQxc3vEog1YcOSfe4E08-YxspR4aCkzNzivL3qbAVczrAaelzFrveGJqtw_m9&_nc_ht=scontent.fsgn5-1.fna&oh=591e9cc67683820744e9363778dfcfb3&oe=5E2CA73B","Nguyễn Bảo Thiện",30,390,mDishyList));
        mChefs.add(new Chef("https://scontent.fsgn5-2.fna.fbcdn.net/v/t1.0-1/c0.0.320.320a/p320x320/10599638_1504520149789789_4487427289442049165_n.jpg?_nc_cat=107&_nc_oc=AQne8gyZOiKbnc5zvKNLPtE9JeuC3flPcvR_za52mOc-3TbE4W7PH4f7z6JNwOznFtH-JPIglXn769P5Kl4ORJ0e&_nc_ht=scontent.fsgn5-2.fna&oh=4a4dbfc66aa3a1fb5aeeefa754ce422f&oe=5E2E96E2","Nguyễn Văn Lương",20,300,mDishyList));
        mChefs.add(new Chef("https://scontent.fsgn5-4.fna.fbcdn.net/v/t1.0-1/p320x320/56922724_993070917567979_1385984228432281600_n.jpg?_nc_cat=104&_nc_oc=AQkclC0oXgatAne3ddan4uDnoLHScDDXh1r4TaQB4lHiZI5efE7WrAqUxsCP2IXJpKAKVPEx_GNkxUvsJI1k4M2u&_nc_ht=scontent.fsgn5-4.fna&oh=1811529e821ba45253c10d35236a335b&oe=5DF418A8","Dương Đức Duy ",10,100,mDishyList));
        updateUIRcvTopChef(mChefs);
    }

    private void updateUIRcvDishyToDay(List<Dishy> dishyList) {
        if (mDishyTodayAdapter == null) {
            mDishyTodayAdapter = new DishyTodayAdapter(getContext(), dishyList);
            mRcvDishyToday.setAdapter(mDishyTodayAdapter);
            mDishyTodayAdapter.setmOnDishyToDayClickListener(new DishyTodayAdapter.OnDishyToDayClickListener() {
                @Override
                public void onClick(Dishy dishy) {
                    Intent intent = new Intent(getContext(), RecipeActivity.class);
                    intent.putExtra("DISHY",dishy);
                    startActivity(intent);
                }
            });
        } else {
            mDishyTodayAdapter.notifyDataSetChanged();
        }
    }

    private void updateUIRcvTopDishy(List<Dishy> topDishy){
        if (mTopDishyAdapter==null){
            mTopDishyAdapter =  new TopDishyAdapter(getContext(),topDishy);
            mRcvTopDishy.setAdapter(mTopDishyAdapter);
        }else{
            mTopDishyAdapter.notifyDataSetChanged();
        }
    }

    private void updateUIRcvTopChef(List<Chef> chefs){
        if (mTopChefAdapter==null){
            mTopChefAdapter =  new TopChefAdapter(getContext(),chefs);
            mRcvTopChef.setAdapter(mTopChefAdapter);
            mTopChefAdapter.setmOnTopChefClickListener(new TopChefAdapter.OnTopChefClickListener() {
                @Override
                public void onClick(Chef chef) {
                    Intent intent = new Intent(getContext(), ChefActivity.class);
                    intent.putExtra("CHEF",chef);
                    startActivity(intent);
                }
            });
        }else{
            mTopChefAdapter.notifyDataSetChanged();
        }
    }
}
