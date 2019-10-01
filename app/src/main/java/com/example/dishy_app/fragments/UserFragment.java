package com.example.dishy_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dishy_app.R;
import com.example.dishy_app.adaptes.ItemConcernAdapter;
import com.example.dishy_app.models.ItemConcern;

import java.util.ArrayList;
import java.util.List;


public class UserFragment extends Fragment {
    private View mView;
    private RecyclerView mRecycleView;
    private ItemConcernAdapter mItemConcernAdapter;
    private List<ItemConcern> items;

    public static UserFragment newInstance() {
        UserFragment fragment = new UserFragment();
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
        mView = inflater.inflate(R.layout.fragment_user, container, false);
        initView();
        initData();
        return mView;
    }

    private void initView() {
        mRecycleView = mView.findViewById(R.id.rcv_concern);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        mRecycleView.setLayoutManager(linearLayoutManager);

    }

    private void initData() {
        if (items == null) {
            items = new ArrayList<ItemConcern>();
        }

        items.add(new ItemConcern(R.mipmap.ic_pizza, "Pizza"));
        items.add(new ItemConcern(R.mipmap.ic_cake, "Cake"));
        items.add(new ItemConcern(R.mipmap.ic_sushi, "Sushi"));
        items.add(new ItemConcern(R.mipmap.ic_pizza, "Pizza Italy"));
        items.add(new ItemConcern(R.mipmap.ic_cake, "Cake New York"));
        items.add(new ItemConcern(R.mipmap.ic_sushi, "Sushi Janpan"));
        items.add(new ItemConcern(R.mipmap.ic_pizza, "Pizza Germany"));
        items.add(new ItemConcern(R.mipmap.ic_cake, "Cake Australia"));
        items.add(new ItemConcern(R.mipmap.ic_sushi, "Sushi Bruney"));
        items.add(new ItemConcern(R.mipmap.ic_pizza, "Pizza A"));
        items.add(new ItemConcern(R.mipmap.ic_cake, "Cake A"));
        items.add(new ItemConcern(R.mipmap.ic_sushi, "Sushi A"));
        items.add(new ItemConcern(R.mipmap.ic_pizza, "Pizza B"));
        items.add(new ItemConcern(R.mipmap.ic_cake, "Cake B"));
        items.add(new ItemConcern(R.mipmap.ic_sushi, "Sushi B"));
        items.add(new ItemConcern(R.mipmap.ic_pizza, "Pizza C"));
        items.add(new ItemConcern(R.mipmap.ic_cake, "Cake C"));
        items.add(new ItemConcern(R.mipmap.ic_sushi, "Sushi C"));

        updateRcv();
    }

    private void updateRcv() {
        if (mItemConcernAdapter == null) {
            mItemConcernAdapter = new ItemConcernAdapter(getContext(), items);
            mRecycleView.setAdapter(mItemConcernAdapter);
        } else {
            mItemConcernAdapter.notifyDataSetChanged();
        }
    }

}
