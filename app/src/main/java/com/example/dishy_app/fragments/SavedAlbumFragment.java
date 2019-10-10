package com.example.dishy_app.fragments;

import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dishy_app.R;
import com.example.dishy_app.adaptes.AlbumAdapter;
import com.example.dishy_app.models.Dishy;

import java.util.ArrayList;
import java.util.List;

public class SavedAlbumFragment extends Fragment {

    private View mView;
    private RecyclerView rcv_saved_ablum;
    private List<Dishy> dishies;
    private AlbumAdapter albumAdapter;

    public static SavedAlbumFragment newInstance() {
        SavedAlbumFragment savedAlbumFragment = new SavedAlbumFragment();
        Bundle args = new Bundle();
        savedAlbumFragment.setArguments(args);
        return savedAlbumFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_saved_album, container, false);
        initView();
        initData();

        return mView;
    }

    private void initView() {
        rcv_saved_ablum = mView.findViewById(R.id.rcv_saved_album);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        rcv_saved_ablum.setLayoutManager(gridLayoutManager);
    }

    private void initData() {
        dishies = new ArrayList<>();
        dishies.add(new Dishy("Gà sốt phô mai", "https://znews-photo.zadn.vn/w660/Uploaded/Ohunoaa/2016_12_31/d6.jpg", "10 phút", 4, 50));
        dishies.add(new Dishy("Lẩu thái", "https://bepmenau.com/wp-content/uploads/2018/05/Lau-Thai-hai-san_8_1.1.359_1124X1685.jpeg", "34 phút", 5, 50));
        dishies.add(new Dishy("Kimbap chiên xù", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRqGelogsMrJv1R3tkdQXER63ewilYAUzG4UAO0KWIfSZpGWSn", "12 phút", 2, 30));
        dishies.add(new Dishy("Bánh chocolate", "https://images.pexels.com/photos/3026810/pexels-photo-3026810.jpeg?cs=srgb&amp;dl=avocado-chocolate-dessert-3026810.jpg&amp;fm=jpg", "26 phút", 4, 54));
        dishies.add(new Dishy("Tôm ghim chua ngọt", "https://images.pexels.com/photos/699544/pexels-photo-699544.jpeg?cs=srgb&amp;dl=chopsticks-cuisine-delicious-699544.jpg&amp;fm=jpg", "20 phút", 4, 30));
        dishies.add(new Dishy("Bún đậu mắm tôm", "https://vnn-imgs-f.vgcloud.vn/2018/09/18/12/cach-lam-bun-dau-mam-tom-ngon-nhu-cua-ba-noi-phim-gao-nep-gao-te.jpg", "15 phút", 3, 34));

        updateRcvDishy(dishies);
    }

    private void updateRcvDishy(List<Dishy> dishies) {
        if (albumAdapter == null) {
            albumAdapter = new AlbumAdapter(getContext(), dishies);
            rcv_saved_ablum.setAdapter(albumAdapter);
        } else {
            albumAdapter.notifyDataSetChanged();
        }
    }
}
