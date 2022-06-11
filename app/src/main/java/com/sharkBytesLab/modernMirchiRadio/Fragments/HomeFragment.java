package com.sharkBytesLab.modernMirchiRadio.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sharkBytesLab.modernMirchiRadio.Adapters.HorizontalAdapter;
import com.sharkBytesLab.modernMirchiRadio.R;
import com.takusemba.multisnaprecyclerview.MultiSnapRecyclerView;


public class HomeFragment extends Fragment {


    private int[] radioImagesFirst = {R.drawable.radiomirchi};
    private int[] radioImagesSecond = {R.drawable.bigfm, R.drawable.vividhbharati, R.drawable.airfmgold, R.drawable.airfmrainbow, R.drawable.radiocity};

    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        HorizontalAdapter firstAdapter = new HorizontalAdapter(radioImagesFirst);
        MultiSnapRecyclerView firstRecyclerView = view.findViewById(R.id.first_recycler_view);
        LinearLayoutManager firstManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        firstRecyclerView.setLayoutManager(firstManager);
        firstRecyclerView.setAdapter(firstAdapter);

        HorizontalAdapter secondAdapter = new HorizontalAdapter(radioImagesSecond);
        MultiSnapRecyclerView secondRecyclerView = view.findViewById(R.id.second_recycler_view);
        LinearLayoutManager secondManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        secondRecyclerView.setLayoutManager(secondManager);
        secondRecyclerView.setAdapter(secondAdapter);

        return view;
    }
}